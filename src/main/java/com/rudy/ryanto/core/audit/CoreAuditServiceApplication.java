package com.rudy.ryanto.core.audit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@EnableEurekaClient
@SpringBootApplication
public class CoreAuditServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoreAuditServiceApplication.class, args);
	}

}
