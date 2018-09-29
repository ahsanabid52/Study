package com.home.springboot.startup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloWorldSpringBootApplication {
	private static int count = 0;
	static {
		System.out.println("Hello World."+ (++count));
	}

	public static void main(String[] args) {
		SpringApplication.run(HelloWorldSpringBootApplication.class, args);
	}
}
