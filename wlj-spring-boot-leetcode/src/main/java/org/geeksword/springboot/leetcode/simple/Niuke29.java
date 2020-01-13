package org.geeksword.springboot.leetcode.simple;

import java.util.Stack;

public class Niuke29 {

    public static void main(String[] args){

    }


    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA == null){
            return false;
        }

        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for(int i = 0; i< pushA.length;i++){
            stack.push(pushA[i]);
            while (!stack.isEmpty() && stack.peek() == popA[index] ){
                index ++;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
