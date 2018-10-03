package com.home.springboot.startup;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class sample {

	@RequestMapping("/helloworld")
	public String helloworld() {
		return "helloworld 2";
	}

}
