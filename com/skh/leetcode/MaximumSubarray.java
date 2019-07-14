package leetcode;

/**
 * @Description 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6
 * @auther SHENKAIHUAN
 * @create 2019-07-14 10:18
 */
public class MaximumSubarray {
    public static void main(String[] args) {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        long start = System.currentTimeMillis ();
        System.out.println (maxSubArray (nums));
        long end = System.currentTimeMillis ();
        System.out.println ("total:" + (end - start));
    }

    public static int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int max = maxSum;
        for (int i = 1; i < nums.length; i++) {
            //累计大于0的，继续加
            if (max > 0) {
                max += nums[i];
            } else {
                //小于等于0，说明当前max对后面无增益效果，重新计算
                max = nums[i];
            }
            if (maxSum < max) {
                maxSum = max;
            }
        }
        return maxSum;
    }

}
