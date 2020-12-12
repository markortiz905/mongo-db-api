package com.system.customer;

import com.system.customer.entities.Customer;
import com.system.customer.services.CustomerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author Mark Anthony Ortiz - ortizmark905@gmail.com
 */
@SpringBootApplication
public class MongoDbApiApplication {

	public static void main(String[] args) {
		// Enable MongoDB logging in general
		//System.setProperty("DEBUG.MONGO", "true");

		SpringApplication.run(MongoDbApiApplication.class, args);
	}

	@Bean
	public CommandLineRunner executeQuery(CustomerService customerService) {
		return (args) -> {

			customerService.create(new Customer("Rechel Girl", "Ortiz", "2019-06-22 00:00:00",
					"ortizmark905@gmail.com", "Female", "One Oasis Condominium", "Pasig City",
					"2020-11-10 00:00:00", "2020-11-10 00:00:00"));

			customerService.findCustomerByFirstName("Mark").forEach(System.out::println);
		};
	}

}
