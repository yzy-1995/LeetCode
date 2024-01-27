package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2024/01/25 00:41
 * @Description
 * 给你一个整数数组 perm ，它是前 n 个正整数的排列，且 n 是个 奇数 。
 *
 * 它被加密成另一个长度为 n - 1 的整数数组 encoded ，满足 encoded[i] = perm[i] XOR perm[i + 1] 。比方说，如果 perm = [1,3,2] ，那么 encoded = [2,1] 。
 *
 * 给你 encoded 数组，请你返回原始数组 perm 。题目保证答案存在且唯一。
 *
 *
 *
 * 示例 1：
 *
 * 输入：encoded = [3,1]
 * 输出：[1,2,3]
 * 解释：如果 perm = [1,2,3] ，那么 encoded = [1 XOR 2,2 XOR 3] = [3,1]
 * 示例 2：
 *
 * 输入：encoded = [6,5,4,6]
 * 输出：[2,4,1,5,3]
 * @Version 1.0
 */
public class decodexoredpermutation {
    public int[] decode(int[] encoded) {
        int len = encoded.length;
        int total = 1;
        //perm[0] ^ (perm[1] ^ perm[2]...perm[n]) = total
        for(int i = 2; i <= len + 1; i++){
            total = total ^ i;
        }
        int part = encoded[1];
        for(int j = 1; j < len/2; j++){
            part = part ^ encoded[j * 2 + 1];
        }
        int[] perm = new int[len + 1];
        perm[0] = part ^ total;
        for(int k = 0; k < len; k++){
            perm[k + 1] = encoded[k] ^ perm[k];
        }
        return perm;
    }
}