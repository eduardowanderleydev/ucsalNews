package br.ucsal.ucsalnews;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication WebMvcConfigurer(exclude = {SecurityAutoConfiguration.class})
public class UcsalNewsApplication implements WebMvcConfigurer {


    public static void main(String[] args) {
        SpringApplication.run(UcsalNewsApplication.class, args);
    }

}