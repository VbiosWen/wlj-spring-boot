package org.geeksword.springboot.leetcode.difficult;

public class LeetCode11 {


    public static void main(String[] args){

    }

    public int maxArea(int[] height) {

        int min = 0;
        int i = 0;
        int j = height.length -1;
        int res = 0;
        while (i < j){
            int h = Math.min(height[i],height[j]);
            res = Math.max(res,(j-i) * h);
            if(height[i] < height[j]) i ++;
            else j--;
        }
        return res;
    }
}
