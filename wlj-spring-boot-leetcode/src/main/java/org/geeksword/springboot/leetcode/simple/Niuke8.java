package org.geeksword.springboot.leetcode.simple;

import java.util.Arrays;
import java.util.stream.Stream;

public class Niuke8 {

    public static void main(String[] args){
        int[] arr = new int[]{1,2,3,4,5,6,7};
        Niuke8 niuke8 = new Niuke8();
        niuke8.reOrderArray(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }

    public void reOrderArray(int [] array) {
        if(array == null || array.length == 0){
            return;
        }

        int begin = 0;
        int end = array.length -1;
        while (begin < end){
            if(begin < end && !isEvent(array[begin])){
                begin ++;
            }

            if(begin < end && isEvent(array[end])){
                end --;
            }

            if(begin < end){
                int temp = array[begin];
                array[begin] = array[end];
                array[end] = temp;
            }
        }
    }

    private boolean isEvent(int target) {
        return (target & 1) ==0;
    }
}
