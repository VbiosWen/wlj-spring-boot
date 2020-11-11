package org.geeksword.springboot.leetcode.simple;



import org.omg.CORBA.INTERNAL;

import java.util.ArrayDeque;
import java.util.Queue;

public class LeetCode7 {

    public static void main(String[] args) {
        int reverse = new Solution().reverse(-123);
        System.out.println(reverse);
    }

    static class Solution {
        public int reverse(int x) {
            Queue<Integer> vector = new ArrayDeque<>();
            boolean isFu = false;
            if (x < 0) {
                isFu = true;
            }
            x = Math.abs(x);
            while (x > 0) {
                vector.add(x % 10);
                x /= 10;
            }
            int num = 0;
            while (!vector.isEmpty()) {
                num = num * 10 + vector.poll();
                if (num > 214748364 || num < -214748364) {
                    return 0;
                }
            }
            if (isFu) {
                num = -num;
            }
            return num;
        }
    }
}
