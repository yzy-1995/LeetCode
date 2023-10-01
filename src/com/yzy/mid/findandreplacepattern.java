package com.yzy.mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/10/02 00:50
 * @Description
 * 你有一个单词列表 words 和一个模式  pattern，你想知道 words 中的哪些单词与模式匹配。
 *
 * 如果存在字母的排列 p ，使得将模式中的每个字母 x 替换为 p(x) 之后，我们就得到了所需的单词，那么单词与模式是匹配的。
 *
 * （回想一下，字母的排列是从字母到字母的双射：每个字母映射到另一个字母，没有两个字母映射到同一个字母。）
 *
 * 返回 words 中与给定模式匹配的单词列表。
 *
 * 你可以按任何顺序返回答案。
 *
 *
 *
 * 示例：
 *
 * 输入：words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
 * 输出：["mee","aqq"]
 * 解释：
 * "mee" 与模式匹配，因为存在排列 {a -> m, b -> e, ...}。
 * "ccc" 与模式不匹配，因为 {a -> c, b -> c, ...} 不是排列。
 * 因为 a 和 b 映射到同一个字母。
 * @Version 1.0
 */
public class findandreplacepattern {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        char c[]=pattern.toCharArray();
        List<String> ans=new ArrayList<>();
        for(int i=0;i<words.length;i++){if(isMatched(c,words[i].toCharArray())){ans.add(words[i]);}}
        return ans;
    }
    boolean isMatched(char c[],char c1[]){
        int map[]=new int[130];
        boolean hasMap[]=new boolean[130];
        Arrays.fill(map,-1);
        for(int i=0;i<c.length;i++){
            if(map[c[i]]==-1){
                if(hasMap[c1[i]]){return false;}
                map[c[i]]=c1[i];
                hasMap[c1[i]]=true;
            }
            else if(map[c[i]]!=c1[i]){return false;}
        }
        return true;
    }
}