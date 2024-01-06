package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2024/01/06 10:01
 * @Description 给你一个链表的头 head ，每个结点包含一个整数值。
 * <p>
 * 在相邻结点之间，请你插入一个新的结点，结点值为这两个相邻结点值的 最大公约数 。
 * <p>
 * 请你返回插入之后的链表。
 * <p>
 * 两个数的 最大公约数 是可以被两个数字整除的最大正整数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：head = [18,6,10,3]
 * 输出：[18,6,6,2,10,1,3]
 * 解释：第一幅图是一开始的链表，第二幅图是插入新结点后的图（蓝色结点为新插入结点）。
 * - 18 和 6 的最大公约数为 6 ，插入第一和第二个结点之间。
 * - 6 和 10 的最大公约数为 2 ，插入第二和第三个结点之间。
 * - 10 和 3 的最大公约数为 1 ，插入第三和第四个结点之间。
 * 所有相邻结点之间都插入完毕，返回链表。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：head = [7]
 * 输出：[7]
 * 解释：第一幅图是一开始的链表，第二幅图是插入新结点后的图（蓝色结点为新插入结点）。
 * 没有相邻结点，所以返回初始链表。
 * @Version 1.0
 */
public class insertgreatestcommondivisorsinlinkedlist {
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
  public ListNode insertGreatestCommonDivisors(ListNode head) {
    // 双指针模拟 + gcd
    if(head.next == null) return head;
    ListNode vir = new ListNode(-1, head);
    ListNode pre = head, curr = head.next;
    while(curr != null){
      int a = Math.max(curr.val, pre.val), b = Math.min(curr.val, pre.val);
      pre.next = new ListNode(gcd(a, b), curr);
      pre = curr;
      curr = curr.next;
    }
    return vir.next;
  }
  public int gcd(int a, int b){
    if(a % b == 0) return b;
    return gcd(b, a % b);
  }
}