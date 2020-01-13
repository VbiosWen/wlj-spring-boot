package org.geeksword.springboot.leetcode.simple;

public class Niuke33 {

    public int FirstNotRepeatingChar(String str) {
        if(str == null || str.isEmpty()){
            return -1;
        }
        int[] array = new int[256];
        char[] chars = str.toCharArray();
        for(char ch : chars){
            array[ch] ++;
        }
        for (int i = 0; i < chars.length; i++) {
            if(array[chars[i]] == 1){
                return i;
            }
        }

        return -1;
    }
}
