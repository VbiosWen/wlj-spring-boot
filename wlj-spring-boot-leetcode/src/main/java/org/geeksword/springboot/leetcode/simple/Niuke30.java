package org.geeksword.springboot.leetcode.simple;

import org.geeksword.springboot.leetcode.model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

public class Niuke30 {


    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.add(root);
        while (linkedList.size() != 0) {
            TreeNode poll = linkedList.poll();
            list.add(poll.val);
            if (poll.left != null) {
                linkedList.add(poll.left);
            }
            if (poll.right != null) {
                linkedList.add(poll.right);
            }
        }

        return list;
    }


}
