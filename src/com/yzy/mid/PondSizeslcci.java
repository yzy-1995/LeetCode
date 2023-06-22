package com.yzy.mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/06/22 21:18
 * @Description 你有一个用于表示一片土地的整数矩阵land，该矩阵中每个点的值代表对应地点的海拔高度。若值为0则表示水域。由垂直、水平或对角连接的水域为池塘。池塘的大小是指相连接的水域的个数。编写一个方法来计算矩阵中所有池塘的大小，返回值需要从小到大排序。
 * <p>
 * 示例：
 * <p>
 * 输入：
 * [
 * [0,2,1,0],
 * [0,1,0,1],
 * [1,1,0,1],
 * [0,1,0,1]
 * ]
 * 输出： [1,2,4]
 * @Version 1.0
 */
public class PondSizeslcci {
    List<Integer> list = new ArrayList<>();
    int count = 0;

    public int[] pondSizes(int[][] land) {
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[i].length; j++) {
                if (land[i][j] == 0) {
                    dfs(land, i, j);
                    if (count != 0) {
                        list.add(count);
                        count = 0;
                    }
                }
            }
        }
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        Arrays.sort(arr);
        return arr;
    }

    public void dfs(int[][] land, int x, int y) {
        if (x < 0 || y < 0 || x >= land.length || y >= land[0].length) return;
        if (land[x][y] == 0) {
            land[x][y] = 1;
            count++;
            dfs(land, x + 1, y);
            dfs(land, x, y + 1);
            dfs(land, x + 1, y + 1);
            dfs(land, x - 1, y);
            dfs(land, x, y - 1);
            dfs(land, x - 1, y + 1);
            dfs(land, x + 1, y - 1);
            dfs(land, x - 1, y - 1);
        }
    }

}