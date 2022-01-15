package leetcode.tree;

import assit.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 257. 二叉树的所有路径
 * @Description
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * 说明: 叶子节点是指没有子节点的节点。
 * 示例:
 * 输入:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 * 输出: ["1->2->5", "1->3"]
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 *
 * @auther SHENKAIHUAN
 * @create 2020-01-31 22:38
 */
public class BinaryTreePaths {
    public static void main(String[] args) {
        TreeNode node11 =new TreeNode (1);
        TreeNode node22 =new TreeNode (2);
        TreeNode node23 =new TreeNode (3);
        TreeNode node35 =new TreeNode (5);

        node11.left=node22;
        node11.right=node23;
        node22.left=new TreeNode (4);
        node22.right=node35;
        long start =System.currentTimeMillis ();
        List<String> strings = binaryTreePaths (node11);
        long end =System.currentTimeMillis ();
        for (String str :strings){
            System.out.println (str);
        }
        System.out.println ("total:"+(end-start));
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<> ();
        binaryTreePaths (root,"",result);
        return  result;
    }

    private static void binaryTreePaths(TreeNode root,String sb, List<String> result) {
        if(root==null) {
            return;
        }
        if(sb.length () !=0){
            sb+="->";
        }
        sb+=root.val;
        if(root.left==null && root.right==null){
            result.add (sb);
        }else {
            binaryTreePaths (root.left,sb,result);
            binaryTreePaths (root.right,sb,result);
        }
    }
}
