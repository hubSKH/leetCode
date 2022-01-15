package audition;

/**
 * 面试题03. 数组中重复的数字
 * @Description
 * 找出数组中重复的数字。
 *
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
 * 请找出数组中任意一个重复的数字。
 *
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 * @auther SHENKAIHUAN
 * @create 2020-02-15 22:22
 */
public class RepeateNum {
    public static void main(String[] args) {
        int[] nums =new int[]{1,2,3,7,3};
        long start =System.currentTimeMillis ();
        System.out.println (findRepeatNumber(nums));
        long end =System.currentTimeMillis ();
        System.out.println ("total:"+(end-start));
    }

    public static int findRepeatNumber(int[] nums) {
        int[] count= new int[nums.length];
        for (int i=0;i<nums.length;i++){
            if(count[nums[i]]!=0){
                return nums[i];
            }
            count[nums[i]]++;
        }
        return -1;
    }
}
