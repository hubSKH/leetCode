package audition;

import assit.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 面试题32 - II. 从上到下打印二叉树 II
 * @Description
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 * @auther SHENKAIHUAN
 * @create 2020-04-25 15:55
 */
public class LevelOrderII {
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
            result.add (level);
        }
        return result;
    }
}
