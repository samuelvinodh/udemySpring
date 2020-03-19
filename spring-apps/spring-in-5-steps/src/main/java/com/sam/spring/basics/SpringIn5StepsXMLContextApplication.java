package com.sam.spring.basics;

import com.sam.spring.basics.xml.XmlPersonDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
public class SpringIn5StepsXMLContextApplication {
	private static Logger LOGGER = LoggerFactory.getLogger(SpringIn5StepsXMLContextApplication.class);

	public static void main(String[] args) {

		//ApplicationContext applicationContext =
				//SpringApplication.run(SpringIn5StepsScopeApplication.class, args);
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		LOGGER.info("Beans loaded: {}",(Object) applicationContext.getBeanDefinitionNames());
		XmlPersonDAO xmlPersonDAO = applicationContext.getBean(XmlPersonDAO.class);
		LOGGER.info("{} - jdbc - {}",xmlPersonDAO,xmlPersonDAO.getXmlJdbcConnection());

	}

}
