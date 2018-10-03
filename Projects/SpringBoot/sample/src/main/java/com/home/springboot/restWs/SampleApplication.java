package com.home.springboot.restWs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SampleApplication {

	public static void main(String[] args) {
		
		MyApplication app = new MyApplication();
		app.setService(new EmailService());
		app.processMessage("sample", "rec");
		
		SpringApplication.run(SampleApplication.class, args);
	}
}
