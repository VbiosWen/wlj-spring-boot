package org.geeksword.springboot.leetcode.difficult;

import org.geeksword.springboot.leetcode.model.TreeNode;

public class Niuke2 {

    public static void main(String[] args){

    }

    public void Mirror(TreeNode root) {
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            return;
        }
        convert(root);
    }

    private void convert(TreeNode root) {
        if(root == null){
            return;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right= temp;
        if(root.left != null){
            convert(root.left);
        }

        if(root.right !=null){
            convert(root.right);
        }
    }

}
