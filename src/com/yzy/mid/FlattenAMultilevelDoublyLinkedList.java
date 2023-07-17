package com.yzy.mid;

import java.util.Stack;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/07/17 01:16
 * @Description
 * 你会得到一个双链表，其中包含的节点有一个下一个指针、一个前一个指针和一个额外的 子指针 。这个子指针可能指向一个单独的双向链表，也包含这些特殊的节点。这些子列表可以有一个或多个自己的子列表，以此类推，以生成如下面的示例所示的 多层数据结构 。
 *
 * 给定链表的头节点 head ，将链表 扁平化 ，以便所有节点都出现在单层双链表中。让 curr 是一个带有子列表的节点。子列表中的节点应该出现在扁平化列表中的 curr 之后 和 curr.next 之前 。
 *
 * 返回 扁平列表的 head 。列表中的节点必须将其 所有 子指针设置为 null 。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：head = [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
 * 输出：[1,2,3,7,8,11,12,9,10,4,5,6]
 * 解释：输入的多级列表如上图所示。
 * 扁平化后的链表如下图：
 *
 * 示例 2：
 *
 *
 *
 * 输入：head = [1,2,null,3]
 * 输出：[1,3,2]
 * 解释：输入的多级列表如上图所示。
 * 扁平化后的链表如下图：
 *
 * 示例 3：
 *
 * 输入：head = []
 * 输出：[]
 * 说明：输入中可能存在空列表。
 * @Version 1.0
 */
public class FlattenAMultilevelDoublyLinkedList {
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    };
    public Node flatten(Node head) {
        if(head==null)return null;
        Stack<Node> stack=new Stack<>();
        stack.push(head);
        Node xuni=new Node();//虚拟头结点方便重新串联
        Node pre=xuni;//pre
        //child--->left  next--->right 先根
        while(!stack.isEmpty()){
            Node temp=stack.pop();//temp  pre<--->temp
            if(temp.next!=null)stack.push(temp.next);//right
            if(temp.child!=null)stack.push(temp.child);//left
            //重新串联
            pre.next=temp;
            temp.prev=pre;
            temp.child=null;
            pre=temp;
        }
        head.prev=null;//取消head的prev
        return head;
    }
}