package com.github.stehrn.mood;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.map.repository.config.EnableMapRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@Slf4j
public class Application {

	public static void main(String[] args) {
		log.info("Starting mood service");
		SpringApplication.run(Application.class, args);
	}
}
