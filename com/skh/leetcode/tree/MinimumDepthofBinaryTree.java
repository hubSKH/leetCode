package leetcode.tree;

import assit.TreeNode;

/**
 * 111. 二叉树的最小深度
 * @Description
 * 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 给定二叉树 [3,9,20,null,null,15,7],
 *    3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最小深度  2.
 * @auther SHENKAIHUAN
 * @create 2020-02-10 9:38
 */
public class MinimumDepthofBinaryTree {
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

        TreeNode node = new TreeNode (1);
        node.right = new TreeNode (2);
        long start =System.currentTimeMillis ();
        System.out.println (minDepth(node));
        long end =System.currentTimeMillis ();
        System.out.println ("total:"+(end-start));
    }
    public static int minDepth(TreeNode root) {
        if(root==null) return 0;
        if(root.left==null && root.right==null) return 1;
        int leftDepth =minDepth (root.left);
        int rightDepth=minDepth (root.right);
        if(leftDepth==0||rightDepth==0) return leftDepth+rightDepth+1;
        return Math.min (leftDepth,rightDepth)+1;
    }
}
