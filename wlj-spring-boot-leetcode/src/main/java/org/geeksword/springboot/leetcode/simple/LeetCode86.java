package org.geeksword.springboot.leetcode.simple;

import org.geeksword.springboot.leetcode.model.ListNode;

import java.time.LocalDateTime;
import java.time.temporal.WeekFields;
import java.util.Deque;
import java.util.LinkedList;

public class LeetCode86 {


    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(4);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(2);
        listNode.next.next.next.next = new ListNode(5);
        listNode.next.next.next.next.next = new ListNode(2);
        ListNode partition = new Solution().partition(listNode, 3);
//        while (partition != null) {
//            System.out.printf("%d->", partition.val);
//            partition = partition.next;
//        }
            System.out.println(LocalDateTime.now().get(WeekFields.ISO.weekOfYear()));
    }

    public ListNode partition(ListNode head, int x) {
        ListNode maxXNode = new ListNode(0);
        ListNode maxHead = maxXNode;
        ListNode minXNode = new ListNode(0);
        ListNode minXHead = minXNode;
        while (head != null) {
            if (head.val >= x) {
                maxXNode.next = new ListNode(head.val);
                maxXNode = maxXNode.next;
            } else {
                minXNode.next = new ListNode(head.val);
                minXNode = minXNode.next;
            }
            head = head.next;
        }
        maxXNode.next = null;
        minXNode.next = maxHead.next;
        return minXHead.next;
    }

    static class Solution {

        public ListNode partition(ListNode head, int x) {

            Deque<Integer> maxXNode = new LinkedList<>();
            Deque<Integer> minXNode = new LinkedList<>();
            while (head != null) {
                if (head.val >= x) {
                    maxXNode.add(head.val);
                } else {
                    minXNode.add(head.val);
                }
                head = head.next;
            }
            ListNode headNode = null;
            if (!minXNode.isEmpty()) {
                headNode = new ListNode(minXNode.pollFirst());
            } else if (!maxXNode.isEmpty()) {
                headNode = new ListNode(maxXNode.pollFirst());
            }
            ListNode tempNode = headNode;
            while (!minXNode.isEmpty()) {
                tempNode.next = new ListNode(minXNode.pollFirst());
                tempNode = tempNode.next;
            }
            while (!maxXNode.isEmpty()) {
                tempNode.next = new ListNode(maxXNode.pollFirst());
                tempNode = tempNode.next;
            }
            return headNode;
        }
    }
}
