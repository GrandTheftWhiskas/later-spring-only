package ru.practicum;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.Wrapper;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class LaterApplication {
    public static final int PORT = 8080;
    public static void main(String[] args) throws LifecycleException {
        Tomcat tomcat = new Tomcat();
        tomcat.getConnector().setPort(PORT);

        Context tomcatContext = tomcat.addContext("", null);

        AnnotationConfigWebApplicationContext aConfig = new AnnotationConfigWebApplicationContext();
        aConfig.setServletContext(tomcatContext.getServletContext());
        aConfig.scan("ru.practicum");
        aConfig.refresh();

        DispatcherServlet dispatcherServlet = new DispatcherServlet(aConfig);
        Wrapper dispatcherWrapper = Tomcat.addServlet(tomcatContext, "dispatcher", dispatcherServlet);
        dispatcherWrapper.addMapping("/");
        dispatcherWrapper.setLoadOnStartup(1);

        tomcat.start();
    }
}
