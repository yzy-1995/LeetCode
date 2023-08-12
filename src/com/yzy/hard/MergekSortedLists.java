package com.yzy.hard;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.hard
 * @Date 2023/08/12 10:53
 * @Description 给你一个链表数组，每个链表都已经按升序排列。
 * <p>
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 * 示例 2：
 * <p>
 * 输入：lists = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：lists = [[]]
 * 输出：[]
 * @Version 1.0
 */
public class MergekSortedLists {
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

    PriorityQueue<ListNode> queue = new PriorityQueue<>(11, Comparator.comparingInt(o -> o.val));

    public ListNode mergeKLists(ListNode[] lists) {
        // 将所有节点放入小顶堆中
        for (ListNode list : lists) {
            ListNode head = list;
            while (head != null) {
                queue.add(head);
                head = head.next;
            }
        }
        // 初始化结果节点
        ListNode ans = new ListNode();
        // 定义游标节点
        ListNode inner = ans;
        // 队列循环获取最小值
        while (!queue.isEmpty()) {
            ListNode poll = queue.poll();
            if (poll != null) {
                inner.next = new ListNode(poll.val);
            }
            inner = inner.next;
        }
        return ans.next;
    }
}