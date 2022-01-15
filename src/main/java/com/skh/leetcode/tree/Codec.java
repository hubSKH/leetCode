package leetcode.tree;

import assit.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 297. 二叉树的序列化与反序列化
 *
 * @Description 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 * 提示: 输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 * <p>
 * 输入：root = [1,2,3,null,null,4,5]
 * 输出：[1,2,3,null,null,4,5]
 * @auther SHENKAIHUAN
 * @create 2021-05-05 15:08
 */
public class Codec {
    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        if (root == null) return "[]";
        Queue<TreeNode> queue = new LinkedList<> ();
        queue.add (root);
        StringBuilder sb = new StringBuilder ("[");
        while (!queue.isEmpty ()) {
            TreeNode poll = queue.poll ();
            if (poll != null) {
                sb.append (poll.val);
                queue.add (poll.left);
                queue.add (poll.right);
            } else {
                sb.append ("null");
            }
            sb.append (",");
        }
        sb.deleteCharAt (sb.length () - 1);
        sb.append ("]");
        return sb.toString ();
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if (data.equals ("[]")) return null;
        String substring = data.substring (1, data.length () - 1);
        String[] strs = substring.split (",");
        TreeNode root = new TreeNode (Integer.valueOf (strs[0]));
        Queue<TreeNode> queue = new LinkedList<> ();
        queue.add (root);
        int idx = 1;

        while (idx < strs.length) {
            TreeNode poll = queue.poll ();
            if (!strs[idx].equals ("null")) {
                TreeNode left = new TreeNode (Integer.valueOf (strs[idx]));
                poll.left = left;
                queue.add (left);
            }
            idx++;
            if (!strs[idx].equals ("null")) {
                TreeNode right = new TreeNode (Integer.valueOf (strs[idx]));
                poll.right = right;
                queue.add (right);
            }
            idx++;
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode (1);
        Codec ser = new Codec ();
        Codec deser = new Codec ();
        String serialize = ser.serialize (root);
        System.out.println (serialize);
        TreeNode ans = deser.deserialize (serialize);
        System.out.println ();
    }
}
