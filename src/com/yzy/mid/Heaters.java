package com.yzy.mid;

import java.util.Arrays;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/07/27 00:14
 * @Description
 * 冬季已经来临。 你的任务是设计一个有固定加热半径的供暖器向所有房屋供暖。
 *
 * 在加热器的加热半径范围内的每个房屋都可以获得供暖。
 *
 * 现在，给出位于一条水平线上的房屋 houses 和供暖器 heaters 的位置，请你找出并返回可以覆盖所有房屋的最小加热半径。
 *
 * 说明：所有供暖器都遵循你的半径标准，加热的半径也一样。
 *
 *
 *
 * 示例 1:
 *
 * 输入: houses = [1,2,3], heaters = [2]
 * 输出: 1
 * 解释: 仅在位置2上有一个供暖器。如果我们将加热半径设为1，那么所有房屋就都能得到供暖。
 * 示例 2:
 *
 * 输入: houses = [1,2,3,4], heaters = [1,4]
 * 输出: 1
 * 解释: 在位置1, 4上有两个供暖器。我们需要将加热半径设为1，这样所有房屋就都能得到供暖。
 * 示例 3：
 *
 * 输入：houses = [1,5], heaters = [2]
 * 输出：3
 * @Version 1.0
 */
public class Heaters {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int left = 0, right = 1000000000;//左闭右开的二分查找最左边界：这里注意r的取值范围为： [0,1e9-1]，换成左闭右开区间为：[0,1e9]
        while(left < right){
            int mid = left + (right - left)/2;
            if(check(houses,heaters,mid))
                right = mid;
            else
                left = mid + 1;
        }
        return left;
    }
    //该方法检查以r为半径是否足够覆盖整个屋子
    private boolean check(int[] houses,int[] heaters,int r){
        int i = 0,j = 0;
        while(i < houses.length && j < heaters.length){//i指向houses中元素，j指向heaters中元素
            if(Math.abs(heaters[j] - houses[i]) <= r){
                i++;//当前屋子在供暖器半径范围内，因此i++判断下一个屋子
            }else{
                j++;//当前屋子houses[i]不在当前供暖器heaters[j]的加热范围内，因此j++找寻后面的加热器
            }
        }
        if(i < houses.length)
            return false;
        return true;
    }
}