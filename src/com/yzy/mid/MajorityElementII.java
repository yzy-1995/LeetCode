package com.yzy.mid;

import java.util.*;

/**
 * ClassName: MajorityElementII
 * Description:
 * 给定一个大小为 n 的整数数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,2,3]
 * 输出：[3]
 * 示例 2：
 * <p>
 * 输入：nums = [1]
 * 输出：[1]
 * 示例 3：
 * <p>
 * 输入：nums = [1,2]
 * 输出：[1,2]
 *
 * @author Administrator
 * @date 2023-6-14 10:15
 */
public class MajorityElementII {

    public List<Integer> majorityElement(int[] nums) {
        int a = nums.length / 3;
        if (a == 0) {
            if (nums.length == 2 && nums[0] != nums[1]) {
                List<Integer> list = new ArrayList<>();
                list.add(nums[0]);
                list.add(nums[1]);
                return list;
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(nums[0]);
                return list;
            }
        } else {

            List<Integer> list = new ArrayList<>();
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < nums.length; i++) {
                set.add(nums[i]);
            }
            Iterator iterator = set.iterator();
            while (iterator.hasNext()) {
                int b = 0;
                Integer next = (Integer) iterator.next();
                for (int i = 0; i < nums.length; i++) {
                    if (nums[i] == next) {
                        b++;
                    }
                }
                if (b > a) {
                    list.add(next);
                }

            }
            return list;
        }
    }
}
