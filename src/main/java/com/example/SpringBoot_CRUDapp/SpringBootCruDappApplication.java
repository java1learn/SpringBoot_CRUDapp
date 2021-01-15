package com.example.SpringBoot_CRUDapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class SpringBootCruDappApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCruDappApplication.class, args);
	}

}
