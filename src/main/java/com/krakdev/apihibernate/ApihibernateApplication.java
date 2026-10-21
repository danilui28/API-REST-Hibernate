package com.krakdev.apihibernate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.krakdev")
@EntityScan(basePackages = "com.krakdev.peliculas.entidades")
@EnableJpaRepositories(basePackages = "com.krakdev.peliculas.repository")
public class ApihibernateApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApihibernateApplication.class, args);
	}

}
