package com.sam.spring.basics;

import com.sam.spring.basics.basic.BinarySearchImpl;
import com.sam.spring.basics.properties.SomeExternalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
@Configuration
@ComponentScan
@PropertySource("classpath:app.properties")
public class SpringIn5StepsPropertiesApplication {

	private static Logger logger = LoggerFactory.getLogger(SpringIn5StepsPropertiesApplication.class);

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				SpringIn5StepsPropertiesApplication.class);
		SomeExternalService externalService = applicationContext.getBean(SomeExternalService.class);
		logger.info("{} - property - {}",externalService,externalService.returnServiceURL());
	}

}
