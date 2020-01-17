package leetcode.tree;

import assit.TreeNode;

/**
 * 104. 二叉树的最大深度
 * @Description
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * @auther SHENKAIHUAN
 * @create 2020-01-17 22:37
 */
public class MaximumDepthofBinaryTree {
    public static void main(String[] args) {
        TreeNode node13 = new TreeNode (3);
        TreeNode node29 = new TreeNode (9);
        TreeNode node220 = new TreeNode (20);
        TreeNode node315 = new TreeNode (15);
        TreeNode node37 = new TreeNode (7);

        node13.left=node29;
        node13.right=node220;
        node220.left=node315;
        node220.right=node37;

        long start =System.currentTimeMillis ();
        System.out.println (maxDepth(node13));
        long end =System.currentTimeMillis ();
        System.out.println ("total:"+(end-start));
    }

    public static int maxDepth(TreeNode root) {
        if(root==null) return 0;
        return Math.max (maxDepth (root.left),maxDepth (root.right))+1;
    }
}
