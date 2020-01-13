package leetcode.tree;

import assit.TreeNode;

/**
 * 226. 翻转二叉树
 * @Description
 * 翻转一棵二叉树。
 * 输入：
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 输出：
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 * @auther SHENKAIHUAN
 * @create 2020-01-13 22:34
 */
public class InvertBinaryTree {
    public static void main(String[] args) {
        TreeNode level14 = new TreeNode (4);
        TreeNode node22 = new TreeNode (2);
        TreeNode node27 = new TreeNode (7);
        TreeNode node31 = new TreeNode (1);
        TreeNode node33 = new TreeNode (3);
        TreeNode node36 = new TreeNode (6);
        TreeNode node39= new TreeNode (9);

        level14.left = node22;
        level14.right = node27;
        node22.left=node31;
        node22.right=node33;
        node27.left=node36;
        node27.right=node39;


        long start =System.currentTimeMillis ();
        System.out.println (invertTree(level14));
        long end =System.currentTimeMillis ();
        System.out.println ("total:"+(end-start));
    }
    public static TreeNode invertTree(TreeNode root) {

        if(root==null) return root;
        TreeNode p = root.left;
        TreeNode q = root.right;
        root.left=q;
        root.right=p;
        invertTree (p);
        invertTree (q);
        return root;

    }
}
