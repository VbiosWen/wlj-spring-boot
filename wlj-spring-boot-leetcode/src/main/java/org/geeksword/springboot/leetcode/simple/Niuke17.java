package org.geeksword.springboot.leetcode.simple;

import java.util.Objects;

public class Niuke17 {

    public static void main(String[] args) {
        int i = new Niuke17().StrToInt("+31231231");
        System.out.println(i);
    }

    public int StrToInt(String str) {
        if (Objects.isNull(str) || str.isEmpty()) {
            return 0;
        }

        int flag = 0;
        if (str.charAt(0) == '+') {
            flag = 1;
        } else if (str.charAt(0) == '-') {
            flag = 2;
        }
        long result = 0;
        int index = flag > 0 ? 1 : 0;
        for (; index < str.length(); index++) {
            if (str.charAt(index) > '9' || str.charAt(index) < '0') {
                return 0;
            }
            result = result * 10 + Integer.parseInt(String.valueOf(str.charAt(index)));
        }
        result = flag == 2 ? -result : result;
         return  (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) ? 0 : (int) result;
    }
}
