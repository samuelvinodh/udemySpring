package com.sam.mockito;

import org.junit.Test;

import static org.junit.Assert.*;

public class SomeBusinessStubTest {
    private SomeBusinessImpl someBusiness = new SomeBusinessImpl(new DataStub());

    @Test
    public void findTheGreatestFromAllData() {
        int result = someBusiness.findTheGreatestFromAllData();
        assertEquals(24, result);
    }

}

class DataStub implements DataService{

    @Override
    public int[] retrieveAllData() {
        return new int[]{24,6,15};
    }
}