package leetcode.tree;

import assit.TreeNode;

/**
 * 100. 相同的树
 * @Description
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 *
 * 输入:       1         1
 *           / \       / \
 *          2   3     2   3
 *         [1,2,3],   [1,2,3]
 * 输出: true
 *
 *
 * 输入:      1          1
 *           /           \
 *          2             2
 *         [1,2],     [1,null,2]
 * 输出: false
 * @auther SHENKAIHUAN
 * @create 2019-10-21 22:36
 */
public class SameTree {
    public static void main(String[] args) {
        TreeNode p = new TreeNode (1);
        TreeNode node2 = new TreeNode (2);
        TreeNode node3 = new TreeNode (3);
        p.left=node2;
        p.right=node3;

        TreeNode q = new TreeNode (1);
        TreeNode q2 = new TreeNode (2);
        TreeNode q3 = new TreeNode (3);
        q.left=q2;
        q.right=q3;
        long start =System.currentTimeMillis ();
        System.out.println (isSameTree(p,q));
        long end =System.currentTimeMillis ();
        System.out.println ("total:"+(end-start));
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null){
            if(q==null){
                return true;
            }
            return false;
        }
        if(q == null){
            return false;
        }else {
            if(p.val == q.val){
                return isSameTree (p.left,q.left) && isSameTree (p.right,q.right);
            }
            return false;
        }
    }
}
