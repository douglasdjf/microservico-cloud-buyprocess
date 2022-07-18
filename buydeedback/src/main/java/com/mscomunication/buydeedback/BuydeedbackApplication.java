package com.mscomunication.buydeedback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@SpringBootApplication
@EnableRedisRepositories
public class BuydeedbackApplication {

	public static void main(String[] args) {
		SpringApplication.run(BuydeedbackApplication.class, args);
	}

}
