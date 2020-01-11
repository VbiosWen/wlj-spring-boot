package org.geeksword.springboot.leetcode.simple;

public class Niuke6 {

    public static void main(String[] args){

    }

    public int NumberOf1(int n) {
        int cnt = 0;
        while (n != 0){
            cnt ++;
            n = n&(n-1);
        }
        return cnt;
    }
}
