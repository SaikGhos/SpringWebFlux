package CareersService.Assignment3.Repo;

import CareersService.Assignment3.Entity.Job;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface JobRepository extends ReactiveCassandraRepository<Job,Integer> {

    @AllowFiltering
    Mono<Boolean> existsByJobId(int job_id);
    @AllowFiltering
    Flux<Job> findByJobId(int jobId);

}
