package CareersService.Assignment3.Service;

import CareersService.Assignment3.Entity.EmployeeResponse;
import CareersService.Assignment3.Entity.Job;
import CareersService.Assignment3.Entity.JobResponse;
import CareersService.Assignment3.Repo.JobDtoRepository;
import CareersService.Assignment3.Repo.JobRepository;
import com.hazelcast.map.IMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CareersServices {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private JobDtoRepository jobDtoRepository;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @Autowired
    private IMap<Integer, Job> userCache;

    public Mono<JobResponse> createJob(Job job) {
        return jobRepository.existsByJobId(job.getJobId())
                .flatMap(aBoolean -> {
                            if(aBoolean){
                                return Mono.just(new JobResponse(job.getJobId(),job.getJobName(),
                                        job.getJavaExp(),job.getSpringExp(),"Already Exists"));
                            }
                            else{
                                return jobRepository.save(job).
                                        map(j-> new JobResponse(job.getJobId(),job.getJobName(),
                                                job.getJavaExp(),job.getSpringExp(),"Created"));

                            }

                        }
                );
    }

    public Flux<EmployeeResponse> findEmpForJobId(int jobId){

        Flux<EmployeeResponse> employeeFlux = jobRepository.findByJobId(jobId).flatMap(job -> {

            return webClientBuilder.build()
                    .get()
                    .uri("http://localhost:8080/findEmpSkillSet/" + job.getJavaExp())
                    .retrieve()
                    .bodyToFlux(EmployeeResponse.class);


        });
        return employeeFlux;

    }

    public Mono<Job> getJobProfileFromCache(int id) {

        Mono<Job> result = getUserFromCache(id);
        return   result
                .switchIfEmpty(getUserFromDB(id))
                .flatMap(user -> saveUserToCache(user));
    }

    private Mono<Job> getUserFromCache(int id) {
        return Mono.fromCompletionStage(userCache.getAsync(id));
    }
    private Mono<? extends Job> saveUserToCache(Job user) {
        userCache.setAsync(user.getJobId(), user);
        return Mono.just(user);
    }
    private Mono<Job> getUserFromDB(int id) {
        return jobDtoRepository.findByJobId(id);
    }

}
