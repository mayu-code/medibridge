package com.main.medibridge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class MedibridgeApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedibridgeApplication.class, args);
	}

}
