package audition;

import assit.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 面试题34. 二叉树中和为某一值的路径
 * @Description
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。
 * 从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 *
 * 给定如下二叉树，以及目标和 sum = 22，
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 * @auther SHENKAIHUAN
 * @create 2020-05-01 16:36
 */
public class PathSum {
    public static void main(String[] args) {
        TreeNode root = new TreeNode (5);
        root.left=new TreeNode (4);
        root.left.left=new TreeNode (11);
        root.left.left.left=new TreeNode (7);
        root.left.left.right=new TreeNode (2);
        root.right=new TreeNode (8);
        root.right.left=new TreeNode (13);
        root.right.right=new TreeNode (4);
        root.right.right.left=new TreeNode (5);
        root.right.right.right=new TreeNode (1);

        int pathSum=22;
        long start =System.currentTimeMillis ();
        List<List<Integer>> lists = pathSum (root, pathSum);
        long end =System.currentTimeMillis ();
        System.out.println ("total:"+(end-start));

    }
    public static List<List<Integer>> pathSum(TreeNode root, int sum) {

        LinkedList<List<Integer>> result =new LinkedList<> ();
        LinkedList<Integer> path =new LinkedList<> ();
        rec(root,sum,result,path);
        return result;

    }

    private static void rec(TreeNode root, int sum, LinkedList<List<Integer>> result, LinkedList<Integer> path) {
        if(root==null) return;
        path.add (root.val);
        sum-=root.val;
        if(sum==0 && root.left==null && root.right==null) result.add (new LinkedList<> (path));
        rec (root.left,sum,result,path);
        rec (root.right,sum,result,path);
        path.removeLast ();

    }
}
