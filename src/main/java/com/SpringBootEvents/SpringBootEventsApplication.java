package com.SpringBootEvents;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringBootEventsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootEventsApplication.class, args);
	}
}
