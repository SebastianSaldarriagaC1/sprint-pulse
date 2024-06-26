package com.ssaldarriaga.sprintpulse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SprintPulseApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SprintPulseApiApplication.class, args);
	}

}
