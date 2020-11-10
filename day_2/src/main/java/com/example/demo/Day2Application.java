package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
//@EnableGlobalMethodSecurity(jsr250Enabled = true)
public class Day2Application {

	public static void main(String[] args) {
		SpringApplication.run(Day2Application.class, args);
	}

}
