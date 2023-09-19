package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/09/18 00:19
 * @Description
 * 在社交媒体网站上有 n 个用户。给你一个整数数组 ages ，其中 ages[i] 是第 i 个用户的年龄。
 *
 * 如果下述任意一个条件为真，那么用户 x 将不会向用户 y（x != y）发送好友请求：
 *
 * ages[y] <= 0.5 * ages[x] + 7
 * ages[y] > ages[x]
 * ages[y] > 100 && ages[x] < 100
 * 否则，x 将会向 y 发送一条好友请求。
 *
 * 注意，如果 x 向 y 发送一条好友请求，y 不必也向 x 发送一条好友请求。另外，用户不会向自己发送好友请求。
 *
 * 返回在该社交媒体网站上产生的好友请求总数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：ages = [16,16]
 * 输出：2
 * 解释：2 人互发好友请求。
 * 示例 2：
 *
 * 输入：ages = [16,17,18]
 * 输出：2
 * 解释：产生的好友请求为 17 -> 16 ，18 -> 17 。
 * 示例 3：
 *
 * 输入：ages = [20,30,100,110,120]
 * 输出：3
 * 解释：产生的好友请求为 110 -> 100 ，120 -> 110 ，120 -> 100 。
 * @Version 1.0
 */
public class friendsofappropriateages {
    public int numFriendRequests(int[] ages) {
        int[] arr = new int[121];

        int count = 0;
        //记录每个年龄的人数
        for (int age : ages){
            arr[age] ++;
        }

        for (int i = 120;i >= 15;i --){
            if (arr[i] > 0){
                int temp = i / 2 + 8;
                for (int j = temp;j < i;j ++){
                    count += arr[j] * arr[i];//计算 除年龄i本身，需要发送的次数
                }
                count += (arr[i] - 1) * arr[i];//计算同年龄之间需要发送的次数
            }
        }

        return count;
    }
}