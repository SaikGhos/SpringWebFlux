package CareersService.Assignment3.Repo;

import CareersService.Assignment3.Entity.Job;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface JobDtoRepository extends ReactiveCassandraRepository<Job,Integer> {

    @AllowFiltering
    Mono<Job> findByJobId(int jobId);

}
