package audition;

import assit.TreeNode;

/**
 * 剑指 Offer 68 - I. 二叉搜索树的最近公共祖先
 * @Description
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
 *
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * 输出: 6
 * 解释: 节点 2 和节点 8 的最近公共祖先是 6。
 * @auther SHENKAIHUAN
 * @create 2020-07-04 10:16
 */
public class LowestCommonAncestor {
    public static void main(String[] args) {
        TreeNode root = new TreeNode (6);
        root.left=new TreeNode (2);
        root.left.left=new TreeNode (0);
        root.left.right=new TreeNode (4);
        root.left.right.left=new TreeNode (3);
        root.left.right.right=new TreeNode (5);

        root.right=new TreeNode (8);
        root.right.left=new TreeNode (7);
        root.right.right=new TreeNode (9);

        TreeNode p= new TreeNode (2);
        TreeNode q=new TreeNode (8);
        System.out.println (lowestCommonAncestor(root,p,q).val);

    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (root.val > p.val && root.val > q.val) root = root.left;
            else if (root.val < p.val && root.val < q.val) root = root.right;
            else break;
        }
        return root;
    }
}
