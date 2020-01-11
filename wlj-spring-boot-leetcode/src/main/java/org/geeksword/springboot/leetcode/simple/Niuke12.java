package org.geeksword.springboot.leetcode.simple;

import java.util.ArrayList;
import java.util.List;

public class Niuke12 {

    public static void main(String[] args){
        ArrayList<String> abc = new Niuke12().Permutation("abc");
        abc.stream().forEach(System.out::println);
    }

    public ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new ArrayList<>();

        for(int i = 0 ;i< str.length();i++){
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str.charAt(i));
            for(int j = 0; j<str.length();j++){
                if(i!=j){
                    stringBuilder.append(str.charAt(j));
                }
            }
            list.add(stringBuilder.toString());
        }
        return list;
    }
}
