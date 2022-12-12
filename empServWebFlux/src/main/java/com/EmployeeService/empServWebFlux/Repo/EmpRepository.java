package com.EmployeeService.empServWebFlux.Repo;

import com.EmployeeService.empServWebFlux.Entity.EmployeeMain;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface EmpRepository extends ReactiveCassandraRepository<EmployeeMain, Integer> {

    @AllowFiltering
    @Query(value ="emp_name" )
    Flux<EmployeeMain> findByempName(String emp_name);

    Flux<EmployeeMain> findByemployeeId(Integer emp_id);

    Mono<Boolean> existsByemployeeId(Integer emp_id);
}
