package com.EmployeeService.empServWebFlux.Repo;

import com.EmployeeService.empServWebFlux.Entity.EmpSkillSet;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface EmpSkillSetRepository extends ReactiveCassandraRepository<EmpSkillSet, Integer> {

    @AllowFiltering
    Mono<EmpSkillSet> findByemployeeId(Integer emp_id);

    @AllowFiltering
    Flux<EmpSkillSet> findByjavaExperienceGreaterThan(double java_exp);

    /*@AllowFiltering
    Flux<EmpSkillSet> findByspringExperienceGreaterThan(double java_exp);*/
}
