package com.yzy.mid;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/10/30 00:56
 * @Description
 * 在一棵无限的二叉树上，每个节点都有两个子节点，树中的节点 逐行 依次按 “之” 字形进行标记。
 *
 * 如下图所示，在奇数行（即，第一行、第三行、第五行……）中，按从左到右的顺序进行标记；
 *
 * 而偶数行（即，第二行、第四行、第六行……）中，按从右到左的顺序进行标记。
 *
 *
 *
 * 给你树上某一个节点的标号 label，请你返回从根节点到该标号为 label 节点的路径，该路径是由途经的节点标号所组成的。
 *
 *
 *
 * 示例 1：
 *
 * 输入：label = 14
 * 输出：[1,3,4,14]
 * 示例 2：
 *
 * 输入：label = 26
 * 输出：[1,2,6,10,26]
 * @Version 1.0
 */
public class pathinzigzaglabelledbinarytree {
    public List<Integer> pathInZigZagTree(int label) {
        //假设label在第n层(1开始)，有2^n-1 <= label <= 2^n
        //奇数行时：2^n-1离label近，在左侧；2^n-1-(n-1)离label近，在左半区的右侧
        //偶数行时：2^n-1离label近，在右侧；2^n-1+(n-1)离label近，在右半区的左侧
        int h = 1;
        for (int i = 1; i <= 20; i++) {
            if ((1 << (i - 1)) <= label && (1 << i) > label) {
                h = i;
                break;
            }
        }
        List<Integer> res = new ArrayList<>();
        if (h % 2 != 0) {
            //奇数行
            res.add(1);
            int last = 1;
            int n = 2;
            int min = 1 << (h - 1);
            int max = (1 << h) - 1;
            int length = 1 << (h - 1);
            while (n <= h) {
                if ((max - label) < (label - min)) {
                    int right = getRight(last, n - 1);
                    last = right;
                    res.add(right);
                    min = min + (length / 2);
                    length = length / 2;
                } else {
                    int left = getLeft(last, n - 1);
                    last = left;
                    res.add(left);
                    max = max - (length / 2);
                    length = length / 2;
                }
                n++;
            }
        } else {
            //偶数行
            res.add(1);
            int last = 1;
            int n = 2;
            int min = 1 << (h - 1);
            int max = (1 << h) - 1;
            int length = 1 << (h - 1);
            while (n <= h) {
                if ((max - label) < (label - min)) {
                    int left = getLeft(last, n - 1);
                    last = left;
                    res.add(left);
                    min = min + (length / 2);
                    length = length / 2;
                } else {
                    int right = getRight(last, n - 1);
                    last = right;
                    res.add(right);
                    max = max - (length / 2);
                    length = length / 2;
                }
                n++;
            }

        }
        return res;
    }

    public int getLeft(int n, int h){
        int min = 1 << (h - 1);
        int max = (1 << h) - 1;
        if (h % 2 == 0) {
            return (1 << h) + (max - n) * 2;
        } else {
            return (1 << h) + (max - n) * 2 + 1;
        }
    }

    public int getRight(int n, int h) {
        int min = 1 << (h - 1);
        int max = (1 << h) - 1;
        if (h % 2 == 0) {
            return (1 << (h + 1)) - 1 - (n - min) * 2;
        } else {
            return (1 << h) + (max - n) * 2;
        }
    }
}