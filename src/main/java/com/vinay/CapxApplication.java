package com.vinay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class CapxApplication {

	public static void main(String[] args) {
        
		SpringApplication.run(CapxApplication.class, args);
		System.out.println("Project Running........!");
	}

}
