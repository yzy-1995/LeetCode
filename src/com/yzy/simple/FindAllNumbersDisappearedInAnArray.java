package com.yzy.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: FindAllNumbersDisappearedInAnArray
 * Description:
 * 给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。
 * 请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。
 * @author Administrator
 * @date 2023-3-28 13:54
 */
public class FindAllNumbersDisappearedInAnArray {
    public static void main(String[] args) {
        int [] numbers = new int []{4,3,2,7,8,2,3,1};
        FindAllNumbersDisappearedInAnArray findAllNumbersDisappearedInAnArray = new FindAllNumbersDisappearedInAnArray();
        System.out.println(findAllNumbersDisappearedInAnArray.findDisappearedNumbers(numbers));
    }

    /**
     * 首先创建一个空的 List<Integer> ans，表示最终结果。
     * 对于数组 nums 中的每个元素 num，将其对应的索引 Math.abs(num) - 1 处的元素取相反数，
     * 表示该索引对应的数字已经出现过。这里使用 Math.abs() 是因为 num 可能为负数，而索引必须为正数。
     * 再次遍历数组 nums，对于每个索引 i，如果 nums[i] 为正数，说明 i+1 没有出现过，将 i+1 加入到 ans 中。
     * 最终返回 ans 数组作为答案。
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }
        return result;
    }
}
