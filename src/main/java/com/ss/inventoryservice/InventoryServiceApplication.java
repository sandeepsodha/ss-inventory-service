package com.ss.inventoryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableJms
public class InventoryServiceApplication {

	public static void main(String[] args)
	{
		new SpringApplicationBuilder()
				.profiles("dev")
				.sources(InventoryServiceApplication.class)
				.run(args);
	}
	@Bean
	public WebClient.Builder loadBalancedWebClientBuilder()
	{
		return WebClient.builder();
	}
}
