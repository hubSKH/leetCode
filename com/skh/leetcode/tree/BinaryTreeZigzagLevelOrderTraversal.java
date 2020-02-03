package leetcode.tree;

import assit.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 103. 二叉树的锯齿形层次遍历
 * @Description
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（
 * 即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *      3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回锯齿形层次遍历如下：
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 * @auther SHENKAIHUAN
 * @create 2020-02-02 22:34
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode node13 =new TreeNode (3);
        TreeNode node29 =new TreeNode (9);
        TreeNode node220 =new TreeNode (20);
        TreeNode node315 =new TreeNode (15);
        TreeNode node37 =new TreeNode (7);

        node13.left=node29;
        node13.right=node220;
        node220.left=node315;
        node220.right=node37;

        TreeNode node = new TreeNode (1);
        node.left=new TreeNode (2);
        long start =System.currentTimeMillis ();
        List<List<Integer>> lists = zigzagLevelOrder (node);
        long end =System.currentTimeMillis ();
        for (List<Integer> integers : lists){
            System.out.print ("[");
            for (Integer integer : integers){
                System.out.print(integer+",");
            }
            System.out.println ("]");
        }
        System.out.println ("total:"+(end-start));
    }
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<> ();
        if(root == null) return result;
        List<TreeNode> children = Arrays.asList (root);
        boolean isResver =false;
        while (children !=null){
            List<TreeNode> sonList = null;
            List<Integer> rowResult = new ArrayList<> (children.size ()*2);
            for (int i=children.size ()-1;i>=0;i--){
                TreeNode node = children.get (i);
                rowResult.add (node.val);
                if(node.left ==null && node.right==null) continue;
                if(sonList ==null) sonList=new ArrayList<> ();
                if(isResver){
                    if(node.right !=null) sonList.add (node.right);
                    if(node.left !=null) sonList.add (node.left);
                }else {
                    if(node.left !=null) sonList.add (node.left);
                    if(node.right !=null) sonList.add (node.right);
                }
            }
            isResver = !isResver;
            result.add (rowResult);
            children=sonList;
        }
        return  result;
    }
}
