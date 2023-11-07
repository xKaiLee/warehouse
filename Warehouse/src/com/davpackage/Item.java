package com.davpackage;

import java.util.*;

public class Item implements Comparable<Item> {
    public   String nazwa;
    public ItemCondition stan;

    public double masa;
    public int ilosc;

    public Item(String nazwa, ItemCondition stan, double masa, int ilosc){
        this.nazwa = nazwa;
        this.stan = stan;
        this.masa = masa;
        this.ilosc = ilosc;
    }


    public void print(){
        System.out.println("Nazwa: " + nazwa);
        System.out.println("Stan: " + stan);
        System.out.println("Masa: " + masa);
        System.out.println("Ilosc: " + ilosc);
    }


    @Override
    public int compareTo(Item o) {
        return nazwa.compareTo(o.nazwa);
    }
}


