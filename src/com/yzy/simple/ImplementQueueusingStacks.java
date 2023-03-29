package com.yzy.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: ImplementQueueusingStacks
 * Description:
 * 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
 * <p>
 * 实现 MyQueue 类：
 * <p>
 * void push(int x) 将元素 x 推到队列的末尾
 * int pop() 从队列的开头移除并返回元素
 * int peek() 返回队列开头的元素
 * boolean empty() 如果队列为空，返回 true ；否则，返回 false
 *
 * @author Administrator
 * @date 2023-3-29 11:32
 */
public class ImplementQueueusingStacks {
    private List<Integer> inList;
    private List<Integer> outList;


    public ImplementQueueusingStacks() {
        inList = new ArrayList<>();
        outList = new ArrayList<>();
    }

    public void push(int x) {
        inList.add(x);
    }

    public int pop() {
        peek();
        return outList.remove(outList.size()-1);
    }

    public int peek() {
        if (outList.isEmpty()){
            while(!inList.isEmpty()){
                outList.add(inList.remove(inList.size()-1));
            }
        }
        return outList.get(outList.size()-1);
    }

    public boolean empty() {
        return inList.isEmpty()&&outList.isEmpty();
    }
}
