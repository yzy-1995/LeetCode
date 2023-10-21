package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/10/21 09:07
 * @Description
 * 给定一颗根结点为 root 的二叉树，树中的每一个结点都有一个 [0, 25] 范围内的值，分别代表字母 'a' 到 'z'。
 *
 * 返回 按字典序最小 的字符串，该字符串从这棵树的一个叶结点开始，到根结点结束。
 *
 * 注：字符串中任何较短的前缀在 字典序上 都是 较小 的：
 *
 * 例如，在字典序上 "ab" 比 "aba" 要小。叶结点是指没有子结点的结点。
 * 节点的叶节点是没有子节点的节点。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：root = [0,1,2,3,4,3,4]
 * 输出："dba"
 * 示例 2：
 *
 *
 *
 * 输入：root = [25,1,3,1,3,0,2]
 * 输出："adz"
 * 示例 3：
 *
 *
 *
 * 输入：root = [2,2,1,null,1,0,null,0]
 * 输出："abc"
 * @Version 1.0
 */
public class smalleststringstartingfromleaf {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    String res;
    int size;
    char[] chs;
    public String smallestFromLeaf(TreeNode root) {
        res=null;
        int TreeDepth=getTreeDepth(root);   // 获取二叉树最大深度
        size=0;
        chs=new char[TreeDepth+2];  // 申请二叉树最大深度空间即可
        dfs(root);
        return res;
    }
    public void dfs(TreeNode root){
        if(root == null) { return; }
        // 将该节点添加进来
        chs[size++]=(char)(root.val+'a');

        // 左右子树递归
        dfs(root.left);
        dfs(root.right);

        // 如果左右子树为空，说明这个结点是叶子结点，那么就可以进行比较
        if(root.left == null && root.right == null) {
            String val=getString(); // 将当前添加进行数组的字母转换成字符串
            // 如果res为空或val字符串小于res串，那么就修改res串
            if(res == null || !process(res,val)) { res=val; }
        }
        --size; // 将添加进来的数据删除
        return;
    }
    public int getTreeDepth(TreeNode root){
        if(null == root) { return 0; }
        return getTreeDepth(root.left)+getTreeDepth(root.right)+1;
    }
    // 转换成字符串返回
    public String getString(){
        StringBuilder sb=new StringBuilder();
        for(int i=size-1; i>=0; --i){ sb.append((char)chs[i]); }
        return sb.toString();
    }
    // 比较两个字符串长短
    public boolean process(String a,String b){
        int n=a.length();
        int m=b.length();

        for(int i=0; i<n && i<m; ++i){
            // 如果当前字符串相等那么就直接返回大小结果
            if(a.charAt(i) != b.charAt(i)) { return a.charAt(i) < b.charAt(i); }
        }
        // 如果ab串结束后还是相等，那么判断长度情况
        return n < m;
    }
}