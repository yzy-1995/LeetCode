package com.yzy.mid;

/**
 * ClassName: RotateList
 * Description:
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[4,5,1,2,3]
 * 示例 2：
 * <p>
 * <p>
 * 输入：head = [0,1,2], k = 4
 * 输出：[2,0,1]
 *
 * @author Administrator
 * @date 2023-5-23 14:59
 */
public class RotateList {
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

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        if (k == 0) {
            return head;
        }
        ListNode tail = head;
        ListNode newtail = head;
        ListNode newhead;
        int n = 1;
        while (tail.next != null) {
            tail = tail.next;
            n++;
        }
        tail.next = head;
        for (int i = 0; i < (n - k % n - 1); i++) {
            newtail = newtail.next;
        }

        newhead = newtail.next;
        newtail.next = null;

        return newhead;
    }


}
