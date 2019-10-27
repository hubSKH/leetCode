package leetcode.tree;

import assit.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 101. 对称二叉树
 *
 * @Description 给定一个二叉树，检查它是否是镜像对称的。
 * <p>
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 * @auther SHENKAIHUAN
 * @create 2019-10-21 23:15
 */
public class SymmetricTree {
    public static void main(String[] args) {
        TreeNode p = new TreeNode (1);
        TreeNode node2 = new TreeNode (2);
        TreeNode node3 = new TreeNode (2);
        TreeNode node2l = new TreeNode (3);
        TreeNode node2r = new TreeNode (4);
        TreeNode node3l = new TreeNode (4);
        TreeNode node3r = new TreeNode (3);
        p.left = node2;
        p.right = node3;
        node2.left = node2l;
        node2.right = node2r;
        node3.left = node3l;
        node3.right = node3r;

        long start = System.currentTimeMillis ();
        System.out.println (isSymmetric (p));
        long end = System.currentTimeMillis ();
        System.out.println ("total:" + (end - start));
    }

    public static boolean isSymmetric(TreeNode root) {

        if (root == null) {
            return true;
        }
        return isMiror (root.left, root.right);
    }

    private static boolean isMiror(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return (left.val == right.val) && isMiror (left.left, right.right) && isMiror (left.right, right.left);
    }
}
