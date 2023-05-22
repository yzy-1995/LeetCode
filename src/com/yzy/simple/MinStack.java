package com.yzy.simple;

import java.util.Stack;

/**
 * ClassName: MinStack
 * Description:
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 * 示例:
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.min();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.min();   --> 返回 -2.
 * <p>
 * <p>
 * 提示：
 * <p>
 * 各函数的调用总次数不超过 20000 次
 *
 * @author Administrator
 * @date 2023-5-15 17:39
 */
public class MinStack {
    private Stack<Item> stack = new Stack<>();
    private int min = Integer.MAX_VALUE;

    static class Item {
        //元素当前的值
        private int val;
        //元素及元素下最小的值
        private int curMin;
    }

    public MinStack() {

    }

    public void push(int x) {
        Item item = new Item();
        item.val = x;
        if (x < min) {
            min = x;
        }
        item.curMin = min;
        stack.push(item);
    }

    public void pop() {
        stack.pop();
        if (stack.isEmpty()) {
            min = Integer.MAX_VALUE;
        } else {
            min = stack.peek().curMin;
        }
    }

    public int top() {
        return stack.peek().val;
    }

    public int getMin() {
        return min;
    }
}
