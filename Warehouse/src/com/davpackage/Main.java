package com.davpackage;

import java.awt.event.ItemEvent;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Item robot = new Item("Robot", ItemCondition.NEW, 75, 2 );
        Item robot2 = new Item("Robot", ItemCondition.NEW, 75, 2 );
        Item tv = new Item("TV", ItemCondition.USED, 150, 1 );
        Item bobo = new Item("Bobo", ItemCondition.NEW, 1, 3 );
        FullfillmentCenter center = new FullfillmentCenter("Magazyn", 1000);
        center.addProduct(robot);
        center.addProduct(robot2);
        center.addProduct(tv);
        center.addProduct(bobo);

        System.out.println("Szukam produkt");
        Item szukany = center.search("TV");
        szukany.print();
        System.out.println();

        System.out.println("Szukam produkty");
        List<Item> wyszukane = center.searchPartial("obo");
        Iterator<Item> it = wyszukane.iterator();
        while(it.hasNext()){
            it.next().print();
        }
        System.out.println();

        System.out.println("Ile danego stanu");
        int counter = center.countByCondition(ItemCondition.NEW);
        System.out.println(counter);
        System.out.println();

        System.out.println("Sort by name");
        center.sortByName();
        System.out.println();

        System.out.println("Sort by amount");
        center.sortByAmount();
        System.out.println();

        System.out.println("Max");
        Item max = center.max();
        max.print();
        System.out.println();

        System.out.println("Usuwam jeden produkt");
        center.getProduct(robot);
        center.summary();

        System.out.println("Usuwam wszystkie produkty");
        center.removeProduct(robot);
        center.summary();
        System.out.println();


        FullfillmentCenterContainer centerContainer = new FullfillmentCenterContainer();
        centerContainer.addCenter("Jeden", 500);
        centerContainer.addCenter("Jeden", 100);
        centerContainer.addCenter("Dwa", 250);
        System.out.println();

        System.out.println("Wyswietlam magazyny");
        centerContainer.summary();
        System.out.println();

        System.out.println("Usuwam magazyn");
        centerContainer.removeCenter("Jeden");
        centerContainer.summary();
    }

}
