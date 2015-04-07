package com.dental.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by light on 1/6/2015.
 */

@Configuration
@ComponentScan(basePackages = "com.dental")
@Import({SpringConfig.class, DaoConfig.class, SpringSecureConfig.class})
public class AppConfig {

    @Bean
    public com.dental.Bean getBean() {
        return new com.dental.Bean();
    }

}
