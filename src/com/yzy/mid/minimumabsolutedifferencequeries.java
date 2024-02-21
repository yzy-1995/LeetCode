package com.yzy.mid;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2024/02/19 00:30
 * @Description
 * 一个数组 a 的 差绝对值的最小值 定义为：0 <= i < j < a.length 且 a[i] != a[j] 的 |a[i] - a[j]| 的 最小值。如果 a 中所有元素都 相同 ，那么差绝对值的最小值为 -1 。
 *
 * 比方说，数组 [5,2,3,7,2] 差绝对值的最小值是 |2 - 3| = 1 。注意答案不为 0 ，因为 a[i] 和 a[j] 必须不相等。
 * 给你一个整数数组 nums 和查询数组 queries ，其中 queries[i] = [li, ri] 。对于每个查询 i ，计算 子数组 nums[li...ri] 中 差绝对值的最小值 ，子数组 nums[li...ri] 包含 nums 数组（下标从 0 开始）中下标在 li 和 ri 之间的所有元素（包含 li 和 ri 在内）。
 *
 * 请你返回 ans 数组，其中 ans[i] 是第 i 个查询的答案。
 *
 * 子数组 是一个数组中连续的一段元素。
 *
 * |x| 的值定义为：
 *
 * 如果 x >= 0 ，那么值为 x 。
 * 如果 x < 0 ，那么值为 -x 。
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,3,4,8], queries = [[0,1],[1,2],[2,3],[0,3]]
 * 输出：[2,1,4,1]
 * 解释：查询结果如下：
 * - queries[0] = [0,1]：子数组是 [1,3] ，差绝对值的最小值为 |1-3| = 2 。
 * - queries[1] = [1,2]：子数组是 [3,4] ，差绝对值的最小值为 |3-4| = 1 。
 * - queries[2] = [2,3]：子数组是 [4,8] ，差绝对值的最小值为 |4-8| = 4 。
 * - queries[3] = [0,3]：子数组是 [1,3,4,8] ，差的绝对值的最小值为 |3-4| = 1 。
 * 示例 2：
 *
 * 输入：nums = [4,5,2,2,7,10], queries = [[2,3],[0,2],[0,5],[3,5]]
 * 输出：[-1,1,1,3]
 * 解释：查询结果如下：
 * - queries[0] = [2,3]：子数组是 [2,2] ，差绝对值的最小值为 -1 ，因为所有元素相等。
 * - queries[1] = [0,2]：子数组是 [4,5,2] ，差绝对值的最小值为 |4-5| = 1 。
 * - queries[2] = [0,5]：子数组是 [4,5,2,2,7,10] ，差绝对值的最小值为 |4-5| = 1 。
 * - queries[3] = [3,5]：子数组是 [2,7,10] ，差绝对值的最小值为 |7-10| = 3 。
 * @Version 1.0
 */
public class minimumabsolutedifferencequeries {
    public int[] minDifference(int[] nums, int[][] queries) {
        int n = nums.length;
        int[][] arr = new int[n][101];
        Map<Integer,Integer> m = new HashMap<>();
        m.put(nums[0],1);arr[0][nums[0]]++;
        for (int i = 1; i < n; i++) {
            for (Map.Entry<Integer, Integer> entry : m.entrySet()) {
                int key = entry.getKey(),value = entry.getValue();
                arr[i][key]+=value;
            }
            Integer integer = m.get(nums[i]);
            if(integer==null)
                integer = 0;
            m.put(nums[i],integer+1);
            arr[i][nums[i]]++;
        }
        int len = queries.length;
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            int min = Integer.MAX_VALUE;
            int l = queries[i][0]-1,r = queries[i][1];
            int[] cur = new int[101];
            for (int j = 0; j < 101; j++)
                cur[j] = Math.max(0,arr[r][j]-(l>-1?arr[l][j]:0));
            int pre = -1;
            for (int j = 0; j < 101; j++) {
                if(cur[j]==0)continue;
                if(pre==-1){
                    pre = j;continue;
                }
                min = Math.min(min,j-pre);
                pre = j;
            }
            res[i] = min==Integer.MAX_VALUE?-1:min;
        }
        return res;
    }
}