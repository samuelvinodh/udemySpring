package com.sam.spring.basics;

import com.sam.spring.basics.scope.PersonDAO;
import com.sam.spring.component.ComponentPersonDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.sam.spring.component")
public class SpringIn5StepsComponentApplication {
	private static Logger LOGGER = LoggerFactory.getLogger(SpringIn5StepsComponentApplication.class);

	public static void main(String[] args) {

		ApplicationContext applicationContext =
				SpringApplication.run(SpringIn5StepsComponentApplication.class, args);
		ComponentPersonDAO personDAO = applicationContext.getBean(ComponentPersonDAO.class);
		LOGGER.info("{}",personDAO);
		LOGGER.info("{}",personDAO.getComponentJdbcConnection());
	}

}
