package audition;

import assit.TreeNode;

/**
 * 剑指 Offer 68 - II. 二叉树的最近公共祖先
 * @Description
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 *
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 *
 * @auther SHENKAIHUAN
 * @create 2020-07-05 21:37
 */
public class LowestCommonAncestorII {
    public static void main(String[] args) {
        TreeNode root = new TreeNode (3);
        root.left=new TreeNode (5);
        root.left.left=new TreeNode (6);
        root.left.right=new TreeNode (2);
        root.left.right.left=new TreeNode (7);
        root.left.right.right=new TreeNode (4);

        root.right=new TreeNode (1);
        root.right.left=new TreeNode (0);
        root.right.right=new TreeNode (8);

        TreeNode p= new TreeNode (5);
        TreeNode q=new TreeNode (4);
        System.out.println (lowestCommonAncestor(root,p,q).val);

    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || root.val==p.val || root.val==q.val )return root;
        TreeNode left = lowestCommonAncestor (root.left, p, q);
        TreeNode right = lowestCommonAncestor (root.right, p, q);
        if (left ==null) return right;
        if(right==null) return left;
        return root;

    }
}
