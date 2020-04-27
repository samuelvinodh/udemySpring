package com.sam.mockito;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ListTest {

    @Test
    public void test(){
        List list = mock(List.class);
        when(list.size()).thenReturn(10);
        assertEquals(10,list.size());
        assertEquals(10,list.size());
    }

    @Test
    public void test_MultipleReturns(){
        List list = mock(List.class);
        when(list.size()).thenReturn(10).thenReturn(20);
        assertEquals(10,list.size());
        assertEquals(20,list.size());
    }

    @Test
    public void test_GetSpecificParam(){
        List list = mock(List.class);
        when(list.get(0)).thenReturn("SomeString");
        assertEquals("SomeString",list.get(0));
        assertEquals(null,list.get(1));
    }

    @Test
    public void test_GetGenericParam(){
        List list = mock(List.class);
        when(list.get(Mockito.anyInt())).thenReturn("SomeString");
        assertEquals("SomeString",list.get(10));
        assertEquals("SomeString",list.get(4));
    }
}
