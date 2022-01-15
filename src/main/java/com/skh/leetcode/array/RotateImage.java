package leetcode.array;

/**
 * 给定一个 n × n 的二维矩阵表示一个图像。
 * 将图像顺时针旋转 90 度。
 * 说明：
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 *
 * 示例：
 * 给定 matrix =
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 * @Description
 * @auther SHENKAIHUAN
 * @create 2019-07-13 11:20
 */
public class RotateImage {
    public static void main(String[] args) {
        int[][] matrix=
//                {
//                        {1}
//                };
//                {
//                        {1,2},
//                        {3,4}
//                };
//        {
//                {1,2,3,4},
//                {5,6,7,8},
//                {9,10,11,12},
//                {13,14,15,16}
//        };
//        {
//                {1,2,3,4,5},
//                {6,7,8,9,10},
//                {11,12,13,14,15},
//                {16,17,18,19,20},
//                {21,22,23,24,25}
//        };
        {
                {1,2,3,4,5,6},
                {7,8,9,10,11,12},
                {13,14,15,16,17,18},
                {19,20,21,22,23,24},
                {25,26,27,28,29,30},
                {31,32,33,34,35,36}
        };
        System.out.println ("============before===========");
        for (int[] i:matrix){
            for (int j : i){
                System.out.print(j+", ");
            }
            System.out.println ();
        }
        long start =System.currentTimeMillis ();
        rotate (matrix);
        long end =System.currentTimeMillis ();
        System.out.println ("total:"+(end-start));
        System.out.println ("============after===========");
        for (int[] i:matrix){
            for (int j : i){
                System.out.print(j+", ");
            }
            System.out.println ();
        }
    }

    public static void rotate(int[][] matrix) {

        int n=(matrix.length+1)/2;
        int maxIdx =matrix.length-1;
        for (int i=0 ;i<n;i++){
            for (int j=i; j<maxIdx-i;j++){
                //四个相对点旋转
                int temp =matrix[i][j];
                matrix[i][j] =matrix[maxIdx-j][i];
                matrix[maxIdx-j][i] = matrix[maxIdx-i][maxIdx-j];
                matrix[maxIdx-i][maxIdx-j] =matrix[j][maxIdx-i];
                matrix[j][maxIdx-i]=temp;
            }
        }
    }
}
