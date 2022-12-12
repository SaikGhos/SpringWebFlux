package CareersService.Assignment3.Controller;

import CareersService.Assignment3.Entity.EmployeeResponse;
import CareersService.Assignment3.Entity.Job;
import CareersService.Assignment3.Entity.JobResponse;
import CareersService.Assignment3.Service.CareersServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
public class CareersControllers {

    @Autowired
    private CareersServices careersServices;

    @PostMapping("/createJobProfile")
    public Mono<JobResponse> createJob(@RequestBody @Valid Job job){
        return this.careersServices.createJob(job);
    }
    @GetMapping("/findEmpForJobId/{jobId}")
    public Flux<EmployeeResponse> findEmpForJobId(@PathVariable("jobId") int jobId){
        return this.careersServices.findEmpForJobId(jobId);
    }
    @GetMapping("/getJobProfileFromCache/{jobId}")
    public Mono<Job> getJobProfileFromCache(@PathVariable("jobId") int jobId){
        return this.careersServices.getJobProfileFromCache(jobId);
    }
}
