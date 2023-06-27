package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/06/27 19:17
 * @Description
 * @Version 1.0
 */
public class OddEvenLinkedList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null) return head;
        ListNode j = head;
        ListNode o = head.next;
        ListNode p = head.next;
        while (j.next != null && o.next != null) {
            j.next = o.next;
            j = j.next;
            o.next = j.next;
            o = o.next;
        }
        j.next = p;
        return head;
    }
}