package com.yzy.mid;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/10/16 00:06
 * @Description
 * 返回所有长度为 n 且满足其每两个连续位上的数字之间的差的绝对值为 k 的 非负整数 。
 *
 * 请注意，除了 数字 0 本身之外，答案中的每个数字都 不能 有前导零。例如，01 有一个前导零，所以是无效的；但 0 是有效的。
 *
 * 你可以按 任何顺序 返回答案。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 3, k = 7
 * 输出：[181,292,707,818,929]
 * 解释：注意，070 不是一个有效的数字，因为它有前导零。
 * 示例 2：
 *
 * 输入：n = 2, k = 1
 * 输出：[10,12,21,23,32,34,43,45,54,56,65,67,76,78,87,89,98]
 * 示例 3：
 *
 * 输入：n = 2, k = 0
 * 输出：[11,22,33,44,55,66,77,88,99]
 * 示例 4：
 *
 * 输入：n = 2, k = 2
 * 输出：[13,20,24,31,35,42,46,53,57,64,68,75,79,86,97]
 * @Version 1.0
 */
public class numberswithsameconsecutivedifferences {
    List<Integer> list =new ArrayList<>();
    public int[] numsSameConsecDiff(int n, int k) {
        /*
            执行结果：通过显示详情查看示例代码添加备注
            执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
            内存消耗：40.1 MB, 在所有 Java 提交中击败了99.44%的用户
            通过测试用例：
            81 / 81
            炫耀一下:
         */

        for(int i=1;i<=9;i++){
            dfs(n,k,i);//去掉开头为0的情况
        }
        int[] ans=new int[list.size()];
        for(int i=0;i<ans.length;i++){
            ans[i]=list.get(i);
        }
        return ans;
    }
    public void dfs(int n,int k,int sum){
        if(n==1){
            list.add(sum);
            return ;
        }
        //取出末尾的数
        int cur=sum%10;
        int a=cur+k;
        int b=cur-k;
        if(a<10){
            dfs(n-1,k,sum*10+a);
        }
        if(b>=0&&a!=b){
            dfs(n-1,k,sum*10+b);
        }
    }
}