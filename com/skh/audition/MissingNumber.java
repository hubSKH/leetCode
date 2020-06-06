package audition;

/**
 * 面试题53 - II. 0～n-1中缺失的数字
 * @Description
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，
 * 并且每个数字都在范围0～n-1之内。
 * 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 *
 * 输入: [0,1,2,3,4,5,6,7,9]
 * 输出: 8
 * @auther SHENKAIHUAN
 * @create 2020-06-06 16:29
 */
public class MissingNumber {
    public static void main(String[] args) {
        int[] nums = new int[]{0,1,2,3,4,5,6,7,9};
        System.out.println (missingNumber(nums));

    }

    public static int missingNumber(int[] nums) {
        int i=0,j=nums.length-1;
        while (i<=j){
            int mid =(i+j)/2;
            if(nums[mid]==mid) i=mid+1;
            else j=mid-1;
        }
        return i;

    }
}
