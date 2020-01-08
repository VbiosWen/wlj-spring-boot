package org.geeksword.springboot.leetcode.simple;

import java.util.Arrays;

public class LeetCode14 {

    public static void main(String[] args) {
        LeetCode14 leetCode14 = new LeetCode14();
        String s = leetCode14.longestCommonPrefix(new String[]{"flower", "flow", "flight"});
        System.out.println(s);
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null) {
            throw new NullPointerException();
        }
        int maxLen = 0;
        int len = strs.length;
        String str = strs[0];
        for(int i = 1 ; i< str.length(); i++){
            for(;maxLen < str.length();maxLen ++){
                if(str.charAt(maxLen) != strs[i].charAt(maxLen)){
                    break;
                }
            }
            str = str.substring(0,maxLen);
            if(str.equals("")){
                return str;
            }
        }
        return str;
    }
}
