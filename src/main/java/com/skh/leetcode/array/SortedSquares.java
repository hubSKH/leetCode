package leetcode.array;

import java.util.Arrays;

/**
 * 977. 有序数组的平方
 * @Description
 * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 * @auther SHENKAIHUAN
 * 输入：[-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * @create 2020-09-06 11:46
 */
public class SortedSquares {
    public static void main(String[] args) {

        int[] nums =new int[]{-4,-1,0,4,10};
        System.out.println (Arrays.toString (sortedSquares (nums)));
    }
    public static int[] sortedSquares(int[] A) {
        int i=0,j=A.length-1,idx=j;
        int[] result = new int[A.length];
        while (i<=j){
            if(A[i]*A[i]>A[j]*A[j]){
                result[idx]=A[i]*A[i];
                i++;
            }else {
                result[idx]=A[j]*A[j];
                j--;
            }
            idx--;
        }
        return result;

    }
}
