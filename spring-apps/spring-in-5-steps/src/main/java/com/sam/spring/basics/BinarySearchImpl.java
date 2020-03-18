package com.sam.spring.basics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component // -- [3. Using Spring ApplicationContext]
public class BinarySearchImpl {

    @Autowired // -- [3. Using Spring ApplicationContext]
    private SortAlgorithm sortAlgorithm; //-- [2. Loose Coupling]

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
    //Search the array
    //Return the result
        return 3;
    }
}
