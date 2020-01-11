package org.geeksword.springboot.leetcode.simple;

import org.apache.commons.collections.CollectionUtils;

import java.util.Collections;
import java.util.List;

public class Niuke13 {


    public static void main(String[] args){
        int[] arr = new int[]{1,2,3,2,2,2,5,4,2};
        int i = new Niuke13().MoreThanHalfNum_Solution(arr);
        System.out.println(i);
    }

    public int MoreThanHalfNum_Solution(int [] array) {
        if(array == null){
            return 0;
        }
        int max = 0;
        for (int arr : array){
            max = Math.max(max, arr);
        }
        int[] bucketArr = new int[max + 1];

        for (int arr : array) {
            bucketArr[arr] ++ ;
        }

        int temp = array.length/2 + 1;
        for (int i = 0; i < bucketArr.length; i++) {
            if(bucketArr[i] >= temp){
                return i;
            }
        }
        return 0;
    }
}
