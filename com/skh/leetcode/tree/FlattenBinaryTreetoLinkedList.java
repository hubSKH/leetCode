package leetcode.tree;

import assit.TreeNode;

/**
 * 114. 二叉树展开为链表
 * 给定一个二叉树，原地将它展开为链表。
 * 例如，给定二叉树\
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * 将其展开为：
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 * @Description
 * @auther SHENKAIHUAN
 * @create 2019-11-10 11:02
 */
public class FlattenBinaryTreetoLinkedList {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode (1);
        TreeNode node2 = new TreeNode (2);
        TreeNode node3 = new TreeNode (3);
        TreeNode node4 = new TreeNode (4);
        TreeNode node5 = new TreeNode (5);
        TreeNode node6 = new TreeNode (6);
        node1.left = node2;
        node1.right = node5;
        node2.left = node3;
        node2.right = node4;
        node5.right = node6;

        long start = System.currentTimeMillis ();
        flatten (node1);
        long end = System.currentTimeMillis ();
        System.out.println ("total:" + (end - start));
    }

    public static void flatten(TreeNode root) {
        change (root);
    }

    private static TreeNode change(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode resultNode;
        TreeNode p = root.left;
        TreeNode q = root.right;
        TreeNode left = change (p);
        TreeNode right = change (q);
        root.left = null;
        if (left != null) {
            root.right = p;
            left.right = q;
        }
        if (right != null) {
            resultNode = right;
        } else if (left != null) {
            resultNode = left;
        } else {
            resultNode = root;
        }
        return resultNode;
    }
}
