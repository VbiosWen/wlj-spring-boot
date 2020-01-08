package org.geeksword.springboot.leetcode.difficult;

public class LeetcCode5 {

    public static void main(String[] args) {
        LeetcCode5 leetcCode5 = new LeetcCode5();
        String babad = leetcCode5.longestPalindrome("babad");
        System.out.println(babad);
    }

    public String longestPalindrome(String s) {
        if (s == null) {
            throw new NullPointerException("s must not be null.");
        }

        int len = s.length();

        if (len < 2) {
            return s;
        }

        boolean[][] dp = new boolean[s.length()][s.length()];
        int maxLen = 1;
        int start = 0;
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (s.charAt(j) == s.charAt(i)) {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                } else {
                    dp[i][j] = false;
                }
                if(dp[i][j]){
                    int curlen = j - i + 1;
                    if(curlen > maxLen){
                        maxLen = curlen;
                        start = i;
                    }
                }
            }
        }
        return s.substring(start,start + maxLen);
    }
}
