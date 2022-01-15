package audition;

import assit.TreeNode;

/**
 * 面试题54. 二叉搜索树的第k大节点
 * @Description
 * 给定一棵二叉搜索树，请找出其中第k大的节点。
 *
 * 输入: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * 输出: 4
 *
 * @auther SHENKAIHUAN
 * @create 2020-06-07 17:04
 */
public class KthLargest {
    public static void main(String[] args) {
        TreeNode root=new TreeNode (3);
        root.left=new TreeNode (1);
        root.left.right=new TreeNode (2);
        root.right=new TreeNode (4);
        int k=1;
        System.out.println (kthLargest (root,k));

    }

    static int p;
    static int res;
    public static int kthLargest(TreeNode root, int k) {
        p=k;
        reDFS(root);
        return res;
    }

    private static void reDFS(TreeNode root) {
        if(root==null) return;
        reDFS (root.right);
        if(p==0) return ;
        else if(--p == 0) res= root.val;
        reDFS (root.left);
    }
}
