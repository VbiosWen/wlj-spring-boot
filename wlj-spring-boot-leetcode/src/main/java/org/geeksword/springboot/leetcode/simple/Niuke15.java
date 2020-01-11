package org.geeksword.springboot.leetcode.simple;

import java.util.Objects;

public class Niuke15 {

    public static void main(String[] args){
        String abcXYZdef = new Niuke15().LeftRotateString("abcXYZdef", 3);
        System.out.println(abcXYZdef);
    }

    public String LeftRotateString(String str,int n) {
        if(Objects.isNull(str) || str.isEmpty()){
            return "";
        }

        if(n == str.length()){
            return str;
        }

        if(n > str.length()){
            n = n%str.length();
        }

        String substring1 = str.substring(0, n);
        String subString2 = str.substring(n);
        return subString2 + substring1;
    }

}
