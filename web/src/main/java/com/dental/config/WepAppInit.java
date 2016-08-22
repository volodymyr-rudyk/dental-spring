package com.dental.config;


//*/

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

/**
 * // * Created by light on 3/28/2015.
 * //
 *//*

*/
/*public class WepAppInit implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        System.out.println("Web App Init ...");

        AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();

        appContext.addApplicationListener(new ContextLoaderListener());
        appContext.register(SpringAppConfig.class);
        appContext.setServletContext(servletContext);
        appContext.refresh();


    }
}*/

public class WepAppInit implements WebApplicationInitializer {

  @Override
  public void onStartup(ServletContext servletContext) {
    AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
    rootContext.scan("com.dental.config");
    servletContext.addListener(new ContextLoaderListener(rootContext));

    DispatcherServlet dispatcherServlet = new DispatcherServlet(rootContext);
    ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", dispatcherServlet);
    dispatcher.setLoadOnStartup(1);
    dispatcher.addMapping("/");
  }
}