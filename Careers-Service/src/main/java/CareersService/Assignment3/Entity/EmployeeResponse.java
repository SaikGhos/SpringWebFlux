package CareersService.Assignment3.Entity;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeResponse {

    private int emp_id;
    private String emp_name;
    private String emp_city;
    private String emp_phone;
    private double java_exp;
    private double spring_exp;

}
