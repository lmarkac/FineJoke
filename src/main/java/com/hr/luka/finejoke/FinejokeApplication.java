package com.hr.luka.finejoke;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class FinejokeApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinejokeApplication.class, args);
	}

}
