package com.sam.spring.basics;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary // If more than one Components matches Interface impl
@Component
public class QuickSortAlgorithm implements SortAlgorithm{
    public int[] sort(int[] numbers){
        //Logic for bubble sort
        return numbers;
    }
}
