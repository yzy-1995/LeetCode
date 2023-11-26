package com.yzy.mid;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/11/24 16:32
 * @Description
 * 给你一个字符串 s。请你按照单词在 s 中的出现顺序将它们全部竖直返回。
 * 单词应该以字符串列表的形式返回，必要时用空格补位，但输出尾部的空格需要删除（不允许尾随空格）。
 * 每个单词只能放在一列上，每一列中也只能有一个单词。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "HOW ARE YOU"
 * 输出：["HAY","ORO","WEU"]
 * 解释：每个单词都应该竖直打印。
 *  "HAY"
 *  "ORO"
 *  "WEU"
 * 示例 2：
 *
 * 输入：s = "TO BE OR NOT TO BE"
 * 输出：["TBONTB","OEROOE","   T"]
 * 解释：题目允许使用空格补位，但不允许输出末尾出现空格。
 * "TBONTB"
 * "OEROOE"
 * "   T"
 * 示例 3：
 *
 * 输入：s = "CONTEST IS COMING"
 * 输出：["CIC","OSO","N M","T I","E N","S G","T"]
 * @Version 1.0
 */
public class printwordsvertically {
    public List<String> printVertically(String s) {
        String[] str_arr = s.split(" ");
        int max_len = 0;
        for(int i = 0; i < str_arr.length; i++){
            max_len = Math.max(max_len, str_arr[i].length());
        }
        List<String> res = new ArrayList<>();
        for(int i = 0 ; i < max_len; i++){
            StringBuffer sb = new StringBuffer();
            for(int j = 0; j < str_arr.length; j++){

                if(str_arr[j].length() >= i +1){
                    sb.append(str_arr[j].charAt(i)); //
                } else{
                    sb.append(" ");
                }
            }
            for(int k = sb.length() - 1; k >= 0; k--){
                if(sb.charAt(k) == ' '){
                    sb.deleteCharAt(k);
                } else{
                    break;
                }
            }
            String new_word = sb.toString();
            res.add(new_word);
        }
        return res;
    }
}