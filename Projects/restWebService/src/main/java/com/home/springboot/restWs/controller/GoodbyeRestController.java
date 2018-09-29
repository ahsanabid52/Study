package com.home.springboot.restWs.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.home.springboot.restWs.beans.Goodbye;

@RestController
@RequestMapping("/goodbye")
public class GoodbyeRestController {
	private static final String template = "%s from Ahsan Abid!";
	private final AtomicLong counter = new AtomicLong();

	@RequestMapping("/greeting")
	public Goodbye goodbye(@RequestParam(defaultValue = "Hello World", name = "message") String name) {
		return new Goodbye(counter.incrementAndGet(), String.format(template, name));
	}

	@RequestMapping("/echo")
	public Goodbye echoHelloWorld(@RequestParam(defaultValue = "Hello World", name = "message") String name) {
		return new Goodbye(counter.incrementAndGet(), name);
	}
}