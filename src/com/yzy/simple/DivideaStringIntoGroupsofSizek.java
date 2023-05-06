package com.yzy.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: DivideaStringIntoGroupsofSizek
 * Description:
 * 字符串 s 可以按下述步骤划分为若干长度为 k 的组：
 * 第一组由字符串中的前 k 个字符组成，第二组由接下来的 k 个字符串组成，依此类推。每个字符都能够成为 某一个 组的一部分。
 * 对于最后一组，如果字符串剩下的字符 不足 k 个，需使用字符 fill 来补全这一组字符。
 * 注意，在去除最后一个组的填充字符 fill（如果存在的话）并按顺序连接所有的组后，所得到的字符串应该是 s 。
 * 给你一个字符串 s ，以及每组的长度 k 和一个用于填充的字符 fill ，按上述步骤处理之后，返回一个字符串数组，该数组表示 s 分组后 每个组的组成情况 。
 * 示例 1：
 * 输入：s = "abcdefghi", k = 3, fill = "x"
 * 输出：["abc","def","ghi"]
 * 解释：
 * 前 3 个字符是 "abc" ，形成第一组。
 * 接下来 3 个字符是 "def" ，形成第二组。
 * 最后 3 个字符是 "ghi" ，形成第三组。
 * 由于所有组都可以由字符串中的字符完全填充，所以不需要使用填充字符。
 * 因此，形成 3 组，分别是 "abc"、"def" 和 "ghi" 。
 * 示例 2：
 * 输入：s = "abcdefghij", k = 3, fill = "x"
 * 输出：["abc","def","ghi","jxx"]
 * 解释：
 * 与前一个例子类似，形成前三组 "abc"、"def" 和 "ghi" 。
 * 对于最后一组，字符串中仅剩下字符 'j' 可以用。为了补全这一组，使用填充字符 'x' 两次。
 * 因此，形成 4 组，分别是 "abc"、"def"、"ghi" 和 "jxx" 。
 * @author Administrator
 * @date 2023-5-6 9:59
 */
public class DivideaStringIntoGroupsofSizek {
    public static void main(String[] args) {
        for (String o :divideString("abcdefghij", 3, 'x')) {
            System.out.println(o);

        }

    }

    public static String[] divideString(String s, int k, char fill) {
        int len = s.length();
        int num = len % k == 0 ? len / k : len / k + 1;
        String[] res = new String[num];
        int index = 0;
        for (int i = 0; i < len; i += k) {
            if (len - i < k) {
                StringBuilder sb = new StringBuilder();
                sb.append(s, i, len);
                for (int j = 0; j < k - len + i; j++) {
                    sb.append(fill);
                }
                res[index++] = sb.toString();
            } else {
                res[index++] = s.substring(i, i + k);
            }
        }
        return res;
    }
}
