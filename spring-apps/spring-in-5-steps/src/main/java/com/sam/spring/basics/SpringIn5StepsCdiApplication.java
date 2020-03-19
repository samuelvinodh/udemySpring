package com.sam.spring.basics;

import com.sam.spring.basics.cdi.SomeCdiBusiness;
import com.sam.spring.component.ComponentPersonDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//@SpringBootApplication
@Configuration
@ComponentScan
public class SpringIn5StepsCdiApplication {
	private static Logger LOGGER = LoggerFactory.getLogger(SpringIn5StepsCdiApplication.class);

	public static void main(String[] args) {

		//ApplicationContext applicationContext =
				//SpringApplication.run(SpringIn5StepsCdiApplication.class, args);
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				SpringIn5StepsCdiApplication.class);
		SomeCdiBusiness someCdiBusiness = applicationContext.getBean(SomeCdiBusiness.class);
		LOGGER.info("{} - dao - {}",someCdiBusiness,someCdiBusiness.getSomeCdiDao());

	}

}
