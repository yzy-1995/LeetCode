package com.yzy.simple;

/**
 * ClassName: MergeTwoBinaryTrees
 * Description:
 * 给你两棵二叉树： root1 和 root2 。
 * <p>
 * 想象一下，当你将其中一棵覆盖到另一棵之上时，两棵树上的一些节点将会重叠（而另一些不会）。
 * 你需要将这两棵树合并成一棵新二叉树。合并的规则是：如果两个节点重叠，
 * 那么将这两个节点的值相加作为合并后节点的新值；否则，不为 null 的节点将直接作为新二叉树的节点。
 * <p>
 * 返回合并后的二叉树。
 * <p>
 * 注意: 合并过程必须从两个树的根节点开始。
 *
 * @author Administrator
 * @date 2023-3-28 14:30
 */
public class MergeTwoBinaryTrees {
    public static void main(String[] args) {

    }

    /**
     * 对于两棵二叉树的合并，我们可以采用递归的思想。对于每一个节点，
     * 我们分别递归合并它们的左子树和右子树，并且根据规则合并当前节点。
     *
     * 具体来说，我们可以定义一个递归函数，该函数接收两个节点作为参数，
     * 返回合并后的节点。如果其中一个节点为空，那么直接返回另一个节点；
     * 否则，我们将两个节点的值相加，并且递归合并它们的左右子树，最后返回新构建的节点。
     * @param root1
     * @param root2
     * @return
     */
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        TreeNode merged = new TreeNode(root1.val + root2.val);
        merged.left = mergeTrees(root1.left, root2.left);
        merged.right = mergeTrees(root1.right, root2.right);
        return merged;
    }
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
}
