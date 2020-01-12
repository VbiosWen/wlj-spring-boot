package org.geeksword.springboot.leetcode.simple;

import org.geeksword.springboot.leetcode.model.TreeNode;

import java.util.ArrayList;

public class Niuke24 {


    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        if (pRoot == null){
            return arrayLists;
        }
        addList(pRoot,arrayLists,0);
        return arrayLists;
    }

    private void addList(TreeNode pRoot, ArrayList<ArrayList<Integer>> arrayLists,int level) {
        if(pRoot== null){
            return;
        }

        if (arrayLists.size() <=level){
            arrayLists.add(new ArrayList<>());
        }

        arrayLists.get(level).add(pRoot.val);
        addList(pRoot.left,arrayLists,level+1);
        addList(pRoot.right,arrayLists,level+1);
    }
}
