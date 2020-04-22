package audition;

import assit.TreeNode;

/**
 * 面试题28. 对称的二叉树
 * @Description
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * @auther SHENKAIHUAN
 * @create 2020-04-22 23:52
 */
public class IsSymmetric {
    public static void main(String[] args) {

        TreeNode root =new TreeNode (1);
        root.left=new TreeNode (2);
        root.left.left=new TreeNode (3);
        root.left.right=new TreeNode (4);
        root.right=new TreeNode (2);
        root.right.left=new TreeNode (4);
        root.right.right=new TreeNode (3);
        long start=System.currentTimeMillis ();
        System.out.println (isSymmetric (root));
        long end=System.currentTimeMillis ();
        System.out.println ("total:"+(end-start));

    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isMiror (root.left, root.right);
    }

    private static boolean isMiror(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        return (left.val == right.val) && isMiror (left.left, right.right) && isMiror (left.right, right.left);
    }
}
