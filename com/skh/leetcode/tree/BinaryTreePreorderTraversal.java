package leetcode.tree;

import assit.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 144. 二叉树的前序遍历
 * @Description
 * 给定一个二叉树，返回它的 前序 遍历。
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,2,3]
 *
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * @auther SHENKAIHUAN
 * @create 2019-10-27 11:11
 */
public class BinaryTreePreorderTraversal {
    public static void main(String[] args) {
        TreeNode p = new TreeNode (1);
        TreeNode node2 = new TreeNode (2);
        TreeNode node3 = new TreeNode (3);
        p.right=node2;
        node2.left=node3;

        long start =System.currentTimeMillis ();
        List<Integer> result= preorderTraversal(p);
        long end =System.currentTimeMillis ();
        System.out.println ("total:"+(end-start));
        for (Integer num : result){
            System.out.print (num +", ");
        }
        System.out.println ();
    }

    public static List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> result =new ArrayList<> ();
        preorderTraversal(root,result);
        return result;
    }

    private static void preorderTraversal(TreeNode p, List<Integer> result) {
        if (p==null){
            return;
        }
        result.add (p.val);
        preorderTraversal (p.left,result);
        preorderTraversal (p.right,result);
    }
}
