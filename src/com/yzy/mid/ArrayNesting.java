package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/08/10 00:11
 * @Description
 * 索引从0开始长度为N的数组A，包含0到N - 1的所有整数。找到最大的集合S并返回其大小，其中 S[i] = {A[i], A[A[i]], A[A[A[i]]], ... }且遵守以下的规则。
 *
 * 假设选择索引为i的元素A[i]为S的第一个元素，S的下一个元素应该是A[A[i]]，之后是A[A[A[i]]]... 以此类推，不断添加直到S出现重复的元素。
 *
 *
 *
 * 示例 1:
 *
 * 输入: A = [5,4,0,3,1,6,2]
 * 输出: 4
 * 解释:
 * A[0] = 5, A[1] = 4, A[2] = 0, A[3] = 3, A[4] = 1, A[5] = 6, A[6] = 2.
 *
 * 其中一种最长的 S[K]:
 * S[0] = {A[0], A[5], A[6], A[2]} = {5, 6, 2, 0}
 * @Version 1.0
 */
public class ArrayNesting {
    public int arrayNesting(int[] nums) {
        int max = 1;
        boolean[] visited = new boolean[nums.length];
        for(int i = 0; i < nums.length; i++){
            if(max > nums.length/2)
                return max;
            if(visited[nums[i]])
                continue;
            visited[nums[i]] = true;
            int curMax = 1;
            int cur = nums[nums[i]];
            while(nums[i] != cur){
                visited[cur] = true;
                curMax++;
                cur = nums[cur];
            }
            max = curMax > max? curMax : max;
        }
        return max;
    }
}