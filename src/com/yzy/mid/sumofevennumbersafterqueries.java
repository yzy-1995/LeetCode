package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/10/20 08:19
 * @Description
 * 给出一个整数数组 A 和一个查询数组 queries。
 *
 * 对于第 i 次查询，有 val = queries[i][0], index = queries[i][1]，我们会把 val 加到 A[index] 上。然后，第 i 次查询的答案是 A 中偶数值的和。
 *
 * （此处给定的 index = queries[i][1] 是从 0 开始的索引，每次查询都会永久修改数组 A。）
 *
 * 返回所有查询的答案。你的答案应当以数组 answer 给出，answer[i] 为第 i 次查询的答案。
 *
 *
 *
 * 示例：
 *
 * 输入：A = [1,2,3,4], queries = [[1,0],[-3,1],[-4,0],[2,3]]
 * 输出：[8,6,2,4]
 * 解释：
 * 开始时，数组为 [1,2,3,4]。
 * 将 1 加到 A[0] 上之后，数组为 [2,2,3,4]，偶数值之和为 2 + 2 + 4 = 8。
 * 将 -3 加到 A[1] 上之后，数组为 [2,-1,3,4]，偶数值之和为 2 + 4 = 6。
 * 将 -4 加到 A[0] 上之后，数组为 [-2,-1,3,4]，偶数值之和为 -2 + 4 = 2。
 * 将 2 加到 A[3] 上之后，数组为 [-2,-1,3,6]，偶数值之和为 -2 + 6 = 4。
 * @Version 1.0
 */
public class sumofevennumbersafterqueries {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int n=nums.length;
        var st=new boolean[n];
        int p=0;
        for(int i=0;i<n;i++){
            if(nums[i]%2==0){
                st[i]=true;
                p+=nums[i];
            }
        }
        int m=queries.length;
        var ans=new int[m];
        for(int i=0;i<m;i++){
            int val=queries[i][0],idx=queries[i][1];
            if(st[idx]&&val%2==0){
                nums[idx]+=val;
                p+=val;
                ans[i]=p;
            }else if(!st[idx]&&val%2!=0){
                nums[idx]+=val;
                st[idx]=true;
                p+=nums[idx];
                ans[i]=p;
            }else{
                if(st[idx])p-=nums[idx];
                ans[i]=p;
                nums[idx]+=val;
                st[idx]=false;
            }
        }
        return ans;
    }
}