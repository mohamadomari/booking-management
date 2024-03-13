package com.fintechpath.booking;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
//test for new branch
@SpringBootApplication
@EnableFeignClients
@OpenAPIDefinition(
		info = @Info(title = "Booking API",version = "1.0.0"),
		servers = {@Server(url = "http://localhost:8080"),@Server(url = "http://omari.com")}
)
public class BookingApplication {
	public static void main(String[] args)
	{
		SpringApplication.run(BookingApplication.class, args);
	}

}
