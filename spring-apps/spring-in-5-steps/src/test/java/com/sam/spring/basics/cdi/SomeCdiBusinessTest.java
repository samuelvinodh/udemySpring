package com.sam.spring.basics.cdi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

//Load the context
@RunWith(MockitoJUnitRunner.class)
public class SomeCdiBusinessTest {

    //Get this bean from context
    @InjectMocks
    private SomeCdiBusiness business;

    @Mock
    private SomeCdiDao daoMock;

    @Test
    public void testBasicScenario(){
        when(daoMock.getData()).thenReturn(new int[]{2,4});
        assertEquals(4,business.findGreatest());
    }

    @Test
    public void testNoValues(){
        when(daoMock.getData()).thenReturn(new int[]{});
        assertEquals(Integer.MIN_VALUE,business.findGreatest());
    }

    @Test
    public void testEqualValues(){
        when(daoMock.getData()).thenReturn(new int[]{2,2});
        assertEquals(2,business.findGreatest());
    }
}
