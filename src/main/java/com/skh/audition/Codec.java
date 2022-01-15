package audition;

import assit.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 面试题37. 序列化二叉树
 * @Description
 * 请实现两个函数，分别用来序列化和反序列化二叉树。
 *
 * 你可以将以下二叉树：
 *
 *     1
 *    / \
 *   2   3
 *      / \
 *     4   5
 *
 * 序列化为 "[1,2,3,null,null,4,5]"
 * @auther SHENKAIHUAN
 * @create 2020-05-03 13:38
 */
public class Codec {

    public static void main(String[] args) {
        TreeNode root = new TreeNode (1);
        root.left = new TreeNode (2);
        root.right =new TreeNode (3);
        root.right.left =new TreeNode (4);
        root.right.right= new TreeNode (5);
        long start = System.currentTimeMillis ();
        String toString = serialize (root);
        toString = "[]";
        TreeNode treeNode = deserialize (toString);
        long end =System.currentTimeMillis ();
        System.out.println ("total:"+(end-start));
    }

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        if(root==null) return "[]";
        Queue<TreeNode> queue=new LinkedList<> ();
        queue.add (root);
        StringBuilder sb = new StringBuilder ("[");
        while (!queue.isEmpty ()){
            TreeNode poll = queue.poll ();
            if(poll!=null){
                sb.append (poll.val);
                queue.add (poll.left);
                queue.add(poll.right);
            }else {
                sb.append ("null");
            }
            sb.append (",");
        }
        sb.deleteCharAt (sb.length ()-1);
        sb.append ("]");
        return sb.toString ();
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if(data.equals ("[]")) return null;
        String substring = data.substring (1, data.length ()-1);
        String[] strs = substring.split (",");
        TreeNode root = new TreeNode (Integer.valueOf (strs[0]));
        Queue<TreeNode> queue =new LinkedList<> ();
        queue.add (root);
        int idx =1;

        while (idx<strs.length){
            TreeNode poll = queue.poll ();
            if(!strs[idx].equals ("null")){
                TreeNode left =new TreeNode (Integer.valueOf (strs[idx]));
                poll.left=left;
                queue.add(left);
            }
            idx++;
            if(!strs[idx].equals ("null")){
                TreeNode right =new TreeNode (Integer.valueOf (strs[idx]));
                poll.right=right;
                queue.add(right);
            }
            idx++;
        }
        return  root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
