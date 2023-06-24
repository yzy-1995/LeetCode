package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/06/24 22:32
 * @Description
 * @Version 1.0
 */
public class MaximizeGridHappiness {
    // 网格行列数
    int rows, cols;

    // 辅助计算考虑当前行时，当前行和上一行的内外向人分布情况 currRow[i]值为0、1、2时分别代表当前i位置没人、内向人、外向人
    int[] preRow, currRow;

    public int getMaxGridHappiness(int m, int n, int introvertsCount, int extrovertsCount) {
        this.rows = m;
        this.cols = n;
        this.preRow = new int[n];
        this.currRow = new int[n];
        // 一行数据的所有可能情况数
        int oneRowTotalStatus = (int) Math.pow(3, n);
        int min = Integer.MIN_VALUE >> 1;
        int ans = 0;
        // dp[i][status][p1][p2]表示网格第i-1行，数据状态为status，使用p1个内向人,p2个外向的人时的得分
        int[][][][] dp = new int[m + 1][oneRowTotalStatus][introvertsCount + 1][extrovertsCount + 1];
        // 不可达的状态值置为min
        for (int i = 0; i <= rows; i++) {
            for (int status = 0; status < oneRowTotalStatus; status++) {
                for (int p1 = 0; p1 <= introvertsCount; p1++) {
                    for (int p2 = 0; p2 <= extrovertsCount; p2++) {
                        dp[i][status][p1][p2] = min;
                    }
                }
            }
        }
        dp[0][0][0][0] = 0;
        for (int i = 1; i <= rows; i++) {
            for (int status = 0; status < oneRowTotalStatus; status++) {
                int[] counter = countPeople(status);
                for (int p1 = 0; p1 <= introvertsCount; p1++) {
                    for (int p2 = 0; p2 <= extrovertsCount; p2++) {
                        if (p1 < counter[0] || p2 < counter[1])
                            continue;
                        int preP1 = p1 - counter[0];
                        int preP2 = p2 - counter[1];
                        // 遍历上一层数据所有可能的状态，得到本层的得分最大值
                        for (int preStatus = 0; preStatus < oneRowTotalStatus; preStatus++) {
                            if (dp[i - 1][preStatus][preP1][preP2] == min)
                                continue;
                            int addition = addScore(preStatus, status);
                            dp[i][status][p1][p2] = Math.max(dp[i][status][p1][p2], addition + dp[i - 1][preStatus][preP1][preP2]);
                        }
                        if (i == rows) {
                            ans = Math.max(ans, dp[i][status][p1][p2]);
                        }
                    }
                }
            }
        }
        return ans;
    }

    public int[] countPeople(int status) {
        int introverts = 0;
        int extroverts = 0;
        for (int i = 0; i < cols; i++) {
            int mod = status % 3;
            if (mod == 1)
                introverts++;
            else if (mod == 2) {
                extroverts++;
            }
            status /= 3;
        }
        return new int[]{introverts, extroverts};
    }

    public int addScore(int preStatus, int currStatus) {
        for (int i = 0; i < cols; i++) {
            preRow[i] = preStatus % 3;
            preStatus /= 3;
            currRow[i] = currStatus % 3;
            currStatus /= 3;
        }
        int scores = 0;
        for (int i = 0; i < currRow.length; i++) {
            if (currRow[i] == 1) {
                scores += 120;
                if (preRow[i] == 1)
                    scores -= 60;
                else if (preRow[i] == 2)
                    scores -= (30 - 20);
                if (i > 0 && currRow[i - 1] == 1)
                    scores -= 60;
                else if (i > 0 && currRow[i - 1] == 2)
                    scores -= (30 - 20);
            } else if (currRow[i] == 2) {
                scores += 40;
                if (preRow[i] == 1)
                    scores -= (30 - 20);
                else if (preRow[i] == 2)
                    scores += 40;
                if (i > 0 && currRow[i - 1] == 1)
                    scores -= (30 - 20);
                else if (i > 0 && currRow[i - 1] == 2)
                    scores += 40;
            }
        }
        return scores;
    }
}