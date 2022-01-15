package leetcode.array;

import java.math.BigDecimal;

/**
 * @Description
 * 给定一个整数数组 A，找到 min(B) 的总和，其中 B 的范围为 A 的每个（连续）子数组。
 *
 * 由于答案可能很大，因此返回答案模 10^9 + 7。
 *
 * 输入：[3,1,2,4]
 * 输出：17
 * 解释：
 * 子数组为 [3]，[1]，[2]，[4]，[3,1]，[1,2]，[2,4]，[3,1,2]，[1,2,4]，[3,1,2,4]。
 * 最小值为 3，1，2，4，1，1，2，1，1，1，和为 17。
 *
 * @auther SHENKAIHUAN
 * @create 2019-07-23 23:23
 */
public class SumofSubarrayMinimums {
    public static void main(String[] args) {
        int[] nums = new int[]{3,1,2,4};
        for (int i:nums){
            System.out.print(i+", ");
        }
        System.out.println ();
        long start =System.currentTimeMillis ();
        System.out.println (sumSubarrayMins(nums));
        long end =System.currentTimeMillis ();
        System.out.println ("total:"+(end-start));
    }

    public static int sumSubarrayMins(int[] A) {
        final int MOD = (int)(1e9) + 7;
        int length = A.length;
        long result = 0;
        int[] lmin = new int[length];
        int[] rmin = new int[length];
        //右边所能到达的极限
        for(int i = 0;i<A.length;i++){
            lmin[i] = i;
            int index = i-1;
            while(index>=0&&A[index]>A[i]){
                lmin[i] = lmin[index];
                index = lmin[index] -1;
            }
        }
        //左边所能到达的极限
        for(int i = length-1;i>=0;i--){
            rmin[i] = i;
            int index = i+1;
            while(index<length&&A[index]>=A[i]){
                rmin[i] = rmin[index];
                index = rmin[index] +1;
            }
        }
        /*
        没有也是一种可能
        以A[i]为最小值的连续数组个数为左边大于A[i]的元素个数+1 * 右边大于等于A[i]元素个数+1
        */
        for(int i = 0;i<length;i++){
            result += (i-lmin[i]+1)*(rmin[i]-i+1)*A[i];
        }
        return (int)(result%MOD);
    }

}
