package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/12/10 14:30
 * @Description
 * n 名士兵站成一排。每个士兵都有一个 独一无二 的评分 rating 。
 *
 * 每 3 个士兵可以组成一个作战单位，分组规则如下：
 *
 * 从队伍中选出下标分别为 i、j、k 的 3 名士兵，他们的评分分别为 rating[i]、rating[j]、rating[k]
 * 作战单位需满足： rating[i] < rating[j] < rating[k] 或者 rating[i] > rating[j] > rating[k] ，其中  0 <= i < j < k < n
 * 请你返回按上述条件可以组建的作战单位数量。每个士兵都可以是多个作战单位的一部分。
 *
 *
 *
 * 示例 1：
 *
 * 输入：rating = [2,5,3,4,1]
 * 输出：3
 * 解释：我们可以组建三个作战单位 (2,3,4)、(5,4,1)、(5,3,1) 。
 * 示例 2：
 *
 * 输入：rating = [2,1,3]
 * 输出：0
 * 解释：根据题目条件，我们无法组建作战单位。
 * 示例 3：
 *
 * 输入：rating = [1,2,3,4]
 * 输出：4
 * @Version 1.0
 */
public class countnumberofteams {
    public int numTeams(int[] rating) {
        int len = rating.length;
        int[] up = new int[len];
        int[] down = new int[len];

        int c = 0;
        for(int i = 0; i < len; i++){
            for(int j = i - 1; j >= 0; j--){
                //比它大，找降序
                if(rating[j] > rating[i]){
                    c += down[j];
                    down[i]++;
                }else if(rating[j] < rating[i]){
                    c += up[j];
                    up[i]++;
                }
            }
        }
        return c;
    }
}