package com.springboot.oauth2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.springboot.oauth2")
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
