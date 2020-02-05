package leetcode.tree;

import assit.TreeNode;

/**
 * 98. 验证二叉搜索树
 * @Description
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 *
 * @auther SHENKAIHUAN
 * @create 2020-02-04 16:34
 */
public class ValidateBinarySearchTree {
    public static void main(String[] args) {

        TreeNode node2 = new TreeNode (2);
        TreeNode node1 = new TreeNode (1);
        TreeNode node3 = new TreeNode (3);
        node2.left=node1;
        node2.right=node3;

        TreeNode node10 = new TreeNode (10);
        TreeNode node5 = new TreeNode (5);
        TreeNode node15 = new TreeNode (15);
        TreeNode node6 = new TreeNode (6);
        TreeNode nod20 = new TreeNode (20);
        node10.left=node5;
        node10.right=node15;
        node15.left=node6;
        node15.right=nod20;
        long start =System.currentTimeMillis ();
        System.out.println (isValidBST(node2));
        long end =System.currentTimeMillis ();
        System.out.println ("total:"+(end-start));
    }

    public static boolean isValidBST(TreeNode root) {

        return isValidBST (root,null,null);
    }

    private static boolean isValidBST(TreeNode root, Integer low, Integer high) {
        if(root ==null) return true;
        if(low!=null && root.val<=low ) return false;
        if(high!=null && root.val>=high) return false;
        return  isValidBST (root.left,low,root.val) && isValidBST (root.right,root.val,high);
    }


}
