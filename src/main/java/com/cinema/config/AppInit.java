package com.cinema.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


public class AppInit extends AbstractAnnotationConfigDispatcherServletInitializer {
  /**
   * Beans configuration
   */
  @Override
  protected Class<?>[] getRootConfigClasses() {
    return new Class<?>[]{
            WebConfig.class
    };
  }

  /**
   * ViewResolver configuration
   */
  @Override
  protected Class<?>[] getServletConfigClasses() {
    return new Class<?>[]{
            WebConfig.class
    };
  }

  @Override
  protected String[] getServletMappings() {
    return new String[]{"/"};
  }

}
