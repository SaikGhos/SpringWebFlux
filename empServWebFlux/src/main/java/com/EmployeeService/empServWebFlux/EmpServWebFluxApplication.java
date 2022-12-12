package com.EmployeeService.empServWebFlux;

import com.EmployeeService.empServWebFlux.Connection.DataStaxAstraDBProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.cassandra.CqlSessionBuilderCustomizer;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.nio.file.Path;

@SpringBootApplication
@EnableConfigurationProperties(DataStaxAstraDBProperties.class)
public class EmpServWebFluxApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpServWebFluxApplication.class, args);
	}

	@Bean
	public CqlSessionBuilderCustomizer sessionBuilderCustomizer(DataStaxAstraDBProperties astraProperties) {
		Path bundle = astraProperties.getSecureConnectBundle().toPath();
		return builder -> builder.withCloudSecureConnectBundle(bundle);
	}
}
