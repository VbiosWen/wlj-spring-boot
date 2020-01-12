package org.geeksword.springboot.leetcode.simple;

import org.geeksword.springboot.leetcode.model.TreeNode;

public class Niuke25 {

    StringBuilder stringBuilder = new StringBuilder();

    String Serialize(TreeNode root) {
        if(root == null){
            return stringBuilder.toString();
        }
        serialize(root);
        return stringBuilder.toString();
    }

    private void serialize(TreeNode root) {
        if(root == null){
            stringBuilder.append("#");
            return;
        }
        stringBuilder.append(root.val).append("!");
        serialize(root.left);
        serialize(root.right);
    }
}
