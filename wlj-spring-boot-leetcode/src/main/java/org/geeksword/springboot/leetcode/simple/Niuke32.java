package org.geeksword.springboot.leetcode.simple;

public class Niuke32 {

    public static void main(String[] args){
        int max = new Niuke32().solve2(new int[]{-2,-8,-1,-5,-9});
        System.out.println(max);
    }

    public int FindGreatestSumOfSubArray(int[] array) {

        if(array == null){
            return 0;
        }

        int[][] dp = new int[array.length][array.length];
        dp[0][0] = array[0];
        int max = Integer.MIN_VALUE;
        for(int i = 0 ;i< array.length;i++){
            for(int j= i+1;j<array.length;j++){
                if(i==j){
                    dp[i][j] = array[j];
                }
                dp[i][j] = dp[i][j-1] + array[j];
                max = Math.max(max,dp[i][j]);
            }
        }
        return max;
    }

    public int solve2(int[] array){
        if(array == null){
            return 0;
        }
        int max = Integer.MIN_VALUE;
        for(int i = 1 ;i< array.length;i++){
            array[i] = Math.max(array[i] + array[i-1],array[i]);
            max = Math.max(array[i],max);
        }
        return max;
    }
}
