package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/10/27 02:48
 * @Description
 * 在两条独立的水平线上按给定的顺序写下 nums1 和 nums2 中的整数。
 *
 * 现在，可以绘制一些连接两个数字 nums1[i] 和 nums2[j] 的直线，这些直线需要同时满足满足：
 *
 *  nums1[i] == nums2[j]
 * 且绘制的直线不与任何其他连线（非水平线）相交。
 * 请注意，连线即使在端点也不能相交：每个数字只能属于一条连线。
 *
 * 以这种方法绘制线条，并返回可以绘制的最大连线数。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：nums1 = [1,4,2], nums2 = [1,2,4]
 * 输出：2
 * 解释：可以画出两条不交叉的线，如上图所示。
 * 但无法画出第三条不相交的直线，因为从 nums1[1]=4 到 nums2[2]=4 的直线将与从 nums1[2]=2 到 nums2[1]=2 的直线相交。
 * 示例 2：
 *
 * 输入：nums1 = [2,5,1,2,5], nums2 = [10,5,2,1,5,2]
 * 输出：3
 * 示例 3：
 *
 * 输入：nums1 = [1,3,7,1,7,5], nums2 = [1,9,2,5,1]
 * 输出：2
 * @Version 1.0
 */
public class uncrossedlines {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        // 尝试记忆化深搜
        return dfs(0, 0, nums1, nums2, new Integer[nums1.length][nums2.length]);
    }

    private int dfs(int index1, int index2, int[] nums1, int[] nums2, Integer[][] memory) {
        if (index1 == nums1.length || index2 == nums2.length) {
            return 0;
        }
        if (memory[index1][index2] != null) {
            return memory[index1][index2];
        }
        int returnResult = 0;
        for (int i = index2; i < nums2.length; i++) {
            if (nums1[index1] == nums2[i]) {
                // 选
                returnResult = Math.max(returnResult, dfs(index1 + 1, i + 1, nums1, nums2, memory) + 1);
            }
        }
        // 不选
        returnResult = Math.max(returnResult, dfs(index1 + 1, index2, nums1, nums2, memory));
        memory[index1][index2] = returnResult;
        return returnResult;
    }
}