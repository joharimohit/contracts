package com.example.demo.controllers;

import java.util.concurrent.atomic.AtomicLong;

import com.example.demo.service.Invoice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/iconcile/contracts")
public class ContractController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/services")
	public Invoice invoices(@RequestParam(value = "name", defaultValue = "invoice 1!") String name) {
		return new Invoice(counter.incrementAndGet(), String.format(template, name));
	}
}