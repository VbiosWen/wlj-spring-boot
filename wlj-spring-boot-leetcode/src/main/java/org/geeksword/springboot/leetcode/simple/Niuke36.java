package org.geeksword.springboot.leetcode.simple;

import java.util.HashSet;

public class Niuke36 {

    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        HashSet<Integer> set = new HashSet<>();
        for (int arr : array) {
            if (set.contains(arr)) {
                set.remove(arr);
            } else {
                set.add(arr);
            }
        }
        Object[] objects = set.toArray();
        num1[0] = (int) objects[0];
        num2[0] = (int) objects[1];
    }
}
