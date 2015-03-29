package com.dental.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by light on 1/6/2015.
 */

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.dental")
@Import({SpringConfig.class, DaoConfig.class})
public class AppConfig {


    @Bean
    public com.dental.Bean getBean() {
        return new com.dental.Bean();
    }

}
