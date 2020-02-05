package leetcode.dynamic;

/**
 * 62. 不同路径
 * @Description
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 例如，上图是一个7 x 3 的网格。有多少可能的路径？
 * 说明：m 和 n 的值均不超过 100。
 *
 * 输入: m = 3, n = 2
 * 输出: 3
 * 解释:
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向右 -> 向下
 * 2. 向右 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向右
 *
 * 输入: m = 7, n = 3
 * 输出: 28
 * @auther SHENKAIHUAN
 * @create 2020-02-05 17:28
 */
public class UniquePaths {
    public static void main(String[] args) {
        int m=3;
        int n=3;
        long start =System.currentTimeMillis ();
        System.out.println (uniquePaths(m,n));
        long end =System.currentTimeMillis ();
        System.out.println ("total:"+(end-start));
    }

    /**
     * 二维数组
     * @param m
     * @param n
     * @return
     */
   /* public static int uniquePaths(int m, int n) {
        int[][] matrix =new int[m][n];
        for(int row=0;row<m;row++){
            for (int col=0;col<n;col++){
                if(row==0||col==0) matrix[row][col]=1;
                else  matrix[row][col] = matrix[row-1][col]+matrix[row][col-1];
            }
        }
        return matrix[m-1][n-1];

    }*/

    public static int uniquePaths(int m, int n) {
        int[] arr = new int[n];
        for(int i=0;i<n;i++) arr[i]=1;
        for (int row =1;row<m;row++){
            for (int col=1;col<n;col++){
                arr[col] +=arr[col-1];
            }
        }
        return arr[n-1];
    }
}
