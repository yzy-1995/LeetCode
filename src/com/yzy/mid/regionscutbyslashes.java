package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/10/15 00:19
 * @Description
 * 在由 1 x 1 方格组成的 n x n 网格 grid 中，每个 1 x 1 方块由 '/'、'\' 或空格构成。这些字符会将方块划分为一些共边的区域。
 *
 * 给定网格 grid 表示为一个字符串数组，返回 区域的数量 。
 *
 * 请注意，反斜杠字符是转义的，因此 '\' 用 '\\' 表示。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：grid = [" /","/ "]
 * 输出：2
 * 示例 2：
 *
 *
 *
 * 输入：grid = [" /","  "]
 * 输出：1
 * 示例 3：
 *
 *
 *
 * 输入：grid = ["/\\","\\/"]
 * 输出：5
 * 解释：回想一下，因为 \ 字符是转义的，所以 "/\\" 表示 /\，而 "\\/" 表示 \/。
 * @Version 1.0
 */
public class regionscutbyslashes {
    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        Solution1 test = new Solution1();
        test.parent = new int[n * n * 4];
        test.n = n * n * 4;
        int m = test.parent.length;
        for (int i = 0;i < m;i++){
            test.parent[i] = i;
        }
        for (int i = 0,z = 0;i < n;i++){
            for (int j = 0;j < grid[i].length();j++,z += 4){
                if (grid[i].charAt(j) == ' '){
                    if (test.find(z + 1) != test.find(z)){
                        test.n--;
                    }
                    if (test.find(z + 1) != test.find(z + 2)){
                        test.n--;
                    }
                    if (test.find(z + 2) != test.find(z + 3)){
                        test.n--;
                    }
                    test.union(z + 1,z);
                    test.union(z + 2,z + 1);
                    test.union(z + 3,z + 2);
                } else if (grid[i].charAt(j) == '/'){
                    if (test.find(z + 1) != test.find(z)){
                        test.n--;
                    }
                    if (test.find(z + 3) != test.find(z + 2)){
                        test.n--;
                    }
                    test.union(z + 1,z);
                    test.union(z + 3,z + 2);
                } else {
                    if (test.find(z + 2) != test.find(z)){
                        test.n--;
                    }
                    if (test.find(z + 3) != test.find(z + 1)){
                        test.n--;
                    }
                    test.union(z + 2,z);
                    test.union(z + 3,z + 1);
                }
                if(j < n - 1 && test.find(z + 2) != test.find(z + 4 + 1)){
                    test.union(z + 4 + 1,z + 2);
                    test.n--;
                }
                if(i < n - 1 && test.find(z + 3) != test.find(z + n * 4)){
                    test.union(z + n * 4,z + 3);
                    test.n--;
                }
            }
        }
        return test.n;
    }
}
class Solution1{
    int[] parent;
    int n; // 总的连通分量的个数

    // 查询祖先结点,这里进行了状态压缩，防止树的深度太长
    int find(int p){
        if (parent[p] == p){
            return p;
        }
        return parent[p] = find(parent[p]);
    }

    // 连接两个结点
    void union(int p,int q){
        parent[find(p)] = find(q);
    }
}
