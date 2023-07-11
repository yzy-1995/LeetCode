package com.yzy.simple;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.simple
 * @Date 2023/07/11 22:17
 * @Description
 * 给你一个下标从 0 开始的整数数组 nums 。如果下标对 i、j 满足 0 ≤ i < j < nums.length ，如果 nums[i] 的 第一个数字 和 nums[j] 的 最后一个数字 互质 ，则认为 nums[i] 和 nums[j] 是一组 美丽下标对 。
 *
 * 返回 nums 中 美丽下标对 的总数目。
 *
 * 对于两个整数 x 和 y ，如果不存在大于 1 的整数可以整除它们，则认为 x 和 y 互质 。换而言之，如果 gcd(x, y) == 1 ，则认为 x 和 y 互质，其中 gcd(x, y) 是 x 和 k 最大公因数 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [2,5,1,4]
 * 输出：5
 * 解释：nums 中共有 5 组美丽下标对：
 * i = 0 和 j = 1 ：nums[0] 的第一个数字是 2 ，nums[1] 的最后一个数字是 5 。2 和 5 互质，因此 gcd(2,5) == 1 。
 * i = 0 和 j = 2 ：nums[0] 的第一个数字是 2 ，nums[1] 的最后一个数字是 1 。2 和 5 互质，因此 gcd(2,1) == 1 。
 * i = 1 和 j = 2 ：nums[0] 的第一个数字是 5 ，nums[1] 的最后一个数字是 1 。2 和 5 互质，因此 gcd(5,1) == 1 。
 * i = 1 和 j = 3 ：nums[0] 的第一个数字是 5 ，nums[1] 的最后一个数字是 4 。2 和 5 互质，因此 gcd(5,4) == 1 。
 * i = 2 和 j = 3 ：nums[0] 的第一个数字是 1 ，nums[1] 的最后一个数字是 4 。2 和 5 互质，因此 gcd(1,4) == 1 。
 * 因此，返回 5 。
 * 示例 2：
 *
 * 输入：nums = [11,21,12]
 * 输出：2
 * 解释：共有 2 组美丽下标对：
 * i = 0 和 j = 1 ：nums[0] 的第一个数字是 1 ，nums[1] 的最后一个数字是 1 。gcd(1,1) == 1 。
 * i = 0 和 j = 2 ：nums[0] 的第一个数字是 1 ，nums[1] 的最后一个数字是 2 。gcd(1,2) == 1 。
 * 因此，返回 2 。
 * @Version 1.0
 */
public class NumberOfBeautifulPairs {
    public int countBeautifulPairs(int[] nums) {
        Set<Integer> set1 = Stream.of(2, 4, 6, 8).collect(Collectors.toSet());
        Set<Integer> set2 = Stream.of(3, 6, 9).collect(Collectors.toSet());

        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int left = nums[i];
            while (left >= 10) {
                left /= 10;
            }
            for (int j = i + 1; j < nums.length; j++) {
                int right = nums[j] % 10;
                if (1 == left || 1 == right) {
                    count++;
                } else if (left != right && (!set1.contains(left) || !set1.contains(right)) && (!set2.contains(left) || !set2.contains(right))) {
                    count++;
                }
            }
        }
        return count;
    }
}