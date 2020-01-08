package org.geeksword.springboot.leetcode.model;

import lombok.Data;

@Data
public class TreeNode {

    public int val;

    public TreeNode left;

    public TreeNode right;


    public TreeNode(int val) {
        this.val = val;
    }
}
