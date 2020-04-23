package audition;

/**
 * 面试题29. 顺时针打印矩阵
 * @Description
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * @auther SHENKAIHUAN
 * @create 2020-04-23 0:03
 */
public class SpiralOrder {
    public static void main(String[] args) {
       int[][] matrix= new int[][]{
//               {1,2,3,4},
//               {5,6,7,8},
//               {9,10,11,12}
       };
//               new int[][]{
//               {1,2,3},
//               {4,5,6},
//               {7,8,9}
//        };
        long start=System.currentTimeMillis ();
        int[] ints = spiralOrder (matrix);
        long end=System.currentTimeMillis ();
        System.out.println ("total:"+(end-start));
    }
    public static int[] spiralOrder(int[][] matrix) {
        int row = matrix.length;
        if(row==0 )return new int[0];
        int col = matrix[0].length;
        int count =row*col;
        int[] result =new int[count];
        int r=0,c=0,idx=0;
        row--;col--;
        while (true){
            for(int j=c;j<=col;j++)
                result[idx++]=matrix[r][j];
            if(++r> row) break;
            for (int i= r;i<=row;i++)
                result[idx++]=matrix[i][col];
            if(--col < c) break;
            for(int j= col;j>=c;j--)
                result[idx++]=matrix[row][j];
            if(--row < r) break;
            for(int i=row;i>=r;i--)
                result[idx++]=matrix[i][c];
            if(++c>col) break;

        }
        return result;

    }
}
