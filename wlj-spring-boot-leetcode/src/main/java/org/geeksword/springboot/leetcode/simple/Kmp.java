package org.geeksword.springboot.leetcode.simple;

/**
 * @wenliujie
 */
public class Kmp {


    public static void main(String[] args) {
        String parentStr = "abcdabd", childStr = "cda";
        int stringIndex = getStringIndex(parentStr, childStr);
        System.out.println(stringIndex);
    }

    private static int getStringIndex(String parentStr, String childStr) {
        int[] next = new int[childStr.length()];
        getNext(childStr, next);
        char[] parentChars = parentStr.toCharArray();
        char[] childChars = childStr.toCharArray();
        int i = 0, j = 0;
        while (i < parentChars.length && j < childChars.length) {
            if (j == -1 || parentChars[i] == childChars[j]) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if (j == childChars.length) {
            return i - j;
        } else {
            return -1;
        }

    }

    private static void getNext(String childStr, int[] next) {
        int size = childStr.length();
        char[] charstr = childStr.toCharArray();
        int i = 0;
        int j = -1;
        next[0] = -1;
        while (i < size - 1) {
            if (j == -1 || charstr[i] == charstr[j]) {
                i++;
                j++;
                next[i] = j;
            } else {
                j = next[j];
            }
        }
    }
}
