package org.geeksword.springboot.leetcode.simple;

import java.util.ArrayList;
import java.util.List;

public class Niuke37 {

    public static void main(String[] args){
        ArrayList<Integer> list = new Niuke37().FindNumbersWithSum(new int[]{1, 2, 3, 5, 4, 5, 6, 7}, 10);
        list.forEach(System.out::println);
    }

    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        if(array == null){
            return list;
        }
        int left = 0;
        int right = array.length - 1;
        while (left < right){
            int tempSum = array[left] + array[right];
            if(tempSum < sum){
                left ++ ;
            }else if(tempSum > sum){
                right --;
            }else{
                list.add(array[left]);
                list.add(array[right]);
                return list;
            }
        }
        return list;
    }
}
