package br.com.angie.theangietalks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class) //momentaneo, para excluir o login do security e manter os endpoints abertos
public class TheangietalksApplication {

	public static void main(String[] args) {
		SpringApplication.run(TheangietalksApplication.class, args);
	}

}
