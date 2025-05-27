package com.example.todolist;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = "com.example.todolist")
public class TodolistApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodolistApplication.class, args);
	}

	@Bean
	CommandLineRunner testBean(ApplicationContext ctx) {
		return args -> {
			System.out.println("Beans disponíveis:");
			for (String name : ctx.getBeanDefinitionNames()) {
				if (name.toLowerCase().contains("customuser")) {
					System.out.println("✅ ENCONTRADO: " + name);
				}
			}
		};
	}

}
