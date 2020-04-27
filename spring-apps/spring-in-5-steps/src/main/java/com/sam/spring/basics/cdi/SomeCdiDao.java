package com.sam.spring.basics.cdi;

import org.springframework.stereotype.Component;

import javax.inject.Named;

@Named
public class SomeCdiDao {
    public int[] getData(){
        return new int[]{5,89,100};
    }
}
