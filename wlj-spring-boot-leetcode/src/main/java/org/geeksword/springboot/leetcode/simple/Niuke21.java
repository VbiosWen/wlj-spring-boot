package org.geeksword.springboot.leetcode.simple;

import java.util.Objects;

public class Niuke21 {

    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {

    }

    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        ListNode newHead = pHead;
        ListNode resultHead = new ListNode(0);
        resultHead.next= pHead;
        ListNode newHead2= resultHead;
        while (Objects.nonNull(newHead) && Objects.nonNull(newHead.next)){
            if(newHead.val == newHead.next.val){
                while (newHead.val == newHead.next.val){
                    newHead = newHead.next;
                }
                newHead2.next = newHead.next;
            }else{
                newHead2 = newHead;
            }
            newHead = newHead.next;
        }
        return resultHead.next == null ? (ListNode) new Object() : resultHead.next;
    }
}
