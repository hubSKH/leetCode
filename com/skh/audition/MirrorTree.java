package audition;

import assit.TreeNode;

/**
 * 面试题27. 二叉树的镜像
 * @Description
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 *
 * 例如输入：
 *       4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 镜像输出：
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 * @auther SHENKAIHUAN
 * @create 2020-04-22 23:26
 */
public class MirrorTree {
    public static void main(String[] args) {

        TreeNode root =new TreeNode (4);
        root.left=new TreeNode (2);
        root.left.left=new TreeNode (1);
        root.left.right=new TreeNode (3);
        root.right=new TreeNode (7);
        root.right.left=new TreeNode (6);
        root.right.right=new TreeNode (9);
        long start=System.currentTimeMillis ();
        TreeNode node = mirrorTree (root);
        long end=System.currentTimeMillis ();
        System.out.println ("total:"+(end-start));

    }
    public static TreeNode mirrorTree(TreeNode root) {
        if(root==null) return null;
        mirrorTree (root.left);
        mirrorTree (root.right);
        TreeNode p=root.right;
        root.right=root.left;
        root.left=p;
        return root;
    }
}
