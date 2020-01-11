package org.geeksword.springboot.leetcode.simple;

import java.util.Objects;

public class Niuke11 {


    public ListNode Merge(ListNode list1,ListNode list2) {
        if(Objects.isNull(list1)){
            return list2;
        }

        if(Objects.isNull(list2)){
            return list1;
        }

        ListNode curNode = null;
        ListNode head = null;
        while (Objects.nonNull(list1) && Objects.nonNull(list2)){
            if(judgeVal(list1,list2)){
                if(head == null){
                    head = list1;
                    curNode = head;
                }else{
                    curNode.next = list1;
                    curNode = curNode.next;
                }
                list1 = list1.next;
            }else{
                if(head == null){
                    head = list2;
                    curNode = head;
                }else{
                    curNode.next = list2;
                    curNode = curNode.next;
                }
                list2 = list2.next;
            }
            if(list1 == null){
                curNode.next = list2;
            }else{
                curNode.next = list1;
            }
        }
        return head;
    }

    private boolean judgeVal(ListNode list1, ListNode list2) {
        return list1.val < list2.val;
    }

    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
