package org.geeksword.springboot.leetcode.simple;

public class LeetCode53 {

    public static void main(String[] args) {
        LeetCode53 leetCode53 = new LeetCode53();
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int i = leetCode53.maxSubArray(nums);
        System.out.println(i);
    }

    public int maxSubArray(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] = Math.max(nums[i], nums[i] + nums[i - 1]);
            max = Math.max(max, nums[i]);
        }
        return max;
    }
}
