package com.yzy.mid;

/**
 * ClassName: ContainerWithMostWater
 * Description:
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 返回容器可以储存的最大水量。
 * 说明：你不能倾斜容器。
 * @author Administrator
 * @date 2023-3-28 14:38
 */
public class ContainerWithMostWater {
    public static void main(String[] args) {

    }

    /**
     * 这是一道经典的双指针问题。我们可以使用两个指针 left 和 right 分别指向数组的左右两端。
     * 在每一步操作中，我们计算当前双指针对应的容器的面积，并将指向较小高度的指针向另一个指针方向移动一个位置。
     *
     * 为什么要移动较小高度的指针呢？因为容器的面积是由两个指针的距离和两个指针对应的高度中的较小值决定的。
     * 如果我们移动较大高度的指针，那么两个指针之间的距离会减小，而移动较小高度的指针，可能会找到更高的高度，从而使得容器的面积增大。
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(maxArea, area);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}
