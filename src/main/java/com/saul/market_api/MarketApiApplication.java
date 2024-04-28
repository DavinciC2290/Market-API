package com.saul.market_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;


@ComponentScan({"com.saul.market_api"})

@SpringBootApplication
public class MarketApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarketApiApplication.class, args);
	}

}
