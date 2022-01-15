package leetcode.tree;

import assit.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 95. 不同的二叉搜索树 II
 * @Description
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。
 * 示例:
 * 输入: 3
 * 输出:
 * [
 *   [1,null,3,2],
 *   [3,2,null,1],
 *   [3,1,null,null,2],
 *   [2,1,3],
 *   [1,null,2,null,3]
 * ]
 * 解释:
 * 以上的输出对应以下 5 种不同结构的二叉搜索树：
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 *
 * @auther SHENKAIHUAN
 * @create 2019-11-14 23:50
 */
public class UniqueBinarySearchTreesII {

    public static void main(String[] args) {

        int n =3;
        long start =System.currentTimeMillis ();
        System.out.println (generateTrees(n));
        long end =System.currentTimeMillis ();
        System.out.println ("total:"+(end-start));
    }
    public static List<TreeNode> generateTrees(int n) {
        if(n==0) return new LinkedList<> ();
        return generateTrees (1,n);
}

    private static LinkedList<TreeNode> generateTrees(int start, int end) {
        LinkedList<TreeNode> treeNodes =new LinkedList<> ();
        if(start > end){
            treeNodes.add (null);
            return treeNodes;
        }
        for(int i =start; i<= end;i++){
            LinkedList<TreeNode> leftTrees =generateTrees (start,i-1);
            LinkedList<TreeNode> rightTrees =generateTrees (i+1,end);

            for (TreeNode left :leftTrees){
                for (TreeNode right: rightTrees){
                    TreeNode node =new TreeNode (i);
                    node.left=left;
                    node.right=right;
                    treeNodes.add (node);
                }
            }
        }
        return treeNodes;
    }
}
