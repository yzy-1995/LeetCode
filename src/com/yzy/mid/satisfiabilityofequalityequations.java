package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/10/21 09:09
 * @Description
 * 给定一个由表示变量之间关系的字符串方程组成的数组，每个字符串方程 equations[i] 的长度为 4，并采用两种不同的形式之一："a==b" 或 "a!=b"。在这里，a 和 b 是小写字母（不一定不同），表示单字母变量名。
 *
 * 只有当可以将整数分配给变量名，以便满足所有给定的方程时才返回 true，否则返回 false。
 *
 *
 *
 * 示例 1：
 *
 * 输入：["a==b","b!=a"]
 * 输出：false
 * 解释：如果我们指定，a = 1 且 b = 1，那么可以满足第一个方程，但无法满足第二个方程。没有办法分配变量同时满足这两个方程。
 * 示例 2：
 *
 * 输入：["b==a","a==b"]
 * 输出：true
 * 解释：我们可以指定 a = 1 且 b = 1 以满足满足这两个方程。
 * 示例 3：
 *
 * 输入：["a==b","b==c","a==c"]
 * 输出：true
 * 示例 4：
 *
 * 输入：["a==b","b!=c","c==a"]
 * 输出：false
 * 示例 5：
 *
 * 输入：["c==c","b==d","x!=z"]
 * 输出：true
 * @Version 1.0
 */
public class satisfiabilityofequalityequations {
    class unionFind{
        int[] father = new int[26];
        public unionFind(){
            for(int i = 0; i < 26; ++i)
                father[i] = i;
        }
        public void merge(int x, int y){
            int fx = find(x), fy = find(y);
            if(fx != fy){
                father[fx] = father[fy];
            }
        }
        public int find(int x){
            if(father[x] == x) return x;
            int root = x;
            while(father[root] != root){
                root = father[root];
            }
            while(x != father[x]){
                int tem = father[x];
                father[x] = root;
                x = tem;
            }
            return root;
        }
        public boolean isConnection(int x, int y){
            return find(x) == find(y);
        }
    }
    public boolean equationsPossible(String[] equations) {
        var union = new unionFind();
        for(String e : equations){
            if(e.charAt(1) == '='){
                union.merge(e.charAt(0) - 'a', e.charAt(3) - 'a');
            }
        }
        for(String e : equations){
            if(e.charAt(1) == '!'){
                if(union.isConnection(e.charAt(0) - 'a', e.charAt(3) - 'a'))
                    return false;
            }
        }
        return true;
    }
}