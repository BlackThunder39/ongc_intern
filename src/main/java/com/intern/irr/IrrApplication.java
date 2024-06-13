package com.intern.irr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.UUID;

@SpringBootApplication
@ComponentScan("com.intern")
public class IrrApplication {

	public static void main(String[] args) {
		UUID u = UUID.randomUUID();
		SpringApplication.run(IrrApplication.class, args);
	}


}
