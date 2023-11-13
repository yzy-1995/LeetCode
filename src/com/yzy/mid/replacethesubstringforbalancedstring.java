package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/11/13 00:18
 * @Description
 * 有一个只含有 'Q', 'W', 'E', 'R' 四种字符，且长度为 n 的字符串。
 *
 * 假如在该字符串中，这四个字符都恰好出现 n/4 次，那么它就是一个「平衡字符串」。
 *
 *
 *
 * 给你一个这样的字符串 s，请通过「替换一个子串」的方式，使原字符串 s 变成一个「平衡字符串」。
 *
 * 你可以用和「待替换子串」长度相同的 任何 其他字符串来完成替换。
 *
 * 请返回待替换子串的最小可能长度。
 *
 * 如果原字符串自身就是一个平衡字符串，则返回 0。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "QWER"
 * 输出：0
 * 解释：s 已经是平衡的了。
 * 示例 2：
 *
 * 输入：s = "QQWE"
 * 输出：1
 * 解释：我们需要把一个 'Q' 替换成 'R'，这样得到的 "RQWE" (或 "QRWE") 是平衡的。
 * 示例 3：
 *
 * 输入：s = "QQQW"
 * 输出：2
 * 解释：我们可以把前面的 "QQ" 替换成 "ER"。
 * 示例 4：
 *
 * 输入：s = "QQQQ"
 * 输出：3
 * 解释：我们可以替换后 3 个 'Q'，使 s = "QWER"。
 * @Version 1.0
 */
public class replacethesubstringforbalancedstring {
    public int balancedString(String s) {
        int i,l,r,n=s.length(),ans=n;
        char[] str=s.toCharArray();
        int[] cnt=new int[128];//词频表
        for(i=0;i<n;i++)cnt[str[i]]++;//统计词频
        for(i=0;i<f.length;i++) cnt[f[i]]-=n>>2;//减去n/4之后变成了冗余表
        int[] win=new int[128];//窗口维持的词频表，需要涵盖cnt中所有的冗余字符
        for(l=r=0;l<n&&l<=r;){
            while(r<n&&!check(cnt,win)) win[str[r++]]++;
            if(check(cnt,win)) ans=Math.min(ans,r-l);
            win[str[l++]]--;
        }
        return ans;
    }

    int[] f=new int[]{'Q','W','E','R'};//只检查这4个下标位置，而不是全部的128个位置
    public boolean check(int[] cnt,int[] win){
        for(int i=0;i<f.length;i++){
            if(cnt[f[i]]>0&&win[f[i]]<cnt[f[i]]) return false;
        }
        return true;
    }
}