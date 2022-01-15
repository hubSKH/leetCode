package comp.NO166;

import java.util.Arrays;

/**
 * @Description
 * @auther SHENKAIHUAN
 * @create 2019-12-08 11:43
 */
public class MinThrold {
    public static void main(String[] args) {
        int[] nums =new int[]{1,2,5,9};
        int threshold =6;
        System.out.println (smallestDivisor(nums,threshold));
    }
    public static int smallestDivisor(int[] nums, int threshold) {

        Arrays.sort (nums);
        for(int i=1;i<=10e6;i++){
            int sum=0;
            for(int j=0;j<nums.length;j++){
                sum+=Math.ceil (nums[j]*1.0/i);
                if(sum>threshold){
                    break;
                }
            }
            if(sum<=threshold){
                return i;
            }
        }
        return  -1;

    }
}
