package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2024/02/08 15:05
 * @Description
 * 夏日炎炎，小男孩 Tony 想买一些雪糕消消暑。
 *
 * 商店中新到 n 支雪糕，用长度为 n 的数组 costs 表示雪糕的定价，其中 costs[i] 表示第 i 支雪糕的现金价格。Tony 一共有 coins 现金可以用于消费，他想要买尽可能多的雪糕。
 *
 * 注意：Tony 可以按任意顺序购买雪糕。
 *
 * 给你价格数组 costs 和现金量 coins ，请你计算并返回 Tony 用 coins 现金能够买到的雪糕的 最大数量 。
 *
 * 你必须使用计数排序解决此问题。
 *
 *
 *
 * 示例 1：
 *
 * 输入：costs = [1,3,2,4,1], coins = 7
 * 输出：4
 * 解释：Tony 可以买下标为 0、1、2、4 的雪糕，总价为 1 + 3 + 2 + 1 = 7
 * 示例 2：
 *
 * 输入：costs = [10,6,8,7,7,8], coins = 5
 * 输出：0
 * 解释：Tony 没有足够的钱买任何一支雪糕。
 * 示例 3：
 *
 * 输入：costs = [1,6,3,1,2,5], coins = 20
 * 输出：6
 * 解释：Tony 可以买下所有的雪糕，总价为 1 + 6 + 3 + 1 + 2 + 5 = 18 。
 * @Version 1.0
 */
public class maximumicecreambars {
    public int maxIceCream(int[] costs, int coins) {
        int[] res = mergeSort(costs, 0, costs.length - 1);
        int count = 0;
        for (int x : res) {
            if (coins >= x) {
                coins -= x;
            } else {
                break;
            }
            count++;
        }
        return count;
    }
    private int[] mergeSort(int[] num, int l, int r) {
        if (l == r) {
            return new int[]{num[l]};
        }
        int mid = l + (r - l) / 2;
        int[] left = mergeSort(num, l, mid);
        int[] right = mergeSort(num, mid + 1, r);
        int[] arr = new int[left.length + right.length];
        int index = 0;
        int i = 0;
        int j = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[index ++] = left[i ++];
            } else {
                arr[index ++] = right[j ++];
            }
        }
        while (i < left.length) {
            arr[index ++] = left[i ++];
        }
        while (j < right.length) {
            arr[index ++] = right[j ++];
        }
        return arr;
    }
}