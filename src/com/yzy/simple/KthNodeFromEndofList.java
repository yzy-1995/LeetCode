package com.yzy.simple;

/**
 * ClassName: KthNodeFromEndofList
 * Description:
 *
 * @author Administrator
 * @date 2023-5-19 17:33
 */
public class KthNodeFromEndofList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public int kthToLast(ListNode head, int k) {
        if (head == null) {
            return 0;
        }

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && k > 0){
            fast = fast.next;

            k--;
        }

        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }

        return slow.val;
    }
}
