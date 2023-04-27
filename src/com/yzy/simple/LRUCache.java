package com.yzy.simple;

import java.util.HashMap;

/**
 * ClassName: LRUCache
 * Description:
 * 请你设计并实现一个满足 LRU 《最近最少使用)缓存 约束的数据结构实现 LRUCache 类:
 * LRuCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key，int value) 如果关键字key 已经存在，则变更其数据值 value : 如果不存在，则向缓存中插入该组 key-value。如果插入操作导致关键字数量超过capacity
 * 则应该 逐出 最久未使用的关键字函数 get 和 put 必须以 o(1) 的平均时间复杂度运行
 * 示例:
 * 输入
 * ["LRUCache","put","put", "get","put","get","put", "get","get"]get[[2]，[1， 1]，[2，2]，[1]， [3， 3]，[2]，[4， 4]，[1]，[3]，[4]]输出
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 * 解释
 * LRUCache IRuCache = new LRUCache(2);
 * IRUCache.put(1，1); // 缓存是1=1}
 * IRUCache.put(2，2); // 缓存是{1=1，2=2}
 * IRUCache.get(1);// 返回 1
 * IRUCache.put(3，3); // 该操作会使得关键字 2 作废，缓存是 1=1，3=3
 * IRUCacheget(2);// 返回 -1 (末找到)
 * IRUCache.put(4，4); // 该操作会使得关键字 1 作废，缓存是 4=4，3=3
 * // 返回 -1 (未找到)IRUCache.get(1);
 * // 返回 3IRuCache.get(3);
 * IRuCache.get(4);// 返回 4
 * 提示:
 * 1 <= capacity <= 3009
 * B <= kev c= 18800
 * 6 <= value <= 1
 * 苦最多调用 2 * 15getput
 *
 * @author Administrator
 * @date 2023-4-27 17:07
 */
public class LRUCache {
    /**
     * 双向链表和一个 HashMap
     * 双向链表用于存储缓存中的键值对，同时保持 LRU 顺序
     * HashMap 用于在 O(1) 时间内检索键值对
     */
    private class LinkNode {
        int key;
        int value;
        LinkNode prev;
        LinkNode next;
    }

    public static void main(String[] args) {

        LRUCache IRuCache = new LRUCache(2);
        IRuCache.put(1,1); // 缓存是1=1}
        IRuCache.put(2,2); // 缓存是{1=1，2=2}
        System.out.println(IRuCache.get(1));// 返回 1
        IRuCache.put(3,3); // 该操作会使得关键字 2 作废，缓存是 1=1，3=31
        System.out.println(IRuCache.get(2));// 返回 -1 (末找到)
        System.out.println(IRuCache.get(3));// 返回3
        IRuCache.put(4,4);
        System.out.println(IRuCache.get(4));// 返回4

    }

    private void addNode(LinkNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(LinkNode node) {
        LinkNode prev = node.prev;
        LinkNode next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    private void moveToHead(LinkNode node) {
        removeNode(node);
        addNode(node);
    }

    private LinkNode popTail() {
        LinkNode res = tail.prev;
        removeNode(res);
        return res;
    }


    private HashMap<Integer, LinkNode> cache = new HashMap<>();
    private int size;
    private int capacity;
    private LinkNode head, tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;

        head = new LinkNode();
        tail = new LinkNode();

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        LinkNode node = cache.get(key);
        if (node == null) {
            return -1;
        }

        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        LinkNode node = cache.get(key);

        if (node == null) {
            LinkNode newNode = new LinkNode();
            newNode.key = key;
            newNode.value = value;

            cache.put(key, newNode);
            addNode(newNode);

            ++size;

            if (size > capacity) {
                LinkNode tail = popTail();
                cache.remove(tail.key);
                --size;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }
}
