package com.yzy.mid;

/**
 * ClassName: ReorderList
 * Description:
 * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
 * <p>
 * L0 → L1 → … → Ln - 1 → Ln
 * 请将其重新排列后变为：
 * <p>
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：head = [1,2,3,4]
 * 输出：[1,4,2,3]
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：head = [1,2,3,4,5]
 * 输出：[1,5,2,4,3]
 *
 * @author Administrator
 * @date 2023-6-2 9:53
 */
public class ReorderList {
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

    public void reorderList(ListNode head) {
        if (head.next == null || head.next.next == null) return;
        ListNode cur = head;
        ListNode pre = cur;
        while (cur.next != null) {
            pre = cur;
            cur = cur.next;
        }
        cur.next = head.next;
        pre.next = null;
        head.next = cur;
        reorderList(head.next.next);
    }
}
