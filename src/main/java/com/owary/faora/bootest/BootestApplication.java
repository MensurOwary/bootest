package com.owary.faora.bootest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.owary.faora.bootest")
public class BootestApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootestApplication.class, args);
	}
}
