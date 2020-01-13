package org.geeksword.springboot.leetcode.simple;

import org.geeksword.springboot.leetcode.model.TreeNode;

public class Niuke35 {

    public int TreeDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        return getHeight(root);

    }

    private int getHeight(TreeNode root) {
        if(root == null){
            return 1;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return Math.max(leftHeight,rightHeight);
    }
}
