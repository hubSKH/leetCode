package leetcode.tree;

import assit.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 107. 二叉树的层次遍历 II
 * @Description
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。
 * （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *  返回其自底向上的层次遍历为：
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 * @auther SHENKAIHUAN
 * @create 2020-02-05 11:05
 */
public class BinaryTreeLevelOrderTraversalII {
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
        List<List<Integer>> result= levelOrderBottom(p);
        long end =System.currentTimeMillis ();
        System.out.println ("total:"+(end-start));
        for (List<Integer> level :result){
            for (Integer num : level){
                System.out.print (num+", ");
            }
            System.out.println ();
        }
        System.out.println ();
    }

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root ==null){
            return new LinkedList<> ();
        }
        Deque<TreeNode> queue = new LinkedList<> ();
        queue.add (root);
        List<List<Integer>> result =new ArrayList<> ();
        levelOrderBottom (queue,result);
        return result;
    }

    private static void levelOrderBottom(Deque<TreeNode> queue, List<List<Integer>> result) {
        if(queue.isEmpty ()) return;
        int count =queue.size ();
        List<Integer> level = new ArrayList<> (count);
        for(int i = 0;i<count;i++){
            TreeNode treeNode = queue.removeFirst ();
            level.add (treeNode.val);
            if(treeNode.left !=null){
                queue.addLast (treeNode.left);
            }
            if(treeNode.right !=null){
                queue.add (treeNode.right);
            }
        }
        levelOrderBottom (queue,result);
        result.add (level);
    }

}
