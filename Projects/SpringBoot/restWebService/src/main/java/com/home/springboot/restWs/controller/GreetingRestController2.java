package com.home.springboot.restWs.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.home.springboot.restWs.beans.Greeting;

@RestController
@RequestMapping("/hello2")
public class GreetingRestController2 {
	private static final String template = "%s from Ahsan Abid!";
	private final AtomicLong counter = new AtomicLong();

	@RequestMapping("/greeting")
	public Greeting greeting(@RequestParam(defaultValue = "Hello World", name = "message") String name) {
		System.out.println("greetings");
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

	@RequestMapping("/echo")
	public Greeting echoHelloWorld(@RequestParam(defaultValue = "Hello World", name = "message") String name) {
		System.out.println("echo");
		return new Greeting(counter.incrementAndGet(), name);
	}

}