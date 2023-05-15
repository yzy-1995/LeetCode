package com.yzy.simple;

import java.util.Arrays;

/**
 * ClassName: Offer11
 * Description:
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 给你一个可能存在 重复 元素值的数组 numbers ，它原来是一个升序排列的数组，
 * 并按上述情形进行了一次旋转。请返回旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一次旋转，该数组的最小值为 1。
 * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
 * 示例 1：
 * 输入：numbers = [3,4,5,1,2]
 * 输出：1
 * 示例 2：
 * 输入：numbers = [2,2,2,0,1]
 * 输出：0
 * @author Administrator
 * @date 2023-5-15 10:00
 */
public class Offer11 {
    public int minArray(int[] numbers) {
        Arrays.sort(numbers);
        return numbers[0];
    }
}
