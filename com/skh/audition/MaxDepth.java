package audition;

import assit.TreeNode;

/**
 * 面试题55 - I. 二叉树的深度
 * @Description
 * 输入一棵二叉树的根节点，求该树的深度。
 * 从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *  返回它的最大深度 3
 * @auther SHENKAIHUAN
 * @create 2020-06-11 0:37
 */
public class MaxDepth {
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
