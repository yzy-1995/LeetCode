package com.yzy.mid;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/11/17 00:01
 * @Description
 * 给你一个区间列表，请你删除列表中被其他区间所覆盖的区间。
 *
 * 只有当 c <= a 且 b <= d 时，我们才认为区间 [a,b) 被区间 [c,d) 覆盖。
 *
 * 在完成所有删除操作后，请你返回列表中剩余区间的数目。
 *
 *
 *
 * 示例：
 *
 * 输入：intervals = [[1,4],[3,6],[2,8]]
 * 输出：2
 * 解释：区间 [3,6] 被区间 [2,8] 覆盖，所以它被删除了。
 * @Version 1.0
 */
public class removecoveredintervals {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals,new Comparator<int[]>(){
            public int compare(int[]a ,int[] b){
                // L 相同则按照R 倒着排
                if(a[0]==b[0]){
                    return b[1]-a[1];
                }
                return a[0]-b[0];
            }
        });
        // 不需要选最大，用for
        int n=intervals.length;
        int count=0; // 要被删除的
        // 基准
        int x_R=intervals[0][1];
        for(int i=1;i<n;i++){
            int c_R=intervals[i][1];
            if(c_R <= x_R){ // 覆盖
                count++;
                continue;
            }else{ //重叠 or 分隔-----更新 x_R
                x_R=intervals[i][1];
            }
        }
        return n-count;
    }
}