package main;

import java.io.File;

import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class Main {
  public static void main(String[] args) throws Exception {
    //start the Apache Tomcat server, set port and root directory
    //and configure classpath to include the target/classes directory
    String webappDirLocation = "src/main/webapp/";
    Tomcat tomcat = new Tomcat();
    tomcat.setPort(8080);

    tomcat.getConnector();
    StandardContext ctx = (StandardContext) tomcat.addWebapp("/", new File(webappDirLocation).getAbsolutePath());

    File additionWebInfClasses = new File("target/classes");

    WebResourceRoot resources = new StandardRoot(ctx);
    resources.addPreResources(new DirResourceSet(resources, "/WEB-INF/classes",
      additionWebInfClasses.getAbsolutePath(), "/"));
    ctx.setResources(resources);

    tomcat.start();
    tomcat.getServer().await();
  }
}