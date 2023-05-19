package com.yzy.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: Offer62
 * Description:
 * 0,1,···,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字（删除后从下一个数字开始计数）。求出这个圆圈里剩下的最后一个数字。
 *
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 *
 *
 *
 * 示例 1：
 *
 * 输入: n = 5, m = 3
 * 输出: 3
 * 示例 2：
 *
 * 输入: n = 10, m = 17
 * 输出: 2
 * @author Administrator
 * @date 2023-5-18 15:07
 */
public class Offer62 {
    public int lastRemaining(int n, int m) {
        int pos=0;  //初始化位置，后面要用做记录每一轮开始的位置。
        List<Integer> list= new ArrayList<>();
        for(int i=0;i<n;i++)
            list.add(i);  //先把所有数加到动态数组里。
        while(list.size()>1){ //循环条件要求list大小大于1，当只剩下最后一个数了就跳出
            int temp=(pos+m-1)%list.size();
            list.remove(temp);
            pos=temp;
        }
        return list.get(0);
    }
}
