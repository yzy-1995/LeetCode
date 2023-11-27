package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/11/28 00:24
 * @Description
 * 请你设计一个队列，支持在前，中，后三个位置的 push 和 pop 操作。
 *
 * 请你完成 FrontMiddleBack 类：
 *
 * FrontMiddleBack() 初始化队列。
 * void pushFront(int val) 将 val 添加到队列的 最前面 。
 * void pushMiddle(int val) 将 val 添加到队列的 正中间 。
 * void pushBack(int val) 将 val 添加到队里的 最后面 。
 * int popFront() 将 最前面 的元素从队列中删除并返回值，如果删除之前队列为空，那么返回 -1 。
 * int popMiddle() 将 正中间 的元素从队列中删除并返回值，如果删除之前队列为空，那么返回 -1 。
 * int popBack() 将 最后面 的元素从队列中删除并返回值，如果删除之前队列为空，那么返回 -1 。
 * 请注意当有 两个 中间位置的时候，选择靠前面的位置进行操作。比方说：
 *
 * 将 6 添加到 [1, 2, 3, 4, 5] 的中间位置，结果数组为 [1, 2, 6, 3, 4, 5] 。
 * 从 [1, 2, 3, 4, 5, 6] 的中间位置弹出元素，返回 3 ，数组变为 [1, 2, 4, 5, 6] 。
 *
 *
 * 示例 1：
 *
 * 输入：
 * ["FrontMiddleBackQueue", "pushFront", "pushBack", "pushMiddle", "pushMiddle", "popFront", "popMiddle", "popMiddle", "popBack", "popFront"]
 * [[], [1], [2], [3], [4], [], [], [], [], []]
 * 输出：
 * [null, null, null, null, null, 1, 3, 4, 2, -1]
 *
 * 解释：
 * FrontMiddleBackQueue q = new FrontMiddleBackQueue();
 * q.pushFront(1);   // [1]
 * q.pushBack(2);    // [1, 2]
 * q.pushMiddle(3);  // [1, 3, 2]
 * q.pushMiddle(4);  // [1, 4, 3, 2]
 * q.popFront();     // 返回 1 -> [4, 3, 2]
 * q.popMiddle();    // 返回 3 -> [4, 2]
 * q.popMiddle();    // 返回 4 -> [2]
 * q.popBack();      // 返回 2 -> []
 * q.popFront();     // 返回 -1 -> [] （队列为空）
 * @Version 1.0
 */
class FrontMiddleBackQueue {
    int size;

    class Node {
        int val;
        Node pre, next;
    }

    Node head, mid, tail;

    boolean isEmpty() {
        return size == 0;
    }

    public FrontMiddleBackQueue() {
    }

    public void pushFront(int val) {
        Node node = new Node();
        node.val = val;
        if (isEmpty()) {
            size++;
            head = node;
            mid = node;
            tail = node;
            return;
        }
        // [1] front 2 的时候只有一个 mid 应该指向 2
        // [2,1] front 3 时 就不变
        // [3,2,1] front 4 时就指向 3 ->[4,3,2,1]
        node.next = head;
        head.pre = node;
        head = node;
        if ((size++ & 1) == 1) mid = mid.pre;
    }

    public void pushMiddle(int val) {
        Node node = new Node();
        node.val = val;
        if (isEmpty()) {
            size++;
            head = node;
            mid = node;
            tail = node;
            return;
        }
        /*
            奇数个节点时 pushMiddle(x)
            [1] -> [x,1]
            [1,2,3] -> [1,x,2,3]
            [1,2,3,4,5] -> [1,2,x,3,4,5]

            偶数个节点时 pushMiddle(x)
            [1,2] -> [1,x,2]  mid从1要到x
            [1,2,3,4] -> [1,2,x,3,4] mid从2要到x
         */
        if ((size++ & 1) == 0) {
            // 追加到 mid 后面
            Node oldNext = mid.next;
            mid.next = node;
            node.pre = mid;
            node.next = oldNext;

            if (oldNext != null) oldNext.pre = node;

            mid = mid.next;
        } else {
            Node oldPre = mid.pre;
            mid.pre = node;
            node.next = mid;
            node.pre = oldPre;

            if (oldPre != null) oldPre.next = node;
            if (size == 2) head = node;
            mid = mid.pre;
        }
    }

    public void pushBack(int val) {
        Node node = new Node();
        node.val = val;
        if (isEmpty()) {
            size++;
            head = node;
            mid = node;
            tail = node;
            return;
        }
        // [1] back 2 的时候只有一个 mid 应该指向
        // [1 , 2] mid = 1
        // [1 , 2 , 3] 添加三的时候要往前走一下
        tail.next = node;
        node.pre = tail;
        tail = node;
        if ((size++ & 1) == 0) mid = mid.next;
    }

    public int popFront() {
        if (isEmpty()) return -1;
        int v = head.val;
        Node oldNext = head.next;
        if (oldNext != null) head.next.pre = null;
        head.next = null;
        head = oldNext;
        if ((size-- & 1) == 0 && (size != 1)) mid = mid.next;
        if (size == 1) {
            mid = head;
            tail = oldNext;
        }
        return v;
    }

    public int popMiddle() {
        if (isEmpty()) return -1;
        /*
            奇数个pop
            [1]
            [1,2,3] ->[1,3]

            偶数个pop
            [1,2] ->[2]
            [1,2,4,5] ->[1, 4 ,5]
         */
        Node oldPre = mid.pre, oldNext = mid.next;
        int v = mid.val;
        if (oldNext != null) oldNext.pre = oldPre;
        if (oldPre != null) oldPre.next = oldNext;
        mid.pre = null;
        mid.next = null;
        if ((size-- & 1) == 1) mid = oldPre;
        else mid = oldNext;

        if (size == 1){
            head = mid;
            tail = mid;
        }
        return v;
    }

    public int popBack() {
        if (isEmpty()) return -1;
        int v = tail.val;
        Node oldPre = tail.pre;
        if (oldPre != null) tail.pre.next = null;
        tail.pre = null;
        tail = oldPre;
        if ((size-- & 1) == 1 && (size != 1)) mid = mid.pre;
        if (size == 1){
            head = oldPre;
            tail = oldPre;
        }
        return v;
    }

}