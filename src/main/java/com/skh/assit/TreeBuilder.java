package assit;

import java.util.LinkedList;

/**
 * @Description
 * @auther SHENKAIHUAN
 * @create 2021-05-03 15:01
 */
public class TreeBuilder {
    public static void main(String[] args) {
        //[4,-7,-3,null,null,-9,-3,9,-7,-4,null,6,null,-6,-6,null,null,0,6,5,null,9,null,null,-1,-4,null,null,null,-2]
        Integer[] integers =new Integer[]{4,-7,-3,null,null,-9,-3,9,-7,-4,null,6,null,-6,-6,null,null,0,6,5,null,9,null,null,-1,-4,null,null,null,-2};
        TreeNode root =buildTree(integers);
        System.out.println (root);
    }

    public static TreeNode buildTree(Integer[] integers) {
        LinkedList<TreeNode> treeNodes=new LinkedList<> ();
        TreeNode root = new TreeNode (integers[0]);
        treeNodes.addLast (root);
        int i=1;
        while (i<integers.length){
            TreeNode node = treeNodes.poll ();
            if(integers[i]!=null){
                TreeNode left = new TreeNode (integers[i]);
                node.left=left;
                treeNodes.addLast (left);
            }
            i++;
            if(i>=integers.length) break;
            if(integers[i]!=null){
                TreeNode right = new TreeNode (integers[i]);
                node.right=right;
                treeNodes.addLast (right);
            }
            i++;
        }
        return root;
    }
}
