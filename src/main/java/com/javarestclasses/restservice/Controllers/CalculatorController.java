package com.javarestclasses.restservice.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {
	
	@GetMapping("/sum")
	public Integer sum(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b) {
		return a + b;
	}
}
