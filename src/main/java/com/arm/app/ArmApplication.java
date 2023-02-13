package com.arm.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.*"})
public class ArmApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArmApplication.class, args);
	}

}
