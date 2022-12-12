package CareersService.Assignment3.Entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class JobResponse {
    private int job_id;
    private String job_name;
    private double java_exp;
    private double spring_exp;
    private String status;
}
