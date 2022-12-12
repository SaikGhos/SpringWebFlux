package CareersService.Assignment3.Entity;

import com.hazelcast.org.snakeyaml.engine.v2.api.lowlevel.Serialize;
import lombok.*;
import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(value = "job")
public class Job implements Serializable {

    @NotNull(message = "job id cannot be null")
    @PrimaryKeyColumn(value = "job_id", ordinal = 0,type = PrimaryKeyType.PARTITIONED)
    private int jobId;

    @NotBlank(message = "job name cannot be blank")
    @Column(value = "job_name")
    @CassandraType(type = CassandraType.Name.TEXT)
    private String jobName;

    @NotNull(message = "java experience cannot be null")
    @PrimaryKeyColumn(value="java_exp",ordinal = 1, type= PrimaryKeyType.CLUSTERED,ordering = Ordering.DESCENDING)
    private double javaExp;

    @NotNull(message = "spring experience cannot be null")
    @PrimaryKeyColumn(value="spring_exp",ordinal = 2, type = PrimaryKeyType.CLUSTERED, ordering = Ordering.DESCENDING)
    private double springExp;
}
