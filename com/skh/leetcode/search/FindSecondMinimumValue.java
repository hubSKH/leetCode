package leetcode.search;

import assit.TreeBuilder;
import assit.TreeNode;

/**
 * 671. 二叉树中第二小的节点
 *
 * @Description 给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。
 * 如果一个节点有两个子节点的话，那么该节点的值等于两个子节点中较小的一个。
 * 更正式地说，root.val = min(root.left.val, root.right.val) 总成立。
 * 给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。
 * <p>
 * 输入：root = [2,2,5,null,null,5,7]
 * 输出：5
 * 解释：最小的值是 2 ，第二小的值是 5 。
 * @auther SHENKAIHUAN
 * @create 2022-01-01 14:02
 */
public class FindSecondMinimumValue {
    public static void main(String[] args) {
        Integer[] values = new Integer[]{2, 2, 5, null, null, 5, 7};
        TreeNode root = TreeBuilder.buildTree (values);
        System.out.println (new FindSecondMinimumValue ().findSecondMinimumValue (root));
    }

    public int findSecondMinimumValue(TreeNode root) {
        dfs (root, root.val);
        return result;
    }

    int result = -1;
    private void dfs(TreeNode node, int rootVal) {
        if (node == null) return;
        if (result != -1 && node.val >= result) return;
        if (node.val > rootVal) result = node.val;
        dfs (node.left, rootVal);
        dfs (node.right, rootVal);
    }
}
