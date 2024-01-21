package com.yzy.mid;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2024/01/22 00:33
 * @Description
 * 大餐 是指 恰好包含两道不同餐品 的一餐，其美味程度之和等于 2 的幂。
 *
 * 你可以搭配 任意 两道餐品做一顿大餐。
 *
 * 给你一个整数数组 deliciousness ，其中 deliciousness[i] 是第 i​​​​​​​​​​​​​​ 道餐品的美味程度，返回你可以用数组中的餐品做出的不同 大餐 的数量。结果需要对 109 + 7 取余。
 *
 * 注意，只要餐品下标不同，就可以认为是不同的餐品，即便它们的美味程度相同。
 *
 *
 *
 * 示例 1：
 *
 * 输入：deliciousness = [1,3,5,7,9]
 * 输出：4
 * 解释：大餐的美味程度组合为 (1,3) 、(1,7) 、(3,5) 和 (7,9) 。
 * 它们各自的美味程度之和分别为 4 、8 、8 和 16 ，都是 2 的幂。
 * 示例 2：
 *
 * 输入：deliciousness = [1,1,1,3,3,3,7]
 * 输出：15
 * 解释：大餐的美味程度组合为 3 种 (1,1) ，9 种 (1,3) ，和 3 种 (1,7) 。
 * @Version 1.0
 */
public class countgoodmeals {
    int mod = (int)1e9+7;
    int max = 1<<22;

    public int countPairs(int[] deliciousness) {
        //哈希表
        long ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(Integer d : deliciousness){
            map.put(d, map.getOrDefault(d, 0) +1); //统计原数组的每个元素值的个数
        }
        //单次遍历所有的元素值种类
        for(int d : map.keySet()){
            for(int i = 1; i < max; i<<=1){ //遍历所有的幂和的情况
                int t = i - d;
                if(map.containsKey(t)){ //可以在原数组中找到可以组成指定幂和的元素
                    if(d == t){ //原数组元素刚好为指定幂和的一半, 则累计总数的时候, 只能当前元素与其他元素组合, 所以需要用 map.get(t) * (map.get(t)-1)
                        ans += (map.get(d)-1) * 1L * map.get(d);    //此处要注意, 要先*1L, 将int转换为long之后再相乘, 否则会造成数据丢失
                    }else{
                        ans += map.get(t) *1L * map.get(d);
                    }
                }
            }
        }
        ans >>= 1;    //因为累加的时候, 每种组合方式都计算了两遍, 所以需要/2;
        return (int) (ans % mod);
    }
}