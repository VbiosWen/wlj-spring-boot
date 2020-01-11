package org.geeksword.springboot.leetcode.simple;

import java.util.Stack;

public class Niuke10 {

    public static void main(String[] args){
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        ListNode listNode1 = new Niuke10().ReverseList(listNode);
        while (listNode1 !=null){
            System.out.println(listNode1.val);
            listNode1 = listNode1.next;
        }
    }

    public ListNode ReverseList(ListNode head) {
        if(head == null){
            return null;
        }
        Stack<ListNode> stack = new Stack<>();
        while (head != null){
            stack.push(head);
            head = head.next;
        }
        ListNode tail = stack.pop();
        ListNode tempNode = tail;
        while (!stack.empty()){
            tempNode.next = stack.pop();
            tempNode = tempNode.next;
        }
        tempNode.next = null;
        return tail;
    }

    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
