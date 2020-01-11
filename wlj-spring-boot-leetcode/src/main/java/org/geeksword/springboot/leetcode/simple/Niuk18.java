package org.geeksword.springboot.leetcode.simple;

public class Niuk18 {

    public static void main(String[] args){
        int[] dup = new int[1];
        int[] numbers = {2,4,2,1,4};
        new Niuk18().duplicate(numbers,numbers.length,dup);

    }

    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if(numbers == null || numbers.length <=1){
            return Boolean.FALSE;
        }
        int max = 0;
        for(int number: numbers){
            max = Math.max(max,number);
        }

        int[] bucktArray = new int[max + 1];
        int temp = -1;
        for(int number : numbers){
            bucktArray[number] ++;
            if(bucktArray[number] > 1){
                temp = number;
                break;
            }
        }



        if(temp == -1){
            return Boolean.FALSE;
        }
        duplication[0] =temp;
        return Boolean.TRUE;
    }
}
