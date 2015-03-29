
package com.dental.config;


//*/

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletRegistration;

/**
// * Created by light on 3/28/2015.
// *//*

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
    public void onStartup(javax.servlet.ServletContext container) {
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(AppConfig.class);
        ContextLoaderListener contextLoaderListener = new ContextLoaderListener(rootContext);
        container.addListener(contextLoaderListener);
        //container.setInitParameter("contextInitializerClasses", "mvctest.web.DemoApplicationContextInitializer");
        AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
        webContext.register(AppConfig.class);
        DispatcherServlet dispatcherServlet = new DispatcherServlet(webContext);
        ServletRegistration.Dynamic dispatcher = container.addServlet("dispatcher", dispatcherServlet);
        dispatcher.addMapping("/");
    }
}

