package com.zxy.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages={"com.zxy.admin.dao","com.zxy.admin.web"})
@EntityScan(basePackages={"com.zxy.admin.entities"})*/
@SpringBootApplication
public class Application {
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
