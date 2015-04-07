package com.dental.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

/**
 * Created by light on 1/6/2015.
 */

@EnableWebMvc

@Configuration
public class SpringConfig extends WebMvcConfigurerAdapter {
    private static final String BOOTSTRAP_PATH = "classpath:/META-INF/resources/webjars/bootstrap/3.3.4/";
    private final String CSS_RESOURCE = "/css/**";
    private final String CSS_RESOURCE_LOCATION = "/assets/css/";
    private final String CSS_RESOURCE_LOCATION_BOOTSTRAP = BOOTSTRAP_PATH + "css/";
    private final String JS_RESOURCE = "/js/**";
    private final String JS_RESOURCE_LOCATION = "/assets/js/";
    private final String JS_RESOURCE_LOCATION_BOOTSTRAP = BOOTSTRAP_PATH + "js/";
    private final String FONT_RESOURCE = "/fonts/**";
    private final String FONT_RESOURCE_LOCATION = BOOTSTRAP_PATH + "fonts/";
    private final String IMAGE_RESOURCE = "/img/**";
    private final String IMAGE_RESOURCE_LOCATION = "/assets/img/";

    @Bean
    public ViewResolver viewResolver() {
        FreeMarkerViewResolver viewResolver = new FreeMarkerViewResolver();
        viewResolver.setCache(true);
        viewResolver.setPrefix("/");
        viewResolver.setSuffix(".ftl");
        viewResolver.setExposeSpringMacroHelpers(true);
        return viewResolver;
    }

    @Bean(name = "freemarkerConfig")
    public FreeMarkerConfigurer getFreeMarkerConfigurer() {
        FreeMarkerConfigurer freeMarkerConfigurer = new FreeMarkerConfigurer();
        freeMarkerConfigurer.setTemplateLoaderPath("WEB-INF/pages/");
        return freeMarkerConfigurer;
    }

    @Bean(name = "messageSource")
    public MessageSource getMessageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("multi.data");
        messageSource.setDefaultEncoding("utf-8");
        return messageSource;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(CSS_RESOURCE).addResourceLocations(CSS_RESOURCE_LOCATION, CSS_RESOURCE_LOCATION_BOOTSTRAP);
        registry.addResourceHandler(JS_RESOURCE).addResourceLocations(JS_RESOURCE_LOCATION, JS_RESOURCE_LOCATION_BOOTSTRAP);
        registry.addResourceHandler(FONT_RESOURCE).addResourceLocations(FONT_RESOURCE_LOCATION, FONT_RESOURCE_LOCATION);
        registry.addResourceHandler(IMAGE_RESOURCE).addResourceLocations(IMAGE_RESOURCE_LOCATION);
    }
}