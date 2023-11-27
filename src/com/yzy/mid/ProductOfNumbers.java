package com.yzy.mid;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/11/28 00:28
 * @Description
 * 请你实现一个「数字乘积类」ProductOfNumbers，要求支持下述两种方法：
 *
 * 1. add(int num)
 *
 * 将数字 num 添加到当前数字列表的最后面。
 * 2. getProduct(int k)
 *
 * 返回当前数字列表中，最后 k 个数字的乘积。
 * 你可以假设当前列表中始终 至少 包含 k 个数字。
 * 题目数据保证：任何时候，任一连续数字序列的乘积都在 32-bit 整数范围内，不会溢出。
 *
 *
 *
 * 示例：
 *
 * 输入：
 * ["ProductOfNumbers","add","add","add","add","add","getProduct","getProduct","getProduct","add","getProduct"]
 * [[],[3],[0],[2],[5],[4],[2],[3],[4],[8],[2]]
 *
 * 输出：
 * [null,null,null,null,null,null,20,40,0,null,32]
 *
 * 解释：
 * ProductOfNumbers productOfNumbers = new ProductOfNumbers();
 * productOfNumbers.add(3);        // [3]
 * productOfNumbers.add(0);        // [3,0]
 * productOfNumbers.add(2);        // [3,0,2]
 * productOfNumbers.add(5);        // [3,0,2,5]
 * productOfNumbers.add(4);        // [3,0,2,5,4]
 * productOfNumbers.getProduct(2); // 返回 20 。最后 2 个数字的乘积是 5 * 4 = 20
 * productOfNumbers.getProduct(3); // 返回 40 。最后 3 个数字的乘积是 2 * 5 * 4 = 40
 * productOfNumbers.getProduct(4); // 返回  0 。最后 4 个数字的乘积是 0 * 2 * 5 * 4 = 0
 * productOfNumbers.add(8);        // [3,0,2,5,4,8]
 * productOfNumbers.getProduct(2); // 返回 32 。最后 2 个数字的乘积是 4 * 8 = 32
 * @Version 1.0
 */
class ProductOfNumbers {

    private List<Integer> list;
    private int zeroIndex;


    public ProductOfNumbers() {
        list = new ArrayList<>();
        zeroIndex = -1;
    }

    public void add(int num) {
        //如果num为0，将其加到list中，并记录其索引位置
        if (num == 0) {
            list.add(num);
            zeroIndex = list.size() - 1;
            //如果list中没有数 或者前一个数刚好是0，那么直接加到list中
        }else if (list.size() == 0 || zeroIndex == list.size() - 1)
            list.add(num);
            //否则，记录其累乘结果
        else
            list.add(num * list.get(list.size() - 1));
    }

    //eg:add:2, 3, 4, 5 -> list:[2, 6, 24, 120]。getProduct(2) = 120 / 6 = 20;
    public int getProduct(int k) {
        int size = list.size();
        //如果k个数中包含0，直接返回0
        if (size - k <= zeroIndex)
            return 0;
        //如果k + 1个数刚好是0，分母不能为0，不能进行除法运算，直接返回即可，在add方法else if分支中解决了这个问题
        if (size - k - 1 == zeroIndex)
            return list.get(size - 1);

        return list.get(size - 1) / list.get(size - k - 1);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */