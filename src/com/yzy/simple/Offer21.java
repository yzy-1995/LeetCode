package com.yzy.simple;

/**
 * ClassName: Offer21
 * Description:
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。
 * 示例：
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 *
 * @author Administrator
 * @date 2023-5-15 10:49
 */
public class Offer21 {
    public static void main(String[] args) {

        for (int o : exchange(new int[]{1, 2, 3, 4})) {
            System.out.println(o);
        }
        ;
    }

    public static int[] exchange(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            while (left < right && nums[left] % 2 == 1) {
                left++;
            }
            while (left < right && nums[right] % 2 == 0) {
                right--;
            }
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            left++;
            right--;
        }
        return nums;
    }
}
