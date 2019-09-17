package leetcode.array;

/**
 * 674. 最长连续递增序列
 * @Description
 * 给定一个未经排序的整数数组，找到最长且连续的的递增序列。
 *
 * 输入: [1,3,5,4,7]
 * 输出: 3
 * 解释: 最长连续递增序列是 [1,3,5], 长度为3。
 * 尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为5和7在原数组里被4隔开。
 *
 * 输入: [2,2,2,2,2]
 * 输出: 1
 * 解释: 最长连续递增序列是 [2], 长度为1。
 * @auther SHENKAIHUAN
 * @create 2019-09-17 23:50
 */
public class LongestContinuousIncreasingSubsequence {
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,4,2,3,4,5};
        long start =System.currentTimeMillis ();
        System.out.println (findLengthOfLCIS (nums));
        long end =System.currentTimeMillis ();
        System.out.println ("total:"+(end-start));
    }

    public static int findLengthOfLCIS(int[] nums) {

        if(nums.length<2){
            return nums.length;
        }
        int longestLen = 1;
        int i=0,j=1;
        for (;j<nums.length;j++){
            if (nums[j] > nums[j - 1] ) {
                int len = j - i + 1;
                if(len > longestLen){
                    longestLen = len;
                }
            } else {
                i = j;
            }
        }

        return longestLen;
    }
}
