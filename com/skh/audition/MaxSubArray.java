package audition;

/**
 * 面试题42. 连续子数组的最大和
 * @Description
 * 输入一个整型数组，数组里有正数也有负数。
 * 数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 * 要求时间复杂度为O(n)。
 *
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * @auther SHENKAIHUAN
 * @create 2020-05-08 21:57
 */
public class MaxSubArray {
    public static void main(String[] args) {
        int[] nums=new int[]{-2,1,-3,4,-1,2,1,-5,4};

        System.out.println (maxSubArray (nums));

    }
    public static int maxSubArray(int[] nums) {

        int sum = nums[0];
        int max = sum;
        for(int i=1;i<nums.length;i++){

            if(sum>0){
                sum+=nums[i];
            }else {
                sum=nums[i];
            }
            if(sum>max){
                max=sum;
            }
        }
        return max;

    }
}
