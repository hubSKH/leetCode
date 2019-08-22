package leetcode.array;

/**
 * 661. 图片平滑器
 * @Description
 * 包含整数的二维矩阵 M 表示一个图片的灰度。
 * 你需要设计一个平滑器来让每一个单元的灰度成为平均灰度 (向下舍入) ，
 * 平均灰度的计算是周围的8个单元和它本身的值求平均，
 * 如果周围的单元格不足八个，则尽可能多的利用它们。
 *
 * 输入:
 * [[1,1,1],
 *  [1,0,1],
 *  [1,1,1]]
 * 输出:
 * [[0, 0, 0],
 *  [0, 0, 0],
 *  [0, 0, 0]]
 * 解释:
 * 对于点 (0,0), (0,2), (2,0), (2,2): 平均(3/4) = 平均(0.75) = 0
 * 对于点 (0,1), (1,0), (1,2), (2,1): 平均(5/6) = 平均(0.83333333) = 0
 * 对于点 (1,1): 平均(8/9) = 平均(0.88888889) = 0
 *
 * @auther SHENKAIHUAN
 * @create 2019-08-22 23:32
 */
public class ImageSmoother {

    public static void main(String[] args) {
        int[][] m = new int[][]{
                {1,1,1},
                {1,0,1},
                {1,1,1}
        };
        long start = System.currentTimeMillis ();
        int[][] result = imageSmoother (m);
        long end = System.currentTimeMillis ();
        System.out.println ("total:"+(end-start));
        for(int[] i :result){
            for (int j :i){
                System.out.print (j+", ");
            }
            System.out.println ();
        }
    }

    public static int[][] imageSmoother(int[][] M) {
        int rows = M.length;
        int cols = M[0].length;
        int[][] result = new int[rows][cols];
        for(int i =0;i<rows;i++){
            for(int j=0;j<cols;j++){
                result[i][j] = caculate(M,i,j,rows,cols);
            }
        }
        return result;
    }

    private static int caculate(int[][] m, int i, int j, int rows, int cols) {
        int count = 1;
        int sum = m[i][j];
        if(i-1>=0){
            if(j-1>=0){
                //左上
                count++;
                sum+=m[i-1][j-1];
            }
            //上
            count++;
            sum+=m[i-1][j];
            if(j+1<cols){
                //右上
                count++;
                sum+=m[i-1][j+1];
            }
        }

            if(j-1>=0){
                //左
                count++;
                sum+=m[i][j-1];
            }
            if(j+1<cols){
                //右
                count++;
                sum+=m[i][j+1];
            }

        if(i+1<rows){
            if(j-1>=0){
                //左下
                count++;
                sum+=m[i+1][j-1];
            }
            //下
            count++;
            sum+=m[i+1][j];
            if(j+1<cols){
                //右下
                count++;
                sum+=m[i+1][j+1];
            }
        }
        return sum/count;
    }
}
