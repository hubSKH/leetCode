package audition;

/**
 * 面试题04. 二维数组中的查找
 * @Description
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，
 * 输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * 现有矩阵 matrix 如下：
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 * 给定 target = 20，返回 false。
 * 限制：
 * 0 <= n <= 1000
 * 0 <= m <= 1000
 *
 * @auther SHENKAIHUAN
 * @create 2020-02-15 22:55
 */
public class SearchInMatrix {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        int tartget=20;
        long start =System.currentTimeMillis ();
        System.out.println (findNumberIn2DArray(matrix,tartget));
        long end =System.currentTimeMillis ();
        System.out.println ("total:"+(end-start));

    }

    /*public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix.length==0||matrix[0].length==0) return false;
        for(int row=0;row<matrix.length;row++){
            if(matrix[row][0] >target){
                return false;
            }else if(matrix[row][0] ==target){
                return true;
            }
            for (int col = 1;col<matrix[0].length;col++){
                if(matrix[row][col] >target){
                    continue;
                }else if(matrix[row][col] ==target){
                    return true;
                }
            }
        }
        return  false;
    }*/
    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix.length==0) return false;
        int row = matrix.length;
        int col = matrix[0].length;
        int i=0,j=col-1;
        while (i<row && j>=0){
            if(matrix[i][j]<target){
                i++;
            }else if(matrix[i][j]==target){
                return true;
            }else {
                j--;
            }
        }
        return false;
    }

}
