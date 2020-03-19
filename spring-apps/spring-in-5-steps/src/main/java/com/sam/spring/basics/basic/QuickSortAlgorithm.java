package com.sam.spring.basics.basic;

import org.springframework.stereotype.Component;

//@Primary // If more than one Components matches Interface impl - high priority
@Component
public class QuickSortAlgorithm implements SortAlgorithm{
    public int[] sort(int[] numbers){
        //Logic for bubble sort
        return numbers;
    }
}
