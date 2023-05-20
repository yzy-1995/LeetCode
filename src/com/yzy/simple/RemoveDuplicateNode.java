package com.yzy.simple;

import java.util.HashSet;
import java.util.Set;

/**
 * ClassName: RemoveDuplicateNode
 * Description:
 * 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
 * <p>
 * 示例1:
 * <p>
 * 输入：[1, 2, 3, 3, 2, 1]
 * 输出：[1, 2, 3]
 * 示例2:
 * <p>
 * 输入：[1, 1, 1, 1, 2]
 * 输出：[1, 2]
 *
 * @author Administrator
 * @date 2023-5-19 16:47
 */
public class RemoveDuplicateNode {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) {
            return null;
        }
        Set<Integer> set = new HashSet<>();
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        while (pre.next != null) {
            if (!set.contains(pre.next.val)) {
                set.add(pre.next.val);
                pre = pre.next;
            } else {
                pre.next = pre.next.next;
            }
        }
        return dummyHead.next;
    }
}
