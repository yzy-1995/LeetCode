package com.yzy.mid;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/10/29 00:03
 * @Description 给出长度相同的两个字符串s1 和 s2 ，还有一个字符串 baseStr 。
 * <p>
 * 其中  s1[i] 和 s2[i]  是一组等价字符。
 * <p>
 * 举个例子，如果 s1 = "abc" 且 s2 = "cde"，那么就有 'a' == 'c', 'b' == 'd', 'c' == 'e'。
 * 等价字符遵循任何等价关系的一般规则：
 * <p>
 * 自反性 ：'a' == 'a'
 * 对称性 ：'a' == 'b' 则必定有 'b' == 'a'
 * 传递性 ：'a' == 'b' 且 'b' == 'c' 就表明 'a' == 'c'
 * 例如， s1 = "abc" 和 s2 = "cde" 的等价信息和之前的例子一样，那么 baseStr = "eed" , "acd" 或 "aab"，这三个字符串都是等价的，而 "aab" 是 baseStr 的按字典序最小的等价字符串
 * <p>
 * 利用 s1 和 s2 的等价信息，找出并返回 baseStr 的按字典序排列最小的等价字符串。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s1 = "parker", s2 = "morris", baseStr = "parser"
 * 输出："makkek"
 * 解释：根据 A 和 B 中的等价信息，我们可以将这些字符分为 [m,p], [a,o], [k,r,s], [e,i] 共 4 组。每组中的字符都是等价的，并按字典序排列。所以答案是 "makkek"。
 * 示例 2：
 * <p>
 * 输入：s1 = "hello", s2 = "world", baseStr = "hold"
 * 输出："hdld"
 * 解释：根据 A 和 B 中的等价信息，我们可以将这些字符分为 [h,w], [d,e,o], [l,r] 共 3 组。所以只有 S 中的第二个字符 'o' 变成 'd'，最后答案为 "hdld"。
 * 示例 3：
 * <p>
 * 输入：s1 = "leetcode", s2 = "programs", baseStr = "sourcecode"
 * 输出："aauaaaaada"
 * 解释：我们可以把 A 和 B 中的等价字符分为 [a,o,e,r,s,c], [l,p], [g,t] 和 [d,m] 共 4 组，因此 S 中除了 'u' 和 'd' 之外的所有字母都转化成了 'a'，最后答案为 "aauaaaaada"。
 * @Version 1.0
 */
public class lexicographicallysmallestequivalentstring {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        UnionFind1 uf = new UnionFind1();
        for (int i = 0; i < s1.length(); i++) {
            uf.add(s1.charAt(i));
            uf.add(s2.charAt(i));

            uf.merge(s1.charAt(i), s2.charAt(i));
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < baseStr.length(); i++) {
            char cur = baseStr.charAt(i);
            if (uf.find(cur) == cur) sb.append(cur);
            else {
                sb.append(uf.find(cur));
            }
        }

        return sb.toString();
    }
}

class UnionFind1 {
    private Map<Character, Character> map;
    private int size;

    public UnionFind1() {
        this.map = new HashMap<>();
        this.size = 0;
    }

    public void add(char c) {
        if (!map.containsKey(c)) {
            map.put(c, null);
            size++;
        }
    }

    public char find(char x) {
        char root = x;

        while (map.get(root) != null) {
            root = map.get(root);
        }

        if (x != root) {
            char temp = map.get(x);
            map.put(x, root);
            x = temp;
        }

        return root;
    }

    public void merge(char x, char y) {
        char rootX = find(x);
        char rootY = find(y);

        if (rootX == rootY) return;

        if (rootX > rootY) {
            map.put(rootX, rootY);
        } else {
            map.put(rootY, rootX);
        }

        size--;
    }

    public int size() {
        return size;
    }

    public boolean isConnected(char x, char y) {
        return find(y) == find(y);
    }
}