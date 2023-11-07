package com.davpackage;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class FullfillmentCenterContainer {
    Map<String, FullfillmentCenter> magazyny = new HashMap<>();



    public void addCenter(String nazwa, double pojemnosc){
        FullfillmentCenter center = new FullfillmentCenter(nazwa, pojemnosc);
        magazyny.put(nazwa, center);
    }

    public void removeCenter(String nazwa){
        magazyny.remove(nazwa);
    }

    public Map<String, FullfillmentCenter> findEmpty(){
        for(Map.Entry<String, FullfillmentCenter> entry : magazyny.entrySet()){
            if(magazyny.isEmpty()){
                return magazyny;
            }
        }
        return null;
    }

    public void summary(){
        Iterator<Map.Entry<String, FullfillmentCenter >> itr = magazyny.entrySet().iterator();
        while(itr.hasNext()){
            Map.Entry<String, FullfillmentCenter> entry = itr.next();
            FullfillmentCenter center = entry.getValue();
            System.out.println("Nazwa: " + entry.getKey() + ", Pojemnosc: " + center.pojemnosc);
        }
    }
}



