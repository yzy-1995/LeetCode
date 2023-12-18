package com.yzy.mid;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/12/11 00:09
 * @Description
 * 如果字符串中不含有任何 'aaa'，'bbb' 或 'ccc' 这样的字符串作为子串，那么该字符串就是一个「快乐字符串」。
 *
 * 给你三个整数 a，b ，c，请你返回 任意一个 满足下列全部条件的字符串 s：
 *
 * s 是一个尽可能长的快乐字符串。
 * s 中 最多 有a 个字母 'a'、b 个字母 'b'、c 个字母 'c' 。
 * s 中只含有 'a'、'b' 、'c' 三种字母。
 * 如果不存在这样的字符串 s ，请返回一个空字符串 ""。
 *
 *
 *
 * 示例 1：
 *
 * 输入：a = 1, b = 1, c = 7
 * 输出："ccaccbcc"
 * 解释："ccbccacc" 也是一种正确答案。
 * 示例 2：
 *
 * 输入：a = 2, b = 2, c = 1
 * 输出："aabbc"
 * 示例 3：
 *
 * 输入：a = 7, b = 1, c = 0
 * 输出："aabaa"
 * 解释：这是该测试用例的唯一正确答案。
 * @Version 1.0
 */
public class longesthappystring {
    public String longestDiverseString(int a, int b, int c) {
        Queue<letterCount> q=new PriorityQueue<>((l1, l2)->l2.count-l1.count);
        if(a>0){q.add(new letterCount(a,'a'));}
        if(b>0){q.add(new letterCount(b,'b'));}
        if(c>0){q.add(new letterCount(c,'c'));}
        StringBuilder ans=new StringBuilder();
        char preChar='.';//前边的字母
        int preCount=0;//前边字母的重复的次数
        while(q.size()>0){
            letterCount lc=q.poll();
            if(lc.letter!=preChar){
                ans.append(lc.letter);
                preChar=lc.letter;
                preCount=1;
                if(lc.count>1){q.add(new letterCount(lc.count-1,lc.letter));}
            }
            else if(preCount<2){
                ans.append(lc.letter);
                preCount=2;
                if(lc.count>1){q.add(new letterCount(lc.count-1,lc.letter));}
            }
            else{
                if(q.size()==0){break;}
                letterCount lc1=q.poll();//考虑数量第二多的字母
                ans.append(lc1.letter);
                preChar=lc1.letter;
                preCount=1;
                if(lc1.count>1){q.add(new letterCount(lc1.count-1,lc1.letter));}
                q.add(lc);
            }
        }
        return ans.toString();
    }
}
class letterCount{
    int count;
    char letter;
    public letterCount(int count,char letter){
        this.count=count;
        this.letter=letter;
    }
}