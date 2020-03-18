package com.sam.spring.basics;

import org.springframework.stereotype.Component;

@Component // -- [3. Using Spring ApplicationContext]
public class BubbleSortAlgorithm implements SortAlgorithm{ // Implementing interface -- [2. Loose Coupling]
    public int[] sort(int[] numbers){
        //Logic for bubble sort
        return numbers;
    }
}
