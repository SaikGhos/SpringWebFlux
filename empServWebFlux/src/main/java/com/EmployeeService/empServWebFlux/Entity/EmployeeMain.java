package com.EmployeeService.empServWebFlux.Entity;

import lombok.*;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(value = "emp")
public class EmployeeMain {

    @PrimaryKeyColumn(name = "emp_id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private int employeeId;
    @Column("emp_name")
    @CassandraType(type = CassandraType.Name.TEXT)
    private String employeeName;
    @Column("emp_city")
    @CassandraType(type = CassandraType.Name.TEXT)
    private String employeeCity;
    @Column("emp_phone")
    @CassandraType(type = CassandraType.Name.TEXT)
    private String employeePhone;

}
