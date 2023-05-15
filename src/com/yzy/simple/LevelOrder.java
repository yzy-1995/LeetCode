package com.yzy.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: LevelOrder
 * Description:
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层次遍历结果：
 * <p>
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 节点总数 <= 1000
 *
 * @author Administrator
 * @date 2023-5-15 17:41
 */
public class LevelOrder {
    public class TreeNode {

        int val;

        TreeNode left;

        TreeNode right;


        TreeNode(int x) {
            val = x;
        }

    }

    List<List<Integer>> node=new ArrayList();
    public List<List<Integer>> levelOrder(TreeNode root) {
        lei(root,0);
        return node;
    }
    public void lei(TreeNode root,int k){
        if(root!=null){
            if(node.size()<=k)node.add(new ArrayList());
            node.get(k).add(root.val);
            lei(root.left,k+1);
            lei(root.right,k+1);
        }
    }
}
