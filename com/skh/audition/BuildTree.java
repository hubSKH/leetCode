package audition;

import assit.TreeNode;

import java.util.Base64;

/**
 * 面试题07. 重建二叉树
 * @Description
 * 输入某二叉树的前序遍历和中序遍历的结果，
 * 请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * @auther SHENKAIHUAN
 * @create 2020-02-19 23:58
 */
public class BuildTree {
    public static void main(String[] args) {

        int[] preorder =new int[]{3,1,2,4};
        int[] inorder= new int[]{1,2,3,4};
        long start =System.currentTimeMillis ();
        TreeNode root = buildTree(preorder,inorder);
        long end =System.currentTimeMillis ();
        System.out.println ("total:"+(end-start));

    }
    public static TreeNode buildTree(int[] preorder, int[] inorder) {

        if (preorder==null||preorder.length==0) return null;
        return buildTree (preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }

    public static TreeNode buildTree(int[] preorder,int preStrart,int preEnd, int[] inorder,int inStart,int inEnd) {
        if(preEnd<preStrart||inEnd<inStart) return null;
        if(preEnd==preStrart||inEnd==inStart) return new TreeNode (preorder[preStrart]);
        int rootValue = preorder[preStrart];
        TreeNode root= new TreeNode (rootValue);
        int leftCount =0;
        for(int rootIdxInInor=inStart;rootIdxInInor<=inEnd;rootIdxInInor++){
            if(inorder[rootIdxInInor]==rootValue){
                break;
            }
            leftCount++;
        }
        root.left=buildTree (preorder,preStrart+1,preStrart+leftCount,inorder,inStart,inStart+leftCount-1);
        root.right=buildTree (preorder,preStrart+leftCount+1,preEnd,inorder,inStart+leftCount+1,inEnd);
        return root;
    }
}
