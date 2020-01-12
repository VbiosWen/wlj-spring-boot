package org.geeksword.springboot.leetcode.simple;

import org.geeksword.springboot.leetcode.model.TreeNode;

import java.util.ArrayList;

public class Niuke23 {

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        if (pRoot == null) {
            return lists;
        }

        addList(pRoot, lists, 0);
        return lists;
    }

    private void addList(TreeNode pRoot, ArrayList<ArrayList<Integer>> lists, int level) {
        if (pRoot == null) {
            return;
        }

        if (lists.size() <= level) {
            lists.add(new ArrayList<>());
        }

        if ((level & 1) == 1) {
            lists.get(level).add(0,pRoot.val);
        }else{
            lists.get(level).add(pRoot.val);
        }
        addList(pRoot.left,lists,level + 1);
        addList(pRoot.right,lists,level + 1);
    }

}
