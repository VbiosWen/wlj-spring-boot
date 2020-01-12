package org.geeksword.springboot.leetcode.simple;

import org.geeksword.springboot.leetcode.model.TreeNode;

public class Niuke22 {


    public static void main(String[] args) {
        System.out.println(new Niuke22().isSymmetrical(new TreeNode(1)));
    }

    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) {
            return Boolean.TRUE;
        }

        return judge(pRoot,pRoot);
    }

    private boolean judge(TreeNode left, TreeNode right) {

        if(left == null && right == null){
            return true;
        }

        if(right == null || left == null){
            return false;
        }


        if(left.val == right.val){

            return judge(left.left,right.right) && judge(left.right,right.left);
        }

        return false;
    }
}
