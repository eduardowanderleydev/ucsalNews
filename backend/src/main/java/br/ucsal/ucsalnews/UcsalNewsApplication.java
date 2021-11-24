package br.ucsal.ucsalnews;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class UcsalNewsApplication {

	public static void main(String[] args) {
		SpringApplication.run(UcsalNewsApplication.class, args);
	}

}
