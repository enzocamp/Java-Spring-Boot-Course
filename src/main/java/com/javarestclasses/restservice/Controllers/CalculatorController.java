package com.javarestclasses.restservice.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

@RestController
public class CalculatorController {

	@GetMapping("/calc")
	public double calc(@RequestParam(value = "formula") String formula) {
		try {
			System.out.println(formula);
			Expression expression = new ExpressionBuilder(formula).build();
		    double result = expression.evaluate();
		    return result;
		} catch (ArithmeticException ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Check your formula");
		}
	}
}
