package com.bang.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@Configuration
public class WebConfiguration { 
	  @Bean
	  public ViewResolver beanNameViewResolver() {
	      BeanNameViewResolver resolver = new BeanNameViewResolver();
	      return resolver;
	  }

	  @Bean("jsonView")
	  public View jsonView() {
	      MappingJackson2JsonView view = new MappingJackson2JsonView();
	      return view;
	  }

	  @Bean
	  public ViewResolver jspViewResolver() {
	      InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
	      viewResolver.setPrefix("/views/");
	      viewResolver.setSuffix(".jsp");
	      return viewResolver;
	  }
}
