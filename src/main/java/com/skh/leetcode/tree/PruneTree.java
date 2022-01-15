package leetcode.tree;

import assit.TreeNode;

/**
 * 814. 二叉树剪枝
 *
 * @Description 给你二叉树的根结点 root ，此外树的每个结点的值要么是 0 ，要么是 1 。
 * 返回移除了所有不包含 1 的子树的原二叉树。
 * 节点 node 的子树为 node 本身加上所有 node 的后代。
 * <p>
 * 输入：root = [1,null,0,0,1]
 * 输出：[1,null,0,null,1]
 * 解释：
 * 只有红色节点满足条件“所有不包含 1 的子树”。 右图为返回的答案。
 * @auther SHENKAIHUAN
 * @create 2021-12-27 20:12
 */
public class PruneTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode (1);
        root.right = new TreeNode (0);
        root.right.left = new TreeNode (0);
        root.right.right = new TreeNode (1);

        root.left = new TreeNode (0);
        root.left.left = new TreeNode (0);
        root.left.right = new TreeNode (0);
        TreeNode treeNode = new PruneTree ().pruneTree (root);
        System.out.println (treeNode);
    }

    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        root.left = pruneTree (root.left);
        root.right = pruneTree (root.right);
        if (root.left == null && root.right == null && root.val == 0) {
            return null;
        }
        return root;
    }

}
