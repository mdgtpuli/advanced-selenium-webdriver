package com.herokuapp.theinternet.base;

public class TestUtilities extends BaseTest{

    //STATIC SLEEP - explicit wait
    protected void sleep(long millis){
        try{
            Thread.sleep(millis);
        }catch(InterruptedException e){
            e.printStackTrace();

        }
    }
}
