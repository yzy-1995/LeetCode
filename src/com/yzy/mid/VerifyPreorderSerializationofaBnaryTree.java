package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/06/27 19:38
 * @Description
 * 序列化二叉树的一种方法是使用 前序遍历 。当我们遇到一个非空节点时，我们可以记录下这个节点的值。如果它是一个空节点，我们可以使用一个标记值记录，例如 #。
 *
 *
 *
 * 例如，上面的二叉树可以被序列化为字符串 "9,3,4,#,#,1,#,#,2,#,6,#,#"，其中 # 代表一个空节点。
 *
 * 给定一串以逗号分隔的序列，验证它是否是正确的二叉树的前序序列化。编写一个在不重构树的条件下的可行算法。
 *
 * 保证 每个以逗号分隔的字符或为一个整数或为一个表示 null 指针的 '#' 。
 *
 * 你可以认为输入格式总是有效的
 *
 * 例如它永远不会包含两个连续的逗号，比如 "1,,3" 。
 * 注意：不允许重建树。
 *
 *
 *
 * 示例 1:
 *
 * 输入: preorder = "9,3,4,#,#,1,#,#,2,#,6,#,#"
 * 输出: true
 * 示例 2:
 *
 * 输入: preorder = "1,#"
 * 输出: false
 * 示例 3:
 *
 * 输入: preorder = "9,#,#,1"
 * 输出: false
 * @Version 1.0
 */
public class VerifyPreorderSerializationofaBnaryTree {

    public boolean isValidSerialization(String preorder) {
        int count=0,nodeCount=1;
        for (char c :preorder.toCharArray()) {
            if (count >nodeCount-count) return false;
            if (c==',')nodeCount++;
            if (c=='#')count++;
        }
        return nodeCount-count+1 ==count;
    }
}