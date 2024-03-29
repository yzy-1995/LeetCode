package com.yzy.mid;

import java.util.Arrays;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2024/01/25 00:41
 * @Description
 * 在一个由 m 个用户组成的社交网络里，我们获取到一些用户之间的好友关系。两个用户之间可以相互沟通的条件是他们都掌握同一门语言。
 *
 * 给你一个整数 n ，数组 languages 和数组 friendships ，它们的含义如下：
 *
 * 总共有 n 种语言，编号从 1 到 n 。
 * languages[i] 是第 i 位用户掌握的语言集合。
 * friendships[i] = [u​​​​​​i​​​, v​​​​​​i] 表示 u​​​​​​​​​​​i​​​​​ 和 vi 为好友关系。
 * 你可以选择 一门 语言并教会一些用户，使得所有好友之间都可以相互沟通。请返回你 最少 需要教会多少名用户。
 *
 * 请注意，好友关系没有传递性，也就是说如果 x 和 y 是好友，且 y 和 z 是好友， x 和 z 不一定是好友。
 *
 *
 * 示例 1：
 *
 * 输入：n = 2, languages = [[1],[2],[1,2]], friendships = [[1,2],[1,3],[2,3]]
 * 输出：1
 * 解释：你可以选择教用户 1 第二门语言，也可以选择教用户 2 第一门语言。
 * 示例 2：
 *
 * 输入：n = 3, languages = [[2],[1,3],[1,2],[3]], friendships = [[1,4],[1,2],[3,4],[2,3]]
 * 输出：2
 * 解释：教用户 1 和用户 3 第三门语言，需要教 2 名用户。
 * @Version 1.0
 */
public class minimumnumberofpeopletoteach {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
       /*
       思路：首先找到所有产生了冲突的用户，这些用户即是需要处理的，假设其数量为a
       我们首先假设最坏情况，为每一位冲突用户都教会一门新语言，这样得到了需要教的最大值为a
       随后可以考虑到，如果用户中有些人以及掌握了要教的语言，那么a就可以缩小，我们假设这些人的数目为x
       那么结果即是a-x
       自然，x越大越好，由此可以想到，只需要找到一门语言，a个冲突用户中会的人最多即可。
       由此可以想到记录每一个冲突用户会的语言，取最大值xmax
       结果即是a-xmax
       */

        //用户人数
        int m = languages.length;
        //用于记录有冲突的好友们各语言的计数 以及 有冲突的用户有哪些
        int count[] = new int[n+1];
        boolean flag[] = new boolean[m];
        //将langugages转化为二位布尔数组方便查询各用户语言掌握情况
        boolean[][] l = new boolean[m][n+1];
        for (int i = 0; i < m; i++){
            for (int j : languages[i]){
                l[i][j] = true;
            }
        }
        //比对各个好友冲突情况
        f1:for (int[] f : friendships){
            int a = f[0] - 1, b = f[1] - 1;
            for (int i = 0; i <= n; i++){
                //两人有共同语言，不考虑
                if (l[a][i] && l[b][i]) continue f1;
            }
            //标记为有冲突
            flag[a] = true;
            flag[b] = true;
        }
        //遍历并计数各语言掌握数量,c用于计数一共有多少冲突用户
        int c = 0;
        for (int i = 0; i < m; i++){
            if (!flag[i]) continue;
            c++;
            for (int j = 0; j <= n; j++){
                if (l[i][j]) count[j]++;
            }
        }
        Arrays.sort(count);
        //找到冲突用户中掌握数量最多的语言，教会没有掌握这门语言的其他冲突用户即可
        return c - count[n];
    }
}