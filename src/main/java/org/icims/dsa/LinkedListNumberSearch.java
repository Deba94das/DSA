package org.icims.dsa;

import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListNumberSearch {
    public static void main(String[] args) {
        int number=50;
        LinkedList<Integer> list=new LinkedList<Integer>();
        for(int i=1;i<=number;i++){
            list.add(i);
        }
        System.out.println("Before removal item is: "+ list);
        /*list.add(1);
        list.add(5);
        list.add(7);
        list.add(3);
        list.add(8);
        list.add(2);
        list.add(3);*/
       /* for(int i=0;i<list.size();i++){
            if(list.get(i)== 7){
                System.out.println("Index of "+ list.get(i)+ " is:"+i);
            }
        }*/
        // Delete nodes with values greater than 25
        ListIterator<Integer> iterator = list.listIterator();
        while (iterator.hasNext()) {
            if (iterator.next() > 25) {
                iterator.remove();
            }
        }
        System.out.println("After removal item is: "+list);
        /*list.stream()
                .filter(num -> num == 7)
                .forEach(num -> System.out.println("Index of " + num + " is: " + list.indexOf(num)));*/


    }
}
