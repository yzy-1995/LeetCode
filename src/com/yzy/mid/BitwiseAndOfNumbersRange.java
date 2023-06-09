package com.yzy.mid;

/**
 * ClassName: BitwiseAndOfNumbersRange
 * Description:
 * 给你两个整数 left 和 right ，表示区间 [left, right] ，返回此区间内所有数字 按位与 的结果（包含 left 、right 端点）。
 * <p>
 * 示例 1：
 * <p>
 * 输入：left = 5, right = 7
 * 输出：4
 * 示例 2：
 * <p>
 * 输入：left = 0, right = 0
 * 输出：0
 * 示例 3：
 * <p>
 * 输入：left = 1, right = 2147483647
 * 输出：0
 *
 * @author Administrator
 * @date 2023-6-9 15:22
 */
public class BitwiseAndOfNumbersRange {
    public int rangeBitwiseAnd(int left, int right) {
        int res = 0;
        for (int i = 31; i >= 0; i--) {
            if ((left >> i) == (right >> i) && ((left >> i) & 1) == 1) res |= (1 << i);
            else if ((left >> i) != (right >> i)) break;
        }
        return res;
    }
}
