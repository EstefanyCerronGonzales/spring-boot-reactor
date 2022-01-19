package com.pe.springboot.reactor.app;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@Slf4j
@SpringBootApplication
public class SpringBootReactorApplication implements CommandLineRunner {

	public static void main(String[] args) {
		
		SpringApplication.run(SpringBootReactorApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
	}
}
