package com.enum_.exercise03;

interface calculate{
    public void work();
}

public class Cellphone {

    public void testWork(calculate calculate){
        calculate.work();
    }
}
