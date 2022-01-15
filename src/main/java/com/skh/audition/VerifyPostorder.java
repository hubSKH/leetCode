package audition;

/**
 * 面试题33. 二叉搜索树的后序遍历序列
 * @Description
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。
 * 如果是则返回 true，否则返回 false。
 * 假设输入的数组的任意两个数字都互不相同。
 *
 * 参考以下这颗二叉搜索树：
 *      5
 *     / \
 *    2   6
 *   / \
 *  1   3
 * @auther SHENKAIHUAN
 * @create 2020-04-30 0:36
 */
public class VerifyPostorder {
    public static void main(String[] args) {
        int[] postorder =new int[]{1,6,3,2,5};
        long stsrt =System.currentTimeMillis ();
        System.out.println (verifyPostorder(postorder));
        long end =System.currentTimeMillis ();
        System.out.println ("total:"+(end-stsrt));
    }
    public static boolean verifyPostorder(int[] postorder) {

        return rec(postorder,0,postorder.length-1);

    }

    private static boolean rec(int[] postorder, int i, int j) {
        if(i>=j)return true;
        int p=i;
        //左子树
        while (postorder[p]<postorder[j]) p++;
        int m=p;
        //右子树
        while (postorder[p]>postorder[j]) p++;
        return p==j && rec (postorder,i,m-1) && rec (postorder,m,j-1);
    }
}
