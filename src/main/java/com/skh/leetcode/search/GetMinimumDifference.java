package leetcode.search;

import assit.TreeBuilder;
import assit.TreeNode;

/**
 * 530. 二叉搜索树的最小绝对差
 *
 * @Description 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 * 差值是一个正数，其数值等于两值之差的绝对值。
 * <p>
 * 输入：root = [4,2,6,1,3]
 * 输出：1
 * @auther SHENKAIHUAN
 * @create 2022-01-04 19:20
 */
public class GetMinimumDifference {
    public static void main(String[] args) {
        Integer[] values = new Integer[]{236,104,701,null,227,null,911};
        TreeNode root = TreeBuilder.buildTree (values);
        System.out.println (new GetMinimumDifference ().getMinimumDifference (root));
    }

    public int getMinimumDifference(TreeNode root) {
        dfs (root);
        return result;
    }

    int preVal =-1;
    int result =Integer.MAX_VALUE;
    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        if(preVal!=-1){
            result=Math.min (result, root.val-preVal);
        }
        preVal=root.val;
        dfs (root.right);
    }
}
