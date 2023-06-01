package com.yzy.mid;

/**
 * ClassName: PartitionList
 * Description:
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * <p>
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 * 示例 1：
 * <p>
 * 输入：head = [1,4,3,2,5,2], x = 3
 * 输出：[1,2,2,4,3,5]
 * 示例 2：
 * <p>
 * 输入：head = [2,1], x = 2
 * 输出：[1,2]
 *
 * @author Administrator
 * @date 2023-5-25 9:34
 */
public class PartitionList {
    public static class ListNode {
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

    /**
     * 定义两个链表 prev 和 next，分别用于存储小于 x 的节点和大于等于 x 的节点，初始化为空链表。
     * 遍历链表，将小于 x 的节点添加到 prev 链表中，将大于等于 x 的节点添加到 next 链表中。
     * 将 prev 链表的尾节点指向 next 链表的头节点，即将两个链表合并起来。
     * 返回 prev 链表的头节点，即为最终结果。
     *
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        ListNode prev = new ListNode(-1);
        ListNode next = new ListNode(-1);
        ListNode prevListNode = prev;
        ListNode nextListNode = next;
        while (head != null) {
            if (head.val < x) {
                prevListNode.next = head;
                prevListNode = prevListNode.next;
            } else {
                nextListNode.next = head;
                nextListNode = nextListNode.next;
            }
            head = head.next;
        }
        prevListNode.next=next.next;
        nextListNode.next=null;
        return prev.next;
    }
}
