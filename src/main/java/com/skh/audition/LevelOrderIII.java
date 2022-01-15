package audition;

import assit.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 面试题32 - III. 从上到下打印二叉树 III
 * @Description
 * 请实现一个函数按照之字形顺序打印二叉树，
 * 即第一行按照从左到右的顺序打印
 * ，第二层按照从右到左的顺序打印，
 * 第三行再按照从左到右的顺序打印，
 * 其他行以此类推。
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 * @auther SHENKAIHUAN
 * @create 2020-04-25 15:55
 */
public class LevelOrderIII {
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
        List<List<Integer>> result= levelOrder(p);
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
    public static List<List<Integer>> levelOrder(TreeNode root) {
        if(root ==null){
            return new ArrayList<> ();
        }
        Deque<TreeNode> queue = new LinkedList<> ();
        queue.add (root);
        List<List<Integer>> result =new ArrayList<> ();
        while (!queue.isEmpty ()){
            int count =queue.size ();
            LinkedList<Integer> level = new LinkedList<> ();
            for (int i = 0; i < count; i++) {
                TreeNode treeNode = queue.poll ();
                if ((result.size () & 1) == 0) level.addLast (treeNode.val);
                else level.addFirst (treeNode.val);
                if (treeNode.left != null) queue.addLast (treeNode.left);
                if (treeNode.right != null) queue.add (treeNode.right);
            }
            result.add (level);
        }
        return result;
    }
}
