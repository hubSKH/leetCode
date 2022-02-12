package leetcode.search;

import assit.TreeBuilder;
import assit.TreeNode;

/**
 * 606. 根据二叉树创建字符串
 * 你需要采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串。
 * 空节点则用一对空括号 "()" 表示。而且你需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。
 * <p>
 * 输入: 二叉树: [1,2,3,4]
 * 1
 * /   \
 * 2     3
 * /
 * 4
 * <p>
 * 输出: "1(2(4))(3)"
 * <p>
 * 解释: 原本将是“1(2(4)())(3())”，
 * 在你省略所有不必要的空括号对之后，
 * 它将是“1(2(4))(3)”。
 *
 * @auther SHENKAIHUAN
 * @create 2022/2/12 16:59
 */
public class Tree2Str {
    public static void main(String[] args) {
        Integer[] values = new Integer[]{1, 2, 3, null, 4};
        TreeNode root = TreeBuilder.buildTree(values);
        System.out.println(new Tree2Str().tree2str(root));
    }

    public String tree2str(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        tree2str(root, sb);
        return sb.toString();
    }

    private void tree2str(TreeNode root, StringBuilder sb) {
        if (root == null) return;
        sb.append(root.val);
        if (root.left != null || root.right != null) {
            sb.append('(');
            tree2str(root.left, sb);
            sb.append(')');
        }
        if (root.right != null) {
            sb.append('(');
            tree2str(root.right, sb);
            sb.append(')');
        }
    }
}
