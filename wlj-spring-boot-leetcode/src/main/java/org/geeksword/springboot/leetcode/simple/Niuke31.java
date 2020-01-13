package org.geeksword.springboot.leetcode.simple;

import org.geeksword.springboot.leetcode.model.RandomListNode;

public class Niuke31 {

    public static void main(String[] args) {

    }

    public RandomListNode Clone(RandomListNode pHead) {
        if(pHead == null){
            return null;
        }
        RandomListNode newHead = new RandomListNode(pHead.label);
        RandomListNode curNode = newHead;
        while (pHead != null) {
            curNode.next = new RandomListNode(pHead.next.label);
            curNode.random = new RandomListNode(pHead.random.label);
            pHead = pHead.next;
            curNode = curNode.next;
        }
        return newHead;
    }
}
