package com.davpackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FullfillmentCenter {
    public String nazwaMagazynu;
    public List<Item> listaProduktow = new ArrayList<>();
    public final double pojemnosc;
    double masaProduktow = 0;

    public FullfillmentCenter(String nazwaMagazynu, double pojemnosc){
        this.nazwaMagazynu = nazwaMagazynu;
        this.pojemnosc = pojemnosc;
    }

    public void addProduct(Item item){
        if(masaProduktow + item.masa*item.ilosc <= pojemnosc) {
            for (int i = 0; i < listaProduktow.size(); i++) {
                Item itemFromList = listaProduktow.get(i);
                if (itemFromList.nazwa == item.nazwa) {
                    itemFromList.ilosc+= item.ilosc;
                    masaProduktow += item.masa*item.ilosc;
                    return;
                }
            }
            listaProduktow.add(item);
            masaProduktow += item.masa*item.ilosc;
        }
        else{
            System.err.println("Pojemnosc magazynu przekroczona");
        }
    }


    public void getProduct(Item item) {
        for (int i = 0; i < listaProduktow.size(); i++) {
            Item itemFromList = listaProduktow.get(i);
            if (itemFromList.nazwa == item.nazwa) {
                if (itemFromList.ilosc > 1) {
                    itemFromList.ilosc--;
                    masaProduktow -= item.masa;
                } else {
                    listaProduktow.remove(itemFromList);
                    masaProduktow -= item.masa;
                }
            }
        }
    }

    public void removeProduct(Item item){
        for (int i = 0; i < listaProduktow.size(); i++) {
            Item itemFromList = listaProduktow.get(i);
            if(itemFromList.nazwa == item.nazwa){
                listaProduktow.remove(itemFromList);
                masaProduktow -= item.masa*itemFromList.ilosc;
            }
        }
    }

    public Item search(String s){
        StringComparator comparator = new StringComparator();
        for(int i = 0; i< listaProduktow.size(); i++){
            Item itemFromList = listaProduktow.get(i);
            if(comparator.compare(s, itemFromList.nazwa) == 0){
                return itemFromList;
            }
        }
        return null;
    }

    public List<Item> searchPartial(String s){
        List<Item> pasujace = new ArrayList<>();

        for(int i = 0; i< listaProduktow.size(); i++){
            Item itemFromList = listaProduktow.get(i);
            if(itemFromList.nazwa.contains(s)){
                pasujace.add(itemFromList);
            }
        }
        return pasujace;

    }


    public int countByCondition(ItemCondition itemCondition){
        int counter = 0;
        for(int i=0; i< listaProduktow.size(); i++){
            Item itemFromList = listaProduktow.get(i);
            if(itemFromList.stan == itemCondition){
                counter+=itemFromList.ilosc;
            }
        }
        return counter;
    }


    public void summary(){
        for(int i = 0; i< listaProduktow.size(); i++){
            Item item = listaProduktow.get(i);
            item.print();
            System.out.println(masaProduktow);
            System.out.println();
        }
    }

    public void sortByName(){
        Collections.sort(listaProduktow, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2){
                return o1.compareTo(o2);
            }
        });
        summary();
    }

    public void sortByAmount(){
        Collections.sort(listaProduktow, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2){
                if(o1.ilosc > o2.ilosc) {
                    return -1;
                }
                else if (o1.ilosc < o2.ilosc){
                    return 1;
                }
                else
                    return 0;
            }
        });
        summary();
    }

    public Item max(){
        return Collections.max(listaProduktow, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return Integer.compare(o1.ilosc, o2.ilosc);
            }
        });
    }










}
