package com.microservicePost;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DemoPostApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoPostApplication.class, args);
	}

}
