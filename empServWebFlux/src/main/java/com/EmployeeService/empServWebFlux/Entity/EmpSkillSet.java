package com.EmployeeService.empServWebFlux.Entity;

import lombok.*;
import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(value = "emp_skill")
public class EmpSkillSet {

    @PrimaryKeyColumn(name = "emp_id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private int employeeId;

    @PrimaryKeyColumn(name = "java_exp", ordinal = 1, type = PrimaryKeyType.CLUSTERED, ordering = Ordering.DESCENDING)
    private double javaExperience;

    @PrimaryKeyColumn(name = "spring_exp", ordinal = 2, type = PrimaryKeyType.CLUSTERED, ordering = Ordering.DESCENDING)
    private double springExperience;

}
