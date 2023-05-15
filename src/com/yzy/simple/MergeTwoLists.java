package com.yzy.simple;

/**
 * ClassName: MergeTwoLists
 * Description:
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 * 示例1：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * @author Administrator
 * @date 2023-5-15 13:43
 */
public class MergeTwoLists {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1), pre = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                pre.next = l1;
                pre = pre.next;
                l1 = l1.next;
            } else {
                pre.next = l2;
                pre = pre.next;
                l2 = l2.next;
            }
        }
        if (l1 != null) {
            pre.next = l1;
        }
        if (l2 != null) {
            pre.next = l2;
        }

        return dummyHead.next;
    }
}
