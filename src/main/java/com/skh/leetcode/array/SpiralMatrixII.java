package leetcode.array;

/**
 * @Description
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 *
 * 输入: 3
 * 输出:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 * @auther SHENKAIHUAN
 * @create 2019-07-21 13:53
 */
public class SpiralMatrixII {
    public static void main(String[] args) {
        int n =3;
        long start =System.currentTimeMillis ();
        int[][] matrix =generateMatrix(n);
        long end =System.currentTimeMillis ();
        System.out.println ("total:"+(end-start));
        for (int[] i:matrix){
            for (int j : i){
                System.out.print(j+", ");
            }
            System.out.println ();
        }
    }

    public static int[][] generateMatrix(int n) {
        //结果矩阵
        int[][] matrix = new int[n][n];
        //总大小
        int nums = n * n;
        //当前方向：向上、下、左、右（插入）
        Dirction dirction = Dirction.right;
        //旋转层数
        int level =0;
        for (int i=0,j=0,num=1;num<=nums;num++){
            matrix[i][j] = num;
            //计算下个数横纵 坐标
            if(dirction == Dirction.right && j< n-1-level){
                //横坐标不变，纵坐标向右移动
                j++;
            }else if(dirction == Dirction.left && j> level){
                j--;
            }else if(dirction == Dirction.dowm && i< n-1-level){
                i++;
            }else if(dirction == Dirction.up && i> level){
                i--;
            }

            //改变方向
            if(dirction == Dirction.right && j == n-1-level){
                dirction = Dirction.dowm;
            }else if(dirction == Dirction.dowm && i == n-1-level){
                dirction = Dirction.left;
            }else if(dirction == Dirction.left && j == level){
                dirction = Dirction.up;
            }else if(dirction == Dirction.up && i == level+1){
                dirction = Dirction.right;
                //转一圈
                level++;
            }
        }
        return matrix;
    }

    enum Dirction{
        right,
        left,
        up,
        dowm;
    }
}
