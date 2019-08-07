package leetcode.linkedList;

import assit.TreeNode;

/**
 * 653. 两数之和 IV - 输入 BST
 *
 * @Description 给定一个二叉搜索树和一个目标结果，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
 * <p>
 * 输入:
 * 5
 * / \
 * 3   6
 * / \   \
 * 2   4   7
 * <p>
 * Target = 9
 * <p>
 * 输出: True
 * @auther SHENKAIHUAN
 * @create 2019-08-06 23:29
 */
public class TwoSumIV {

    public static void main(String[] args) {
        TreeNode node5 = new TreeNode (5);
        TreeNode node3 = new TreeNode (3);
        TreeNode node6 = new TreeNode (6);
        TreeNode node2 = new TreeNode (2);
        TreeNode node4 = new TreeNode (4);
        TreeNode node7 = new TreeNode (7);
        node5.left = node3;
        node5.right = node6;
//        node3.left = node2;
//        node3.right = node4;
//        node6.right = node7;

        int target = 4;
        long start = System.currentTimeMillis ();
        System.out.println (findTarget (node5, target));
        long end = System.currentTimeMillis ();
        System.out.println ("total:" + (end - start));
    }

    public static boolean findTarget(TreeNode root, int k) {

        return findTarget (root, root, k);

    }

    private static boolean findTarget(TreeNode root, TreeNode val, int k) {
        if (val == null) {
            return false;
        }
        int target = k - val.val;
        if(root != val && target == root.val){
            return true;
        }
        TreeNode p = root;
        while (p.val !=target){
            if(target > p.val){
                p=p.right;
            }else{
                p=p.left;
            }
            if(p==null) {
                break;
            }
        }
        return findTarget (root,val.left,k) || findTarget (root,val.right,k)||(p!=null&&p!=val);
    }
}
