package com.orderinventory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.orderinventory.services.OrderServices;

@SpringBootApplication
public class OrderInventoryBackEndApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderInventoryBackEndApplication.class, args);
	}

}
