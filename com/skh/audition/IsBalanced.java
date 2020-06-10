package audition;

import assit.TreeNode;

/**
 * 面试题55 - II. 平衡二叉树
 * @Description
 * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。
 * 如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 * @auther SHENKAIHUAN
 * @create 2020-06-11 0:45
 */
public class IsBalanced {
    public static void main(String[] args) {
        TreeNode p = new TreeNode (3);
        TreeNode node2 = new TreeNode (9);
        TreeNode node3 = new TreeNode (20);
        p.left=node2;
        p.right=node3;

        TreeNode node4 = new TreeNode (15);
        TreeNode node5 = new TreeNode (7);
        node3.left=node4;
        node3.right=node5;
        long start =System.currentTimeMillis ();
        System.out.println (isBalanced(p));
        long end =System.currentTimeMillis ();
        System.out.println ("total:"+(end-start));
    }
    public static boolean isBalanced(TreeNode root) {
        return  depth (root)!=-1;
    }
    private static int depth(TreeNode root) {
        if (root == null) return 0;
        int leftLevel =depth (root.left);
        if(leftLevel == -1) return -1;
        int rightLevel=depth (root.right);
        if(rightLevel == -1) return -1;
        return Math.abs(leftLevel - rightLevel)<2?Math.max (leftLevel,rightLevel)+1:-1;
    }
}
