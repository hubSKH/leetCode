package audition;

import assit.TreeNode;

import java.util.*;

/**
 * 面试题32 - I. 从上到下打印二叉树
 * @Description
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回：
 * [3,9,20,15,7]
 * @auther SHENKAIHUAN
 * @create 2020-04-25 14:29
 */
public class LevelOrder {
    public static void main(String[] args) {
        TreeNode root =new TreeNode (3);
        root.left=new TreeNode (9);
        root.right=new TreeNode (20);
        root.right.left=new TreeNode (15);
        root.right.right=new TreeNode (7);
        long start=System.currentTimeMillis ();
        int[] x = levelOrder (root);
        long end=System.currentTimeMillis ();
        System.out.println ("total:"+(end-start));

    }
    public static int[] levelOrder(TreeNode root) {

        if(root ==null) return  new int[0];
        Queue<TreeNode> treeNodeDeque =new LinkedList<> ();
        List<Integer> resultList = new ArrayList<> ();
        treeNodeDeque.add (root);
        while (!treeNodeDeque.isEmpty ()){
            TreeNode treeNode=treeNodeDeque.poll ();
            resultList.add (treeNode.val);
            if(treeNode.left!=null) treeNodeDeque.add (treeNode.left);
            if(treeNode.right!=null) treeNodeDeque.add (treeNode.right);
        }
        int[] result=new int[resultList.size ()];
        for (int i=0;i<result.length;i++){
            result[i]=resultList.get (i);
        }
        return result;

    }
}
