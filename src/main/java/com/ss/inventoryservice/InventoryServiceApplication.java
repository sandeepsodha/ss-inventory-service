package com.ss.inventoryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args)
	{
		new SpringApplicationBuilder()
				.profiles("dev")
				.sources(InventoryServiceApplication.class)
				.run(args);
	}
}
