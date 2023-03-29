package com.yzy.mid;

/**
 * ClassName: RemoveNthNodeFromEndofList
 * Description:
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 * @author Administrator
 * @date 2023-3-28 15:10
 */
public class RemoveNthNodeFromEndofList {
    public static void main(String[] args) {

    }

    /**
     * 我们可以使用双指针来解决这个问题。具体来说，我们可以使用两个指针 p 和 q，初始时都指向头结点。
     * 首先让 p 移动 n 个结点，然后同时让 p 和 q 向后移动，直到 p 指向链表的末尾，此时 q 指向要删除的结点的前一个结点。
     * 最后将 q 的 next 指针指向 q.next.next 即可。
     *
     * 需要注意的是，当要删除的结点是头结点时，我们需要特殊处理。可以添加一个哑结点作为头结点的前一个结点，这样就可以避免特殊处理头结点的情况。
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);
        ListNode p = head, q = dummy;
        for (int i = 0; i < n; i++) {
            p = p.next;
        }
        while (p != null) {
            p = p.next;
            q = q.next;
        }
        q.next = q.next.next;
        return dummy.next;
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
