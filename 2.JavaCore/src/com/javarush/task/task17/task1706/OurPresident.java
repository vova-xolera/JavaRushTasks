package com.javarush.task.task17.task1706;

public class OurPresident {
    private static OurPresident president;

    private OurPresident() {
    }

    public synchronized static OurPresident getOurPresident() {
        return president;
    }
    static {
        synchronized (OurPresident.class) {
            president = new OurPresident();
        }
    }
}
