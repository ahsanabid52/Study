package com.home.springboot.restWs.beans;

public class Greeting {

	final long id;
	final String message;

	public Greeting(long id, String message) {
		super();
		this.id = id;
		this.message = message;
	}

	public long getId() {
		return id;
	}

	public String getMessage() {
		return message;
	}

}
