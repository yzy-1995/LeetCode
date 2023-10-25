package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/10/25 00:10
 * @Description
 * 传送带上的包裹必须在 days 天内从一个港口运送到另一个港口。
 *
 * 传送带上的第 i 个包裹的重量为 weights[i]。每一天，我们都会按给出重量（weights）的顺序往传送带上装载包裹。我们装载的重量不会超过船的最大运载重量。
 *
 * 返回能在 days 天内将传送带上的所有包裹送达的船的最低运载能力。
 *
 *
 *
 * 示例 1：
 *
 * 输入：weights = [1,2,3,4,5,6,7,8,9,10], days = 5
 * 输出：15
 * 解释：
 * 船舶最低载重 15 就能够在 5 天内送达所有包裹，如下所示：
 * 第 1 天：1, 2, 3, 4, 5
 * 第 2 天：6, 7
 * 第 3 天：8
 * 第 4 天：9
 * 第 5 天：10
 *
 * 请注意，货物必须按照给定的顺序装运，因此使用载重能力为 14 的船舶并将包装分成 (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) 是不允许的。
 * 示例 2：
 *
 * 输入：weights = [3,2,2,4,1,4], days = 3
 * 输出：6
 * 解释：
 * 船舶最低载重 6 就能够在 3 天内送达所有包裹，如下所示：
 * 第 1 天：3, 2
 * 第 2 天：2, 4
 * 第 3 天：1, 4
 * 示例 3：
 *
 * 输入：weights = [1,2,3,1,1], days = 4
 * 输出：3
 * 解释：
 * 第 1 天：1
 * 第 2 天：2
 * 第 3 天：3
 * 第 4 天：1, 1
 * @Version 1.0
 */
public class capacitytoshippackageswithinddays {
    private int n;
    private int d;
    private int[] prefix;

    // 二分查找下一天要运送的货物
    private int findNext(int start, int x) {
        int left = start, right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (prefix[mid] > x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    // 检查每天载重w是否可以将所有货物运走
    private boolean check(int w) {
        int cnt = 0, pos = 0;
        while (pos < n) {
            int tmp = findNext(pos, w + prefix[pos]);
            if (tmp == pos) {
                // 没找到 直接返回false
                return false;
            }
            pos = tmp;
            cnt ++;
        }
        return (cnt <= d);


    }
    public int shipWithinDays(int[] weights, int days) {
        n = weights.length;
        d = days;
        prefix = new int[n + 1];

        // 计算前缀和
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + weights[i];
        }

        // 二分答案
        int left = 0, right = prefix[n];
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (check(mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}