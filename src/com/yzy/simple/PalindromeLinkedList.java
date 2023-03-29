package com.yzy.simple;

/**
 * ClassName: PalindromeLinkedList
 * Description:
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。
 * 如果是，返回 true ；否则，返回 false 。
 *
 * @author Administrator
 * @date 2023-3-28 8:58
 */
public class PalindromeLinkedList {
    public static void main(String[] args) {

    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode mid = findMid(head);
        ListNode right = reverse(mid.next);
        ListNode left = head;
        while (right != null) {
            if (left.val != right.val) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    public ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

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
}
