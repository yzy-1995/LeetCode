package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/09/02 23:50
 * @Description
 * 给你一个头结点为 head 的单链表和一个整数 k ，请你设计一个算法将链表分隔为 k 个连续的部分。
 *
 * 每部分的长度应该尽可能的相等：任意两部分的长度差距不能超过 1 。这可能会导致有些部分为 null 。
 *
 * 这 k 个部分应该按照在链表中出现的顺序排列，并且排在前面的部分的长度应该大于或等于排在后面的长度。
 *
 * 返回一个由上述 k 部分组成的数组。
 *
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3], k = 5
 * 输出：[[1],[2],[3],[],[]]
 * 解释：
 * 第一个元素 output[0] 为 output[0].val = 1 ，output[0].next = null 。
 * 最后一个元素 output[4] 为 null ，但它作为 ListNode 的字符串表示是 [] 。
 * 示例 2：
 *
 *
 * 输入：head = [1,2,3,4,5,6,7,8,9,10], k = 3
 * 输出：[[1,2,3,4],[5,6,7],[8,9,10]]
 * 解释：
 * 输入被分成了几个连续的部分，并且每部分的长度相差不超过 1 。前面部分的长度大于等于后面部分的长度。
 * @Version 1.0
 */
public class splitlinkedlistinparts {
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

  public ListNode[] splitListToParts(ListNode head, int k) {
    // 1. 求长度
    int len = 0;
    ListNode p = head;
    while(p != null) {
      len++;
      p = p.next;
    }
    // 2. 求具体数量, 前 b 个长度是 a + 1
    int a = len / k, b = len % k;
    // 3. 添加
    p = head;
    ListNode[] ans = new ListNode[k];
    for(int i = 0; i < k; ++i) {
      ans[i] = p;
      if(p == null) continue; // ans[i] = [], 则剩余的将都是 []
      ListNode temp = p;
      for(int j = 1; j < a + (b > 0? 1 : 0); ++j) { // 已经添加了一个
        temp = temp.next;
      }
      p = temp.next; // 因为 len = a * k + b, temp 一定不是 null
      temp.next = null;
      b--; // 最小值是 len % k - k, 不会出现下越界的情况
    }
    return ans;
  }
}