package com.assetmanagement;

import com.assetmanagement.models.Employee;
import com.assetmanagement.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class AssetmanagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssetmanagementApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(EmployeeRepository repo) {
		return args -> {
			repo.save(new Employee(501, "Smith", "SDE1"));
			repo.save(new Employee(502, "Johnson", "QA"));
		};
	}
}
