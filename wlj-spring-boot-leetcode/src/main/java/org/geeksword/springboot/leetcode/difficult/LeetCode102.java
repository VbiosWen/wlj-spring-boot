package org.geeksword.springboot.leetcode.difficult;

import org.geeksword.springboot.leetcode.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode102 {

    public static void main(String[] args) {

    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }

        judge(root, lists, 0);
        return lists;
    }

    private void judge(TreeNode node, List<List<Integer>> lists, int level) {
        if (node == null) {
            return;
        }
        if (lists.size() <= level) {
            lists.add(new ArrayList<>());
        }
        if (level % 2 == 0) {
            lists.get(level).add(node.val);
        } else {
            lists.get(level).add(0, node.val);
        }
        judge(node.left, lists, level + 1);
        judge(node.right, lists, level + 1);
    }
}
