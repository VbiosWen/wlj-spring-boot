package org.geeksword.springboot.leetcode.simple;

import java.util.LinkedList;

public class Niuke28 {

    private LinkedList<Integer> linkedList = new LinkedList<>();

    public void push(int node) {
        linkedList.addFirst(node);
    }

    public void pop() {
        linkedList.removeLast();
    }

    public int top() {
        return linkedList.getFirst();
    }

    public int min() {
        if(linkedList.isEmpty()){
            return 0;
        }

        int min = Integer.MAX_VALUE;
        for (Integer value : linkedList) {
            min = Math.min(min, value);
        }
        return min;
    }
}
