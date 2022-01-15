package comp.NO167;

/**
 * 元素和小于等于阈值的正方形的最大边长
 * @Description
 * @auther SHENKAIHUAN
 * @create 2019-12-15 10:53
 */
public class MaxSideLength {
    public static void main(String[] args) {

//        int[][] mat = new int[][]{
//                {1, 1, 3, 2, 4, 3, 2},
//                {1, 1, 3, 2, 4, 3, 2},
//                {1, 1, 3, 2, 4, 3, 2}
//        };
        int[][] mat =new int[][]{
                {1,1,1,1},
                {1,0,0,0},
                {1,0,0,0},
                {1,0,0,0}
        };
        int threshold=4;
        System.out.println (maxSideLength(mat,threshold));
    }
    public static int maxSideLength(int[][] mat, int threshold) {

        int result= 0;

        int rows =mat.length;
        int col =mat[0].length;
        int maxLenght=Math.min (rows,col);
        for(;maxLenght>0;maxLenght--){
            for(int i=0;i<maxLenght-1;i++){
                for(int j=0;j<maxLenght-1;j++){
//                    int sum=caculateSum(mat,)
                }
            }

        }
        for(int i =0;i<rows-2;i++){
            for(int j=0;j<col-2;j++){
                int sum=mat[i][j]+mat[i][j+1]+mat[i+1][j]+mat[i+1][j+1];
                if(sum==threshold){
                    return mat[i][j]+mat[i][j+1];
                }else if(result<sum&&sum<threshold ){
                    result = sum;
                    maxLenght=mat[i][j]+mat[i][j+1];
                }
            }
        }
        return maxLenght;
    }
}
