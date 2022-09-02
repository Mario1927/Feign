package com.back.actividad01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class Actividad01Application {

	public static void main(String[] args) {
		SpringApplication.run(Actividad01Application.class, args);
	}

}
