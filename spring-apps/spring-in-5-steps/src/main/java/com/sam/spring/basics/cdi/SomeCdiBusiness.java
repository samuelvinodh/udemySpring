package com.sam.spring.basics.cdi;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class SomeCdiBusiness {

    @Inject
    private SomeCdiDao someCdiDao;

    public SomeCdiDao getSomeCdiDao() {
        return someCdiDao;
    }

    public void setSomeCdiDao(SomeCdiDao someCdiDao) {
        this.someCdiDao = someCdiDao;
    }

    public int findGreatest(){
        int[] data = someCdiDao.getData();
        int greatest = Integer.MIN_VALUE;
        for(int value: data){
            if(value > greatest){
                greatest = value;
            }
        }
        return greatest;
    }
}
