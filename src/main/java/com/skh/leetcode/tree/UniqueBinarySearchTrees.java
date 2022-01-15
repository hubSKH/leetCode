package leetcode.tree;

/**
 * 96. 不同的二叉搜索树
 * @Description
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 *
 * 输入: 3
 * 输出: 5
 * 解释:
 * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 * @auther SHENKAIHUAN
 * @create 2019-11-02 14:49
 */
public class UniqueBinarySearchTrees {

    public static void main(String[] args) {

        int n =4;
        long start =System.currentTimeMillis ();
        System.out.println (numTrees(n));
        long end =System.currentTimeMillis ();
        System.out.println ("total:"+(end-start));
    }
    public static int numTrees(int n) {
        int[] foo =new int[n+1];
        foo[0]=1;
        foo[1]=1;
        for(int i =2;i<= n;i++){
            for(int j=1;j<=i;j++){
                foo[i] =foo[i]+foo[j-1]*foo[i-j];
            }
        }
        return foo[n];

    }
}
