package com.dental.config;

import com.dental.init.LoggedDentistMethodParameterResolver;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import java.util.List;
import java.util.Locale;

/**
 * Created by light on 1/6/2015.
 */

@EnableWebMvc
@Configuration
//@Profile("one")
public class SpringConfig extends WebMvcConfigurerAdapter {
  private final String CSS_RESOURCE = "/css/**";
  private final String CSS_RESOURCE_LOCATION = "/assets/css/";
  private final String JS_RESOURCE = "/js/**";
  private final String JS_RESOURCE_LOCATION = "/assets/js/";
  private final String BOWER_RESOURCE = "/bower/**";
  private final String BOWER_RESOURCE_LOCATION = "/assets/bower/";

  private final String FONT_RESOURCE = "/fonts/**";
  private final String IMAGE_RESOURCE = "/img/**";
  private final String IMAGE_RESOURCE_LOCATION = "/assets/img/";


  @Override
  public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
    super.addArgumentResolvers(argumentResolvers);
    argumentResolvers.add(new LoggedDentistMethodParameterResolver());
  }

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
//    freeMarkerConfigurer.getConfiguration().addAutoImport("/spring.ftl", "spring");
    return freeMarkerConfigurer;
  }

  @Bean(name = "messageSource")
  public MessageSource getMessageSource() {
    ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
    messageSource.setBasenames("multi.data", "multi.errors", "multi.messages");
    messageSource.setDefaultEncoding("utf-8");
    return messageSource;
  }

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler(CSS_RESOURCE).addResourceLocations(CSS_RESOURCE_LOCATION);
    registry.addResourceHandler(JS_RESOURCE).addResourceLocations(JS_RESOURCE_LOCATION);
    registry.addResourceHandler(FONT_RESOURCE);
    registry.addResourceHandler(IMAGE_RESOURCE).addResourceLocations(IMAGE_RESOURCE_LOCATION);
    registry.addResourceHandler(BOWER_RESOURCE).addResourceLocations(BOWER_RESOURCE_LOCATION);
  }

  @Bean
  public LocaleChangeInterceptor localeChangeInterceptor() {
    LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
    localeChangeInterceptor.setParamName("lang");
    return localeChangeInterceptor;
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(localeChangeInterceptor());
  }

  @Bean
  public CookieLocaleResolver localeResolver() {
    CookieLocaleResolver cookieLocaleResolver = new CookieLocaleResolver();
    cookieLocaleResolver.setDefaultLocale(new Locale("ua", "UA"));
    cookieLocaleResolver.setCookieName("language");
    cookieLocaleResolver.setCookieMaxAge(3600);
    return cookieLocaleResolver;
  }

}