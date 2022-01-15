package leetcode.array;

/**
 * 414. 第三大的数
 * @Description
 * 给定一个非空数组，返回此数组中第三大的数。
 * 如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。
 *
 *  输入: [3, 2, 1]
 * 输出: 1
 * 解释: 第三大的数是 1.
 *
 * 输入: [1, 2]
 * 输出: 2
 * 解释: 第三大的数不存在, 所以返回最大的数 2 .
 * @auther SHENKAIHUAN
 * @create 2019-09-14 16:06
 */
public class ThirdMaximumNumber {
    public static void main(String[] args) {
        int[] nums = new int[]{2,2,3,1};
        long start =System.currentTimeMillis ();
        System.out.println (thirdMax (nums));
        long end =System.currentTimeMillis ();
        System.out.println ("total:"+(end-start));
    }

    public static int thirdMax(int[] nums) {

        if(nums.length==1){
            return nums[0];
        }
        if(nums.length==2){
            return nums[0]>nums[1]?nums[0]:nums[1];
        }
        long max1= Long.MIN_VALUE;
        long max2= Long.MIN_VALUE;
        long max3= Long.MIN_VALUE;
        for (int i=0;i<nums.length;i++){
            if(max1==nums[i]||max2==nums[i]||max3==nums[i]){
                //去重
                continue;
            }
            if(nums[i]>max3){
                if(nums[i]>max1){
                    max3=max2;
                    max2=max1;
                    max1=nums[i];
                }else {
                    if(nums[i]>max2){
                        max3=max2;
                        max2=nums[i];
                    }else{
                        max3=nums[i];
                    }
                }
            }
        }
        if(max3==Long.MIN_VALUE){
            return (int) max1;
        }
        return (int) max3;
    }

}
