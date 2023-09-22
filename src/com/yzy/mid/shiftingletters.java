package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/09/22 11:19
 * @Description
 * 有一个由小写字母组成的字符串 s，和一个长度相同的整数数组 shifts。
 *
 * 我们将字母表中的下一个字母称为原字母的 移位 shift() （由于字母表是环绕的， 'z' 将会变成 'a'）。
 *
 * 例如，shift('a') = 'b', shift('t') = 'u', 以及 shift('z') = 'a'。
 * 对于每个 shifts[i] = x ， 我们会将 s 中的前 i + 1 个字母移位 x 次。
 *
 * 返回 将所有这些移位都应用到 s 后最终得到的字符串 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "abc", shifts = [3,5,9]
 * 输出："rpl"
 * 解释：
 * 我们以 "abc" 开始。
 * 将 S 中的第 1 个字母移位 3 次后，我们得到 "dbc"。
 * 再将 S 中的前 2 个字母移位 5 次后，我们得到 "igc"。
 * 最后将 S 中的这 3 个字母移位 9 次后，我们得到答案 "rpl"。
 * 示例 2:
 *
 * 输入: s = "aaa", shifts = [1,2,3]
 * 输出: "gfd"
 * @Version 1.0
 */
public class shiftingletters {
    public String shiftingLetters(String s, int[] shifts) {
        for(int i=shifts.length-2;i>=0;i--){shifts[i]=(shifts[i+1]+shifts[i])%26;}
        StringBuilder ans=new StringBuilder();
        for(int i=0;i<s.length();i++){ans.append((char)((s.charAt(i)-'a'+shifts[i])%26+'a'));}
        return ans.toString();
    }
}