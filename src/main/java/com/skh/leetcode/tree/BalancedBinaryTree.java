package leetcode.tree;

import assit.TreeNode;

/**
 * 110. 平衡二叉树
 * @Description
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 本题中，一棵高度平衡二叉树定义为：
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 *
 * 示例 1:
 * 给定二叉树 [3,9,20,null,null,15,7]
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * @auther SHENKAIHUAN
 * @create 2020-02-10 0:34
 */
public class BalancedBinaryTree {
    public static void main(String[] args) {
        TreeNode p = new TreeNode (3);
        TreeNode node2 = new TreeNode (9);
        TreeNode node3 = new TreeNode (20);
        p.left=node2;
        p.right=node3;

        TreeNode node4 = new TreeNode (15);
        TreeNode node5 = new TreeNode (7);
        node3.left=node4;
        node3.right=node5;
        long start =System.currentTimeMillis ();
        System.out.println (isBalanced(p));
        long end =System.currentTimeMillis ();
        System.out.println ("total:"+(end-start));
    }
    public static boolean isBalanced(TreeNode root) {
        return  depth (root)==-1;
    }
    private static int depth(TreeNode root) {
        if (root == null) return 0;
        int leftLevel =depth (root.left);
        if(leftLevel == -1) return -1;
        int rightLevel=depth (root.right);
        if(rightLevel == -1) return -1;
        return Math.abs(leftLevel - rightLevel)<2?Math.max (leftLevel,rightLevel)+1:-1;
    }
}
