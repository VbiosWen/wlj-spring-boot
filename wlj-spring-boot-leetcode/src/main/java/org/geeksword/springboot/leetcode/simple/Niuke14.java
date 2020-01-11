package org.geeksword.springboot.leetcode.simple;

import java.util.ArrayList;

public class Niuke14 {

    public static void main(String[] args){
        int[] arr = new int[]{4,5,1,6,2,7,3,8};
        ArrayList<Integer> list = new Niuke14().GetLeastNumbers_Solution(arr, 4);
        list.forEach(System.out::println);
    }

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list  = new ArrayList<>();
        if(input == null){
            return list;
        }

        if(k > input.length){
            return list;
        }
        int max = max(input);

        int[] bucketArr = new int[max + 1];
        for (int in : input) {
            bucketArr[in] ++;
        }

        for (int i = 0; i < bucketArr.length; i++) {
            for(int j = 0; j< bucketArr[i];j++){
                if(list.size() == k){
                    break;
                }
                list.add(i);
            }
            if(list.size() == k){
                break;
            }
        }
        return list;
    }

    public int max(int[] input){
        int max = 0;
        for (int in : input) {
            max = Math.max(max,in);
        }
        return max;
    }
}
