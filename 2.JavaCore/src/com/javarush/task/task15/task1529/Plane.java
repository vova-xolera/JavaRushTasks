package com.javarush.task.task15.task1529;

public class Plane implements CanFly {
    public Plane(){
    }
    private static int count;
    @Override
    public void fly() {

    }
    public  Plane(int count) {
        Plane.count = count ;
    }
}
