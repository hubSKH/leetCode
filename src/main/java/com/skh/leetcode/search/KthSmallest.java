package leetcode.search;

import assit.TreeBuilder;
import assit.TreeNode;

import java.util.LinkedList;

/**
 * 230. 二叉搜索树中第K小的元素
 *
 * @Description 输入：root = [3,1,4,null,2], k = 1
 * 输出：1
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 * @auther SHENKAIHUAN
 * @create 2021-12-28 8:45
 */
public class KthSmallest {
    public static void main(String[] args) {
        Integer[] values = new Integer[]{5, 3, 6, 2, 4, null, null, 1};
        TreeNode root = TreeBuilder.buildTree (values);
        int k = 3;
        System.out.println (new KthSmallest ().kthSmallest (root, k));
    }

    public int kthSmallest(TreeNode root, int k) {
        LinkedList<TreeNode> treeNodeList = new LinkedList<> ();
        kthSmallest (root, treeNodeList);
        return treeNodeList.get (k - 1).val;
    }

    private void kthSmallest(TreeNode root, LinkedList<TreeNode> treeNodeList) {
        if (root == null) return;
        kthSmallest (root.left, treeNodeList);
        treeNodeList.addLast (root);
        kthSmallest (root.right, treeNodeList);
    }
}
