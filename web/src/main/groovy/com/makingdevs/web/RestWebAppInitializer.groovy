package com.makingdevs.web

import com.makingdevs.config.AppConfig
import groovy.transform.CompileStatic
import org.springframework.data.rest.webmvc.RepositoryRestDispatcherServlet
import org.springframework.web.WebApplicationInitializer
import org.springframework.web.context.ContextLoaderListener
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext
import org.springframework.web.servlet.DispatcherServlet

import javax.servlet.ServletContext
import javax.servlet.ServletException
import javax.servlet.ServletRegistration

/**
 * Created by neodevelop on 26/11/16.
 */
@CompileStatic
class RestWebAppInitializer implements WebApplicationInitializer {
    @Override
    void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext()
        ctx.register(AppConfig)

        servletContext.addListener(new ContextLoaderListener(ctx))

        DispatcherServlet servlet = new RepositoryRestDispatcherServlet()
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher",servlet)
        dispatcher.setLoadOnStartup(1)
        dispatcher.addMapping("/")
    }
}
