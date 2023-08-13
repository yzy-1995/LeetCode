package com.yzy.mid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/08/14 00:19
 * @Description
 * 给你一个目录信息列表 paths ，包括目录路径，以及该目录中的所有文件及其内容，请你按路径返回文件系统中的所有重复文件。答案可按 任意顺序 返回。
 *
 * 一组重复的文件至少包括 两个 具有完全相同内容的文件。
 *
 * 输入 列表中的单个目录信息字符串的格式如下：
 *
 * "root/d1/d2/.../dm f1.txt(f1_content) f2.txt(f2_content) ... fn.txt(fn_content)"
 * 这意味着，在目录 root/d1/d2/.../dm 下，有 n 个文件 ( f1.txt, f2.txt ... fn.txt ) 的内容分别是 ( f1_content, f2_content ... fn_content ) 。注意：n >= 1 且 m >= 0 。如果 m = 0 ，则表示该目录是根目录。
 *
 * 输出 是由 重复文件路径组 构成的列表。其中每个组由所有具有相同内容文件的文件路径组成。文件路径是具有下列格式的字符串：
 *
 * "directory_path/file_name.txt"
 *
 *
 * 示例 1：
 *
 * 输入：paths = ["root/a 1.txt(abcd) 2.txt(efgh)","root/c 3.txt(abcd)","root/c/d 4.txt(efgh)","root 4.txt(efgh)"]
 * 输出：[["root/a/2.txt","root/c/d/4.txt","root/4.txt"],["root/a/1.txt","root/c/3.txt"]]
 * 示例 2：
 *
 * 输入：paths = ["root/a 1.txt(abcd) 2.txt(efgh)","root/c 3.txt(abcd)","root/c/d 4.txt(efgh)"]
 * 输出：[["root/a/2.txt","root/c/d/4.txt"],["root/a/1.txt","root/c/3.txt"]]
 * @Version 1.0
 */
public class FindDuplicateFileInSystem {
    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> list = new ArrayList<List<String>>();
        Map<String, Integer> map = new HashMap<String, Integer>();
        int index = 0;
        for (String str : paths) {
            String[] strs = str.split(" ");
            for (int i = 1; i < strs.length; i++) {
                String key = strs[i].substring(strs[i].indexOf("(") + 1, strs[i].indexOf(")"));
                if (!map.containsKey(key)) {
                    map.put(key, index++);
                    list.add(new ArrayList<String>());
                }
                list.get(map.get(key)).add(strs[0] + "/" + strs[i].substring(0, strs[i].indexOf("(")));
            }
        }
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i).size() < 2)
                list.remove(i);
        }
        return list;
    }
}