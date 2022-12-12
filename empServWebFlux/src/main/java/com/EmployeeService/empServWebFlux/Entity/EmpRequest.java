package com.EmployeeService.empServWebFlux.Entity;

import lombok.*;
import javax.validation.constraints.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
//@ToString
public class EmpRequest {

    @NotNull(message="primary id cannot be null")
    private int emp_id;

    private String emp_name;
    @NotBlank
    private String emp_city;
    @NotBlank
    private String emp_phone;
    @NotNull
    private double java_exp;
    @NotNull
    private double spring_exp;

    @Override
    public String toString() {
        return "EmpRequest{" +
                "emp_id=" + emp_id + '\'' +
                ", emp_name='" + emp_name + '\'' +
                ", emp_city='" + emp_city + '\'' +
                ", emp_phone='" + emp_phone + '\'' +
                ", java_exp=" + java_exp + '\'' +
                ", spring_exp=" + spring_exp +'\'' +
                '}';
    }
}
