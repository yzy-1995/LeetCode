package com.yzy.simple;

/**
 * ClassName: FirstBadVersion
 * Description:
 * 你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。
 * 由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。
 *
 * 假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。
 *
 * 你可以通过调用 bool isBadVersion(version) 接口来判断版本号 version 是否在单元测试中出错。
 * 实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。
 *
 * 示例 1：
 *
 * 输入：n = 5, bad = 4
 * 输出：4
 * 解释：
 * 调用 isBadVersion(3) -> false
 * 调用 isBadVersion(5) -> true
 * 调用 isBadVersion(4) -> true
 * 所以，4 是第一个错误的版本。
 * 示例 2：
 *
 * 输入：n = 1, bad = 1
 * 输出：1
 * @author Administrator
 * @date 2023-3-30 9:30
 */
public class FirstBadVersion {
    public static void main(String[] args) {

    }

    /**
     * 这道题目可以使用二分查找算法来解决。具体来说，我们可以将版本号列表分为左右两个部分，
     * 然后判断中间的版本号是否是错误的版本。如果是错误的版本，则说明错误的版本号在左半部分，
     * 否则说明错误的版本号在右半部分。我们可以递归地对左半部分或右半部分进行查找，直到找到第一个错误的版本号为止。
     *
     * 在实现二分查找时，需要注意边界条件的处理。具体来说，当左、右指针相邻时，
     * 我们需要判断两个指针指向的版本是否是错误的版本，如果是，则说明第一个错误的版本号就是这个版本号，
     * 否则说明不存在错误的版本号。
     * @param n
     * @return
     */
//    public int firstBadVersion(int n) {
//        int left = 1;
//        int right = n;
//        while (left < right) {
//            int mid = left + (right - left) / 2;
//            if (isBadVersion(mid)) {
//                right = mid;
//            } else {
//                left = mid + 1;
//            }
//        }
//        return left;
//    }

}
