package com.javali.gleif.elvesmatcher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

/**
 * @author javali on 31.12.2020.
 */
@SpringBootApplication
public class ElvesMatcherRestApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(ElvesMatcherRestApplication.class);
		app.setDefaultProperties(Collections.singletonMap("server.port", "8084"));
		app.run(args);
	}
}
