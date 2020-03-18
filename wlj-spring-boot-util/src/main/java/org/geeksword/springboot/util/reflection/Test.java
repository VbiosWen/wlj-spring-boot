package org.geeksword.springboot.util.reflection;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public void sout(){
        System.out.println("test");
    }

    public static void main(String[] args){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        List<Integer> list1 = list.subList(10, 20);
        list1.forEach(System.out::print);
    }
}
