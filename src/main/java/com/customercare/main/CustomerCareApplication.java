package com.customercare.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.customercare")
@EnableJpaRepositories(basePackages = "com.customercare.repository")
@EntityScan(basePackages = "com.customercare.entity")
public class CustomerCareApplication {

	public static void main(String[] args) throws InterruptedException {
	SpringApplication.run(CustomerCareApplication.class, args);

//HelpDeskBackendApplication CustomerCare

    }

}
