package com.EmployeeService.empServWebFlux.Controllers;

import com.EmployeeService.empServWebFlux.Entity.EmpRequest;
import com.EmployeeService.empServWebFlux.Entity.EmpResponse;
import com.EmployeeService.empServWebFlux.Service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
public class EmpMainController {


    @Autowired
    private EmpService empService;

    @PostMapping("/createEmployee")
    Mono<EmpResponse> createEmployeeMain(@RequestBody @Valid EmpRequest empRequest){
        return empService.createEmployeeMain(empRequest);
    }

    @GetMapping("/findEmpSkillSet/{exp}")
    Flux<EmpRequest> findAllJavaGreater(@PathVariable double exp){
        return empService.findByJavaExp(exp);
    }

    /*@GetMapping("/SpringExpGreaterThan/{exp}")
    Flux<EmpRequest> findAllSpringGreater(@PathVariable double exp){
        return empService.findBySpringExp(exp);
    }*/
}