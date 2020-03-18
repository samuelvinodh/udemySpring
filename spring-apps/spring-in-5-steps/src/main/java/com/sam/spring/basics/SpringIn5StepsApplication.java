package com.sam.spring.basics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringIn5StepsApplication {

	//What are the beans? Java classes annotated with @Component
	//What are the dependencies Spring must manage? Dependencies annotated with @Autowired
	//Where to search for Beans? => Not required as all beans are in same Java package

	public static void main(String[] args) {
		//BinarySearchImpl binarySearch = new BinarySearchImpl(); -- [1. Tight Coupling]
		//BinarySearchImpl binarySearch = new BinarySearchImpl(new BubbleSortAlgorithm()); -- [2. Loose Coupling]
		//Application Context -- [3. Using Spring ApplicationContext]
		ApplicationContext applicationContext =
				SpringApplication.run(SpringIn5StepsApplication.class, args);
		BinarySearchImpl binarySearch = applicationContext.getBean(BinarySearchImpl.class);
		int result = binarySearch.binarySearch(new int[]{12,4,6},3);
		System.out.println(result);
	}

}
