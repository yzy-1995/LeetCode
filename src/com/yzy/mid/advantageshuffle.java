package com.yzy.mid;

import java.util.Arrays;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/09/29 00:02
 * @Description
 * @Version 1.0
 */
public class advantageshuffle {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[][] index = new int[n][2];
        for(int i = 0; i < n; i++) {
            index[i][0] = nums2[i];
            index[i][1] = i;
        }
        Arrays.sort(nums1);
        Arrays.sort(index, (a, b) -> b[0] - a[0]);
        int left = 0, right = n - 1;
        for(int i = 0; i < n; i++) {
            if(nums1[right] > index[i][0]) {
                nums2[index[i][1]] = nums1[right];
                right--;
            } else {
                nums2[index[i][1]] = nums1[left];
                left++;
            }
        }
        return nums2;
    }
}