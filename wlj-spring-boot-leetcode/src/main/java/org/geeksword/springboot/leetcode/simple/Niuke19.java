package org.geeksword.springboot.leetcode.simple;

import java.util.Objects;

public class Niuke19 {


    public int[] multiply(int[] A) {
        if(Objects.isNull(A)){
            return null;
        }

        if(A.length < 2){
            return A;
        }

        int[] b = new int[A.length];
        b[0] = A[0];
        for(int i = 1; i< A.length ; i++){
            b[i] = b[i-1] * A[i-1];
        }
        int temp = 1;
        for(int i = A.length -2;i>=0;i--){
            temp *= A[i+1];
            b[i]*=temp;
        }
        return b;
    }
}
