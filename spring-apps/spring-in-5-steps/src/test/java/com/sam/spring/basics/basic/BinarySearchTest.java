package com.sam.spring.basics.basic;

import com.sam.spring.basics.SpringIn5StepsApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

//Load the context
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = SpringIn5StepsApplication.class)
public class BinarySearchTest {

    //Get this bean from context
    @Autowired
    BinarySearchImpl binarySearch;

    @Test
    public void testBasicScenario(){
        //Call method from binarySearch
        int actualResult = binarySearch.binarySearch(new int[]{},5);
        //Test if value is correct
        assertEquals(3,actualResult);
    }
}
