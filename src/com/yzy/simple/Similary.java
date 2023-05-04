package com.yzy.simple;

/**
 * ClassName: Similary
 * Description:
 * 判断字符串的相似度
 * @author Administrator
 * @date 2023-4-28 14:35
 */
public class Similary {
    public static void main(String[] args) {
        System.out.println(getSimilarityRatio("1111", "1月19日项目1"));
    }

    public static float getSimilarityRatio(String str, String target) {
        int n = str.length();
        int m = target.length();
        if (n == 0 || m == 0) {
            return 0F;
        }

        int[][] d = new int[n + 1][m + 1];

        // 初始化第一列和第一行
        for (int i = 0; i <= n; i++) d[i][0] = i;
        for (int j = 0; j <= m; j++) d[0][j] = j;

        for (int i = 1; i <= n; i++) {
            char ch1 = Character.toLowerCase(str.charAt(i - 1));
            for (int j = 1; j <= m; j++) {
                char ch2 = Character.toLowerCase(target.charAt(j - 1));
                int temp = (ch1 == ch2) ? 0 : 1;
                d[i][j] = Math.min(Math.min(d[i - 1][j] + 1, d[i][j - 1] + 1), d[i - 1][j - 1] + temp);
            }
        }

        return (1 - (float) d[n][m] / Math.max(str.length(), target.length()));
    }

}
