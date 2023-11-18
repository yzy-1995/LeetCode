package com.yzy.mid;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/11/18 00:23
 * @Description
 * 我们定义「顺次数」为：每一位上的数字都比前一位上的数字大 1 的整数。
 *
 * 请你返回由 [low, high] 范围内所有顺次数组成的 有序 列表（从小到大排序）。
 *
 *
 *
 * 示例 1：
 *
 * 输出：low = 100, high = 300
 * 输出：[123,234]
 * 示例 2：
 *
 * 输出：low = 1000, high = 13000
 * 输出：[1234,2345,3456,4567,5678,6789,12345]
 * @Version 1.0
 */
public class sequentialdigits {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> list=new ArrayList<>();
        String s="123456789";
        for(int i=1;i<=9;i++){
            for(int j=0;j+i<=s.length();j++){
                int num = Integer.parseInt(s.substring(j,j+i));
                if(num>high){
                    break;
                }
                else if(num>=low){
                    list.add(num);
                }
            }
        }
        return list;
    }
}