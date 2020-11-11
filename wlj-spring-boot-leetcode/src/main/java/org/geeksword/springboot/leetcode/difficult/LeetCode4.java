package org.geeksword.springboot.leetcode.difficult;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @wenliujie
 */
public class LeetCode4 {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 3};
        int[] nums2 = new int[]{2,4};
        double medianSortedArrays = new Solution().findMedianSortedArrays(nums1, nums2);
        System.out.println(medianSortedArrays);
    }


    static class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            List<Integer> allNums = new ArrayList<>();
            for (int num : nums1) {
                allNums.add(num);
            }
            for (int num : nums2) {
                allNums.add(num);
            }
            allNums.sort(Comparator.naturalOrder());
            int size = allNums.size();
            double midNum = 0.0;
            if (size % 2 == 0) {
                midNum = (allNums.get(size / 2 - 1) + allNums.get(size / 2)) / 2.0;
            } else {
                midNum = allNums.get((size) / 2);
            }
            return midNum;
        }
    }
}
