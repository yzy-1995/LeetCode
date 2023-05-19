package com.yzy.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: OfferII026
 * Description:
 * 给定一个链表的 头节点 head ，请判断其是否为回文链表。
 *
 * 如果一个链表是回文，那么链表节点序列从前往后看和从后往前看是相同的。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入: head = [1,2,3,3,2,1]
 * 输出: true
 * 示例 2：
 *
 *
 *
 * 输入: head = [1,2]
 * 输出: false
 *
 *
 * 提示：
 *
 * 链表 L 的长度范围为 [1, 105]
 * 0 <= node.val <= 9
 * @author Administrator
 * @date 2023-5-19 15:02
 */
public class OfferII026 {
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

    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return false;
        }

        List<Integer> valList = new ArrayList<>();
        for (ListNode cur = head; cur != null; cur = cur.next) {
            valList.add(cur.val);
        }

        int left = 0;
        int right = valList.size() - 1;
        while (left < right) {
            if (!valList.get(left).equals(valList.get(right))) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
