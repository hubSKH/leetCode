package leetcode.tree;

import assit.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 94. 二叉树的中序遍历
 * @Description
 * 给定一个二叉树，返回它的中序 遍历。
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 *
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * @auther SHENKAIHUAN
 * @create 2019-10-27 3:58
 */
public class BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        TreeNode p = new TreeNode (1);
        TreeNode node2 = new TreeNode (2);
        TreeNode node3 = new TreeNode (3);
        p.right=node2;
        node2.left=node3;

        long start =System.currentTimeMillis ();
        List<Integer> result= inorderTraversal(p);
        long end =System.currentTimeMillis ();
        System.out.println ("total:"+(end-start));
        for (Integer num : result){
            System.out.print (num +", ");
        }
        System.out.println ();
    }

    public static List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> result =new ArrayList<> ();
        inorderTraversal(root,result);
        return result;
    }

    private static void inorderTraversal(TreeNode p, List<Integer> result) {
        if (p==null){
            return;
        }
        inorderTraversal (p.left,result);
        result.add (p.val);
        inorderTraversal (p.right,result);
        return;
    }
}
