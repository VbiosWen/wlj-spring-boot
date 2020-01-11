package org.geeksword.springboot.leetcode.simple;

import java.util.Stack;

public class Niuke9 {

    public static void main(String[] args){

    }

    public ListNode FindKthToTail(ListNode head,int k) {
        Stack<ListNode> listNodes = new Stack<>();
        while (head !=null){
            listNodes.add(head);
            head = head.next;
        }
        if(k > listNodes.size() || k == 0){
            return null;
        }
        while (k > 1){
            listNodes.pop();
            k --;
        }
        return listNodes.pop();
    }

    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
