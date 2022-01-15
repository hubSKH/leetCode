package leetcode.tree;

import assit.TreeNode;

/**
 * 112. 路径总和
 * @Description
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例: 
 * 给定如下二叉树，以及目标和 sum = 22，
 *                5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \      \
 *         7    2      1
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 * @auther SHENKAIHUAN
 * @create 2020-01-11 23:32
 */
public class PathSum {
    public static void main(String[] args) throws CloneNotSupportedException {
        int sum = 22;
        TreeNode root = new TreeNode (5);
        TreeNode node41 = new TreeNode (4);
        TreeNode node8 = new TreeNode (8);
        TreeNode node11 = new TreeNode (11);
        TreeNode node13 = new TreeNode (13);
        TreeNode node4 = new TreeNode (4);
        TreeNode node7= new TreeNode (7);
        TreeNode node2 = new TreeNode (2);
        TreeNode node1 = new TreeNode (1);

        root.left=node41;
        root.right=node8;
        node41.left=node11;
        node8.left=node13;
        node8.right=node4;
        node11.left=node7;
        node11.right=node2;
        node4.left=node1;

        long start =System.currentTimeMillis ();
        System.out.println (hasPathSum(root,sum));
        long end =System.currentTimeMillis ();
        System.out.println ("total:"+(end-start));
    }

    public static boolean hasPathSum(TreeNode root, int sum) {
        if(root==null) return false;
        sum -= root.val;
        if(root.left==null && root.right==null) return sum==0;
        return  hasPathSum (root.left,sum)||hasPathSum (root.right,sum);
    }

}
