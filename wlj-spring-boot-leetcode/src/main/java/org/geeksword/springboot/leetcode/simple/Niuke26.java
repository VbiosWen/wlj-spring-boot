package org.geeksword.springboot.leetcode.simple;

import java.util.ArrayList;
import java.util.Comparator;

public class Niuke26 {

    public static void main(String[] args){
        ArrayList<String> abc = new Niuke26().Permutation("abc");
        abc.forEach(System.out::println);
        String abc1 = new String("abc");
        String abc2 = "abc";
        System.out.println(abc1 == abc2);
    }

    public ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new ArrayList<>();
        if(str == null || str.isEmpty()){
            return list;
        }
        char[] chars = str.toCharArray();
        getAll(chars,list,0,chars.length);
        list.sort(Comparator.naturalOrder());
        return list;
    }

    private void getAll(char[] chars,ArrayList<String> list,int start, int end) {
        if(start == end -1){
            if(list.indexOf(new String(chars)) < 0) {
                list.add(new String(chars));
            }
        }else{
            for(int i = start; i < end ;i++){
                swap(chars,start,i);
                getAll(chars,list,start+ 1,end);
                swap(chars,start,i);
            }
        }
    }

    private void swap(char[] chars, int start, int i) {
        char temp = chars[i];
        chars[i] = chars[start];
        chars[start] = temp;
    }
}
