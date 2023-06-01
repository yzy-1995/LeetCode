package com.yzy.mid;

/**
 * ClassName: RemoveDuplicatesFromSortedListII
 * Description:
 * 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
 * 示例 1：
 * <p>
 * 输入：head = [1,2,3,3,4,4,5]
 * 输出：[1,2,5]
 * 示例 2：
 * <p>
 * 输入：head = [1,1,1,2,3]
 * 输出：[2,3]
 *
 * @author Administrator
 * @date 2023-5-24 17:18
 */
public class RemoveDuplicatesFromSortedListII {
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

    public ListNode deleteDuplicates(ListNode head) {
        // 创建哑节点，将其 next 指针指向链表的头节点
        ListNode dummy = new ListNode(-1, head);
        // 定义两个指针 prev 和 curr，分别指向链表的前一个节点和当前节点
        ListNode prev = dummy;
        ListNode curr = head;
        // 遍历链表
        while (curr != null) {
            // 如果当前节点与上一个节点的值相同，说明当前节点是重复节点，需要删除
            if (curr.next != null && curr.val == curr.next.val) {
                while (curr.next != null && curr.val == curr.next.val) {
                    curr = curr.next;
                }
                prev.next = curr.next;
                curr = curr.next;
            } else {
                // 如果当前节点与上一个节点的值不同，说明当前节点是不重复节点，需要保留
                prev = curr;
                curr = curr.next;
            }
        }
        return dummy.next;
    }
}
