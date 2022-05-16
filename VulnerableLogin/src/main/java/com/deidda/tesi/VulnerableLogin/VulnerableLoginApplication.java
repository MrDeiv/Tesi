package com.deidda.tesi.VulnerableLogin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SpringBootApplication
public class VulnerableLoginApplication {

	private static final Logger LOGGER = LogManager.getLogger(VulnerableLoginApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(VulnerableLoginApplication.class, args);
		LOGGER.info("Application started");
	}

}
