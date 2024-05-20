package com.example.librarymanagesystemborrowerservice.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public ModelMapper setMapper(){
        return new ModelMapper();
    }
}
