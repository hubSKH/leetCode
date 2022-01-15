package leetcode.tree;

import assit.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 145. 二叉树的后序遍历
 * @Description
 * 给定一个二叉树，返回它的 后序 遍历。
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [3,2,1]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * @auther SHENKAIHUAN
 * @create 2019-10-27 13:25
 */
public class BinaryTreePostorderTraversal {
    public static void main(String[] args) {
        TreeNode p = new TreeNode (1);
        TreeNode node2 = new TreeNode (2);
        TreeNode node3 = new TreeNode (3);
        p.right=node2;
        node2.left=node3;

        long start =System.currentTimeMillis ();
        List<Integer> result= postorderTraversal(p);
        long end =System.currentTimeMillis ();
        System.out.println ("total:"+(end-start));
        for (Integer num : result){
            System.out.print (num +", ");
        }
        System.out.println ();
    }

    public static List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> result =new ArrayList<> ();
        postorderTraversal(root,result);
        return result;
    }

    private static void postorderTraversal(TreeNode p, List<Integer> result) {
        if (p==null){
            return;
        }
        postorderTraversal (p.left,result);
        postorderTraversal (p.right,result);
        result.add (p.val);
    }
}
