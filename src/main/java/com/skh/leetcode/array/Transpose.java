package leetcode.array;

import java.util.Arrays;

/**
 * 867. 转置矩阵
 * @Description
 * 给定一个矩阵 A， 返回 A 的转置矩阵。
 * 矩阵的转置是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。
 * @auther SHENKAIHUAN
 *
 * 输入：[[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[[1,4,7],[2,5,8],[3,6,9]]
 * @create 2020-09-05 16:59
 */
public class Transpose {
    public static void main(String[] args) {
        int[][] nums = new int[][]{
                {1, 2,3},
                {4, 5,6},
         };
        int[][] transpose = transpose (nums);
        for (int[] a : transpose){
            System.out.println (Arrays.toString (a));
        }
        System.out.println ();

    }
    public static int[][] transpose(int[][] A) {
        int n= A.length;
        int m= A[0].length;
        int[][] result =new int[m][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                result[j][i]=A[i][j];
            }
        }
        return result;

    }
}
