package br.ucsal.ucsalnews.config;

import br.ucsal.ucsalnews.service.impl.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class TestConfig {

    @Autowired
    private DBService service;

    @Bean
    public void instatiateDatabase() {
        service.instantiateTestDatabase();
    }
}
