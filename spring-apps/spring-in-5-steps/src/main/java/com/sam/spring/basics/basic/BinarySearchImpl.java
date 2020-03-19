package com.sam.spring.basics.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
//@Component // -- [3. Using Spring ApplicationContext]
@Service
public class BinarySearchImpl {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired // -- [3. Using Spring ApplicationContext]
    @Qualifier("bubble")
    private SortAlgorithm sortAlgorithm; //-- [2. Loose Coupling]
    //private SortAlgorithm bubbleSortAlgorithm; // Autowired by name - low priority

    /*public BinarySearchImpl(SortAlgorithm sortAlgorithm) { // Constructor Injection => For Mandatory dependencies
        this.sortAlgorithm = sortAlgorithm;
    }

    public void setSortAlgorithm(SortAlgorithm sortAlgorithm) { //Setter Injection => For Optional dependencies
        this.sortAlgorithm = sortAlgorithm;
    }*/

    public int binarySearch(int[] numbers, int numberToSearchFor){
    //Sort an array
        //BubbleSortAlgorithm bubbleSortAlgorithm = new BubbleSortAlgorithm(); -- [1. Tight Coupling]
        int[] sortedNumbers = sortAlgorithm.sort(numbers);
        System.out.println(sortAlgorithm);
        //int[] sortedNumbers = bubbleSortAlgorithm.sort(numbers);
        //System.out.println(bubbleSortAlgorithm);
    //Search the array
    //Return the result
        return 3;
    }

    @PostConstruct
    public void postConstruct(){
        logger.info("postConstruct");
    }

    @PreDestroy
    public void preDestroy(){
        logger.info("preDestroy");
    }
}
