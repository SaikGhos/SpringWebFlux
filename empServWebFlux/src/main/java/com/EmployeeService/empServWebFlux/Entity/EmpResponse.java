package com.EmployeeService.empServWebFlux.Entity;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmpResponse {
    private int emp_id;
    private String emp_name;
    private String emp_city;
    private String emp_phone;

    private double java_exp;

    private double spring_exp;

    private String status;

}
