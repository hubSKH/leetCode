package leetcode.array;

import java.util.HashSet;
import java.util.Set;

/**
 * 73. 矩阵置零
 * @Description
 * 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。
 * 请使用原地算法。
 *
 * 输入:
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * 输出:
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 * @auther SHENKAIHUAN
 * @create 2019-08-18 10:16
 */
public class SetMatrixZeroes {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {0,1,2,0},
                {3,4,5,2},
                {1,3,1,5}
        };
        System.out.println ("===============before===========");
        for(int[] row : matrix){
            for (int col : row){
                System.out.print (col+", ");
            }
            System.out.println ();
        }
        System.out.println ();
        long start = System.currentTimeMillis ();
        setZeroes (matrix);
        long end = System.currentTimeMillis ();
        System.out.println ("total:"+(end-start));
        System.out.println ("===============after===========");
        for(int[] row : matrix){
            for (int col : row){
                System.out.print (col+", ");
            }
            System.out.println ();
        }
        System.out.println ();
    }

    //记录 赋值
    public static void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        Set<Integer> rowSet = new HashSet<> (rows);
        Set<Integer> colSet = new HashSet<> (cols);
        for(int i = 0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(matrix[i][j]==0){
                    //记录为0 的横纵坐标
                    rowSet.add (i);
                    colSet.add (j);
                }
            }
        }
        //设置 0
        for(int row : rowSet){
            for(int j = 0;j<cols;j++){
                matrix[row][j]=0;
            }
        }
        for(int col: colSet){
            for(int i=0;i<rows;i++){
                matrix[i][col]=0;
            }
        }
    }
}
