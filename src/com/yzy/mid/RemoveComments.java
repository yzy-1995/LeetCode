package com.yzy.mid;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/08/03 00:32
 * @Description
 * @Version 1.0
 */
public class RemoveComments {
    public List<String> removeComments(String[] source) {
        StringBuilder total = new StringBuilder();
        List<String> res = new ArrayList<>();
        for (int i = 0; i < source.length; i++) {
            total.append(source[i]).append("\n");
        }
        int indexline = -1, indexbb = -1, i = 0, length = total.length();

        while (i < length - 1) {
            char fi = total.charAt(i);
            char se = total.charAt(i + 1);
            if (fi == '/' && se == '/') {
                indexline = i;
                //删除直到\n
                while (i < length && total.charAt(i) != '\n') i++;
                total.delete(indexline, i);
                length -= (i - indexline);
                i = indexline - 1;
            } else if (fi == '/' && se == '*') {
                //找到下一个*/
                indexbb = i;
                i += 2;
                while (i < length - 1 && !(total.charAt(i) == '*' && total.charAt(i + 1) == '/')) i++;
                total.delete(indexbb, i + 2);
                length -= (i + 2 - indexbb);
                i = indexbb - 1;
            }
            i++;
        }
        String[] resArray = total.toString().split("\n");
        for (String str : resArray) {
            if (!"".equals(str)) {
                res.add(str);
            }
        }
        return res;
    }
}