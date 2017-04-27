package com.investor;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.*;

@Configuration
@EnableAutoConfiguration
@ComponentScan

public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}