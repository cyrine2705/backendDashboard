package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class BackendRhApplication {
private MongoTemplate mongoTemplate;
	public static void main(String[] args) {
		SpringApplication.run(BackendRhApplication.class, args);
	}

}
