package leetcode.search;

import assit.TreeBuilder;
import assit.TreeNode;

/**
 * 129. 求根节点到叶节点数字之和
 * @Description
 * 给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
 * 每条从根节点到叶节点的路径都代表一个数字：
 * 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
 * 计算从根节点到叶节点生成的 所有数字之和 。
 * 叶节点 是指没有子节点的节点。
 *
 * 输入：root = [1,2,3]
 * 输出：25
 * 解释：
 * 从根到叶子节点路径 1->2 代表数字 12
 * 从根到叶子节点路径 1->3 代表数字 13
 * 因此，数字总和 = 12 + 13 = 25
 * @auther SHENKAIHUAN
 * @create 2022-01-03 16:41
 */
public class SumNumbers {
    public static void main(String[] args) {
        Integer[] values =new Integer[]{4,9,0,5,1};
        TreeNode root = TreeBuilder.buildTree (values);
        System.out.println (new SumNumbers ().sumNumbers (root));

    }

    public int sumNumbers(TreeNode root) {
        return sumNumbers (root,0);
    }

    private int sumNumbers(TreeNode root,  int preSum) {
        if(root==null){
            return 0;
        }
        preSum=preSum*10+root.val;
        if(root.left==null && root.right==null){
            return preSum;
        }
        return sumNumbers (root.left,preSum)+sumNumbers (root.right,  preSum);
    }
}
