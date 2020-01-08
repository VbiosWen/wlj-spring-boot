package org.geeksword.springboot.leetcode.simple;

import org.geeksword.springboot.leetcode.model.TreeNode;

public class LeetCode101 {


    public static void main(String[] args){


    }

    public boolean isSymmetric(TreeNode root) {
        return isMirro(root,root);
    }

    private boolean isMirro(TreeNode left, TreeNode right) {
        if(left == null && right == null) return true;

        if(left == null || right == null) return false;

        return left.val == right.val && isMirro(left.right,right.left) && isMirro(left.left,right.right);
    }
}
