package leetcode.tree;

import assit.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 113. 路径总和 II
 * @Description
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * 说明: 叶子节点是指没有子节点的节点。
 *
 *  示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *              5
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
 * @create 2020-02-10 10:31
 */
public class PathSumII {
    public static void main(String[] args) throws CloneNotSupportedException {
        int sum = 22;
        TreeNode root = new TreeNode (5);
        TreeNode node41 = new TreeNode (4);
        TreeNode node8 = new TreeNode (8);
        TreeNode node11 = new TreeNode (11);
        TreeNode node13 = new TreeNode (13);
        TreeNode node4 = new TreeNode (4);
        TreeNode node7= new TreeNode (7);
        TreeNode node2 = new TreeNode (2);
        TreeNode node5 = new TreeNode (5);
        TreeNode node1 = new TreeNode (1);

        root.left=node41;
        root.right=node8;
        node41.left=node11;
        node8.left=node13;
        node8.right=node4;
        node11.left=node7;
        node11.right=node2;
        node4.left=node5;
        node4.right=node1;

        long start =System.currentTimeMillis ();
        List<List<Integer>> lists = pathSum (root, sum);
        long end =System.currentTimeMillis ();

        for (List<Integer> list :lists){
            for (Integer integer: list){
                System.out.print(integer +",");
            }
            System.out.println ();
        }
        System.out.println ("total:"+(end-start));
    }
    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<> ();
        pathSum (root,sum,result,new ArrayList<> ());
        return result;
    }

    private static void pathSum(TreeNode root, int sum, List<List<Integer>> result,List<Integer> path) {
        if(root==null) return;

        path.add (root.val);
        int sub = sum-root.val;
        if(root.left==null && root.right==null && sub==0){
            result.add (new ArrayList<> (path));
        }
        pathSum (root.left, sub, result, path);
        pathSum (root.right, sub, result, path);
        path.remove (path.size ()-1);
    }

}
