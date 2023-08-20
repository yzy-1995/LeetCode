package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/08/18 00:04
 * @Description
 * 实现 MyCircularDeque 类:
 *
 * MyCircularDeque(int k) ：构造函数,双端队列最大为 k 。
 * boolean insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true ，否则返回 false 。
 * boolean insertLast() ：将一个元素添加到双端队列尾部。如果操作成功返回 true ，否则返回 false 。
 * boolean deleteFront() ：从双端队列头部删除一个元素。 如果操作成功返回 true ，否则返回 false 。
 * boolean deleteLast() ：从双端队列尾部删除一个元素。如果操作成功返回 true ，否则返回 false 。
 * int getFront() )：从双端队列头部获得一个元素。如果双端队列为空，返回 -1 。
 * int getRear() ：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1 。
 * boolean isEmpty() ：若双端队列为空，则返回 true ，否则返回 false  。
 * boolean isFull() ：若双端队列满了，则返回 true ，否则返回 false 。
 *
 *
 * 示例 1：
 *
 * 输入
 * ["MyCircularDeque", "insertLast", "insertLast", "insertFront", "insertFront", "getRear", "isFull", "deleteLast", "insertFront", "getFront"]
 * [[3], [1], [2], [3], [4], [], [], [], [4], []]
 * 输出
 * [null, true, true, true, false, 2, true, true, true, 4]
 *
 * 解释
 * MyCircularDeque circularDeque = new MycircularDeque(3); // 设置容量大小为3
 * circularDeque.insertLast(1);			        // 返回 true
 * circularDeque.insertLast(2);			        // 返回 true
 * circularDeque.insertFront(3);			        // 返回 true
 * circularDeque.insertFront(4);			        // 已经满了，返回 false
 * circularDeque.getRear();  				// 返回 2
 * circularDeque.isFull();				        // 返回 true
 * circularDeque.deleteLast();			        // 返回 true
 * circularDeque.insertFront(4);			        // 返回 true
 * circularDeque.getFront();				// 返回 4
 * @Version 1.0
 */
public class designcirculardeque {
    private final int[] elements;
    private int size = 0, head = 0, tail;
    public designcirculardeque(int k) {
        elements = new int[k];
        tail = k - 1;
    }
    public boolean insertFront(int value) {
        if (isFull()) return false;
        elements[head = head == 0 ? elements.length - 1 : head - 1] = value;// 头指针左移
        size++;
        return true;
    }
    public boolean insertLast(int value) {
        if (isFull()) return false;
        elements[tail = tail == elements.length - 1 ? 0 : tail + 1] = value;// 尾指针右移
        size++;
        return true;
    }
    public boolean deleteFront() {
        if (isEmpty()) return false;
        head = head == elements.length - 1 ? 0 : head + 1;// 头指针右移
        size--;
        return true;
    }
    public boolean deleteLast() {
        if (isEmpty()) return false;
        tail = tail == 0 ? elements.length - 1 : tail - 1;// 尾指针左移
        size--;
        return true;
    }
    public int getFront() {
        if (isEmpty()) return -1;
        return elements[head];
    }
    public int getRear() {
        if (isEmpty()) return -1;
        return elements[tail];
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public boolean isFull() {
        return size == elements.length;
    }
}