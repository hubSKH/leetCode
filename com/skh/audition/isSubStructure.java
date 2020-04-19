package audition;

import assit.TreeNode;

/**
 * 面试题26. 树的子结构
 * @Description
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 *
 * 例如:
 * 给定的树 A:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 *  给定的树 B：
 *
 *    4
 *   /
 *  1
 *  返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
 * @auther SHENKAIHUAN
 * @create 2020-04-19 22:19
 */
public class isSubStructure {
    public static void main(String[] args) {
        TreeNode root = new TreeNode (3);
        root.left=new TreeNode (4);
        root.right = new TreeNode (5);
        root.left.left= new TreeNode (1);
        root.left.right =new TreeNode (2);

        TreeNode node = new TreeNode (4);
        node.left =new TreeNode (1);
        long start = System.currentTimeMillis ();
        System.out.println (isSubStructure(root,node));
        long end = System.currentTimeMillis ();
        System.out.println ("total:"+(end-start));

    }
    public static boolean isSubStructure(TreeNode A, TreeNode B) {

        return (A!=null&& B!=null)&&( recu(A,B) || isSubStructure (A.left,B) || isSubStructure (A.right,B));
    }

    private static boolean recu(TreeNode A, TreeNode B) {
        if(B==null) return true;
        if(A==null ||A.val!=B.val) return false;
        return recu (A.left,B.left) && recu (A.right,B.right);
    }
}
