package org.geeksword.springboot.leetcode.difficult;

import org.geeksword.springboot.leetcode.model.TreeNode;

public class NiuKe1 {

    public static void main(String[] args){

    }

    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if(root1 == null){
            return false;
        }

        if(root2 == null){
            return false;
        }

        return isTree(root1,root2) || isTree(root1.left,root2) || isTree(root1.right,root2);
    }

    private boolean isTree(TreeNode root1, TreeNode root2) {
        if(root2 == null){
            return true;
        }

        if(root1==null){

            return false;
        }
        if(root1.val == root2.val) {
            return isTree(root1.left,root2.left) && isTree(root1.right,root2.right);
        }
        return false;
    }
}
