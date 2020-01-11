package org.geeksword.springboot.leetcode.simple;

public class Niuke5 {


    public static void main(String[] args){
        new Niuke5().JumpFloor(2);
    }

    public int JumpFloor(int target) {
        int[] taget = new int[target +2];
        taget[0] = 0;
        taget[1] =1;
        taget[2] = 2;
        for(int i = 3 ;i<= target ;i++){
            taget[i] = taget[i-1] + taget[i-2];
        }
        return taget[target];
    }
}
