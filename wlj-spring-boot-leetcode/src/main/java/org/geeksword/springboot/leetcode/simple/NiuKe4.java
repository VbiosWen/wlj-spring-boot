package org.geeksword.springboot.leetcode.simple;

public class NiuKe4 {

    public static void main(String[] args){
        System.out.println(new NiuKe4().Fibonacci(3));
    }

    public int Fibonacci(int n) {
        if(n == 0){
            return 0;
        }

        if(n < 2){
            return 1;
        }

        int[] fi = new int[n];
        fi[0] = 1;
        fi[1] = 1;
        for(int i = 2; i< n; i++){
            fi[i] = fi[i-1] + fi[i-2];
        }
        return fi[n-1];
    }
}
