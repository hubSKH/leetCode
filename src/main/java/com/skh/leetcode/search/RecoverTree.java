package leetcode.search;

import assit.TreeBuilder;
import assit.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 99. 恢复二叉搜索树
 *
 * @Description 给你二叉搜索树的根节点 root ，该树中的两个节点的值被错误地交换。请在不改变其结构的情况下，恢复这棵树。
 * <p>
 * 输入：root = [3,1,4,null,null,2]
 * 输出：[2,1,4,null,null,3]
 * 解释：2 不能在 3 的右子树中，因为 2 < 3 。交换 2 和 3 使二叉搜索树有效。
 * @auther SHENKAIHUAN
 * @create 2021-12-30 14:37
 */
public class RecoverTree {
    public static void main(String[] args) {
        Integer[] values = new Integer[]{3, 1, 4, null, null, 2};
        TreeNode root = TreeBuilder.buildTree (values);
        new RecoverTree ().recoverTree (root);
        System.out.println ();
    }

    public void recoverTree(TreeNode root) {
        List<TreeNode> treeNodeList = new ArrayList<> ();
        inorder (root, treeNodeList);
        TreeNode x = null, y = null;
        for (int i = 0; i < treeNodeList.size () - 1; i++) {
            if (treeNodeList.get (i).val > treeNodeList.get (i + 1).val) {
                y = treeNodeList.get (i + 1);
                if (x == null) {
                    x = treeNodeList.get (i);
                    break;
                }
            }
        }
        int tmp = x.val;
        x.val = y.val;
        y.val = tmp;
    }

    private void inorder(TreeNode root, List<TreeNode> treeNodeList) {
        if (root == null) return;
        inorder (root.left, treeNodeList);
        treeNodeList.add (root);
        inorder (root.right, treeNodeList);
    }
}
