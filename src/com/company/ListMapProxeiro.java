package com.company;

import java.util.*;

public class ListMapProxeiro {


    public void listMapProxeiroService() {
        System.out.println("OK");

        String s = " ";

        System.out.println(s.isBlank());
        System.out.println(s.isEmpty());


        Map<Integer, String> whatever = new HashMap<>();

        whatever.put(1, "One");
        whatever.put(2, "Two");
        whatever.put(2, "Two");

        System.out.println("Key : Value");

        for (Map.Entry<Integer, String> entry : whatever.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        list.forEach(System.out::println);

        System.out.println("drop 5");

        ListIterator<Integer> integerIterator = list.listIterator();

        while (integerIterator.hasNext()){
            if (integerIterator.next().equals(5)){
                integerIterator.remove();
                integerIterator.add(55);
            }
        }
        list.forEach(System.out::println);

        System.out.println(printListContents(list));

        System.out.println("==========================");
        System.out.println("==========================");
        System.out.println("==========================");
        System.out.println("==========================");
        System.out.println("==========================");



    }


    private String printListContents(List<Integer> list) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            builder.append(list.get(i));
            if (i != list.size() -1){
                builder.append(" - ");
            }
        }
        System.out.println(builder.charAt(builder.length() - 2));
        return builder.toString();
    }


}
