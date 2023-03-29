package com.yzy.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: ImplementStackUsingQueues
 * Description:
 * 请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（push、top、pop 和 empty）。
 *
 * 实现 MyStack 类：
 *
 * void push(int x) 将元素 x 压入栈顶。
 * int pop() 移除并返回栈顶元素。
 * int top() 返回栈顶元素。
 * boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。
 * @author Administrator
 * @date 2023-3-29 9:22
 */
public class ImplementStackUsingQueues {
    private List list = new ArrayList<>();

    public static void main(String[] args) {
        ImplementStackUsingQueues myStack = new ImplementStackUsingQueues();
        myStack.push(1);
        myStack.push(2);
        myStack.top(); // 返回 2
        myStack.pop(); // 返回 2
        myStack.empty(); // 返回 False
    }


    public void push(int x) {
        list.add(x);
    }

    public int pop() {
        List<Integer> listOld = new ArrayList<Integer>();
        listOld.addAll(list);
        list.remove(list.size() - 1);
        return Integer.valueOf(listOld.get(listOld.size() - 1).toString());
    }

    public int top() {
        return Integer.valueOf(list.get(list.size() - 1).toString());
    }

    public boolean empty() {
        if (list.isEmpty()){
            return true;
        }else {
            return false;
        }
    }
}
