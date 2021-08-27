package com.project.traveler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.project.traveler.*"})
public class TravelerApplication {
	public static void main(String[] args) {
		SpringApplication.run(TravelerApplication.class, args);
	}
}
