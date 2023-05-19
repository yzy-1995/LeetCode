package com.yzy.simple;

/**
 * ClassName: OfferII024
 * Description:
 * 给定单链表的头节点 head ，请反转链表，并返回反转后的链表的头节点。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 * 示例 2：
 * <p>
 * <p>
 * 输入：head = [1,2]
 * 输出：[2,1]
 * 示例 3：
 * <p>
 * 输入：head = []
 * 输出：[]
 *
 * @author Administrator
 * @date 2023-5-19 14:48
 */
public class OfferII024 {
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

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode node = reverseList(head.next); // 保存尾结点;
        head.next.next = head; // 翻转指针;
        head.next = null; // 置空，递归已保存上一个结点，置空不影响连接
        return node; // 返回尾结点
    }
}
