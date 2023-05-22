package com.yzy.simple;

/**
 * Description: leetcode
 *
 * @author yzy15
 * @date 2023/05/20 09:20
 **/
public class ThreeinOne {
    int[] arr;
    int stackSize;
    int cur_num = 0;
    //记录 3 个栈每个栈可以插入的下标，本质上使用 3 个指针，这里直接简化使用一个大小为 3 的数组
    int[] indexs;
    public ThreeinOne(int stackSize) {
        arr = new int[stackSize * 3];
        this.stackSize = stackSize;
        indexs = new int[]{0, 1, 2};
    }
    //stackNum 表示的是 3 个栈中某个选择某个栈的下标
    public void push(int stackNum, int value) {
        //当前栈的可插入下标超过了界限，那么表示已经满了，不能再进行插入了
        if(indexs[stackNum] >= stackSize * 3){
            return;
        }
        arr[indexs[stackNum]] = value;
        indexs[stackNum] += 3;
    }

    public int pop(int stackNum) {
        if(isEmpty(stackNum)){
            return -1;
        }
        indexs[stackNum] -= 3;
        return arr[indexs[stackNum]];
    }

    public int peek(int stackNum) {
        if(isEmpty(stackNum)){
            return -1;
        }
        return arr[indexs[stackNum] - 3];
    }

    public boolean isEmpty(int stackNum) {
        //当前栈的可插入下标 < 3，即为 0、1、2 时，表示还没有元素入栈，即为空
        return indexs[stackNum] < 3;
    }
}
