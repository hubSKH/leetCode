package leetcode.tree;

import assit.TreeBuilder;
import assit.TreeNode;

/**
 * 236. 二叉树的最近公共祖先
 *
 * @Description 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，
 * 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出：3
 * 解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
 * @auther SHENKAIHUAN
 * @create 2021-05-15 17:36
 */
public class LowestCommonAncestor {
    public static void main(String[] args) {
        Integer[] nums = new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4};
        TreeNode root = TreeBuilder.buildTree (nums);
        TreeNode treeNode = lowestCommonAncestor (root, root.left, root.right);
        System.out.println (treeNode);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root.val == p.val || root.val == q.val) return root;
        TreeNode left = lowestCommonAncestor (root.left, p, q);
        TreeNode right = lowestCommonAncestor (root.right, p, q);
        if (left == null) return right;
        if (right == null) return left;
        return root;
    }
}
