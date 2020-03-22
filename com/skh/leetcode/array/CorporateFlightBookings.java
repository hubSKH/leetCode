package leetcode.array;

import java.util.Arrays;

/**
 * 1109. 航班预订统计
 * @Description
 * 这里有 n 个航班，它们分别从 1 到 n 进行编号。
 * 我们这儿有一份航班预订表，表中第 i 条预订记录 
 * bookings[i] = [i, j, k] 意味着我们在从 i 到 j 的每个航班上预订了 k 个座位。
 *
 * 请你返回一个长度为 n 的数组 answer，按航班编号顺序返回每个航班上预订的座位数。
 *
 * 输入：bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
 * 输出：[10,55,45,25,25]
 * @auther SHENKAIHUAN
 * @create 2020-03-22 20:48
 */
public class CorporateFlightBookings {
    public static void main(String[] args) {

        int[][] bookings = new int[][]{
                {1,2,10},
                {2,3,20},
                {2,5,25}
        };
        int n =5;
        long start =System.currentTimeMillis ();
        System.out.println (Arrays.toString (corpFlightBookings(bookings,n)));
        long end =System.currentTimeMillis ();
        System.out.println ("total:"+(end-start));
    }
    public static int[] corpFlightBookings(int[][] bookings, int n) {
        int[] result = new int[n];
        for (int[] booking :bookings){
            result[booking[0]-1]+=booking[2];
            if(booking[1]<n){
                result[booking[1]]-=booking[2];
            }
        }
        for(int i=1;i<n;i++){
            result[i]+=result[i-1];
        }
        return result;
//        for (int[] booking :bookings){
//            for(int i=booking[0];i<=booking[1];i++){
//                result[i-1]+=booking[2];
//            }
//        }
    }
}
