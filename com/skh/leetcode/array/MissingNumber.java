package leetcode.array;

/**
 * 268. 缺失数字
 * @Description
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，
 * 找出 0 .. n 中没有出现在序列中的那个数。
 *
 * 输入: [3,0,1]
 * 输出: 2
 *
 * 输入: [9,6,4,2,3,5,7,0,1]
 * 输出: 8
 * @auther SHENKAIHUAN
 * @create 2019-09-14 15:28
 */
public class MissingNumber {
    public static void main(String[] args) {

        int[] nums =new int[]{9,6,4,2,3,5,7,8,1};
        long start = System.currentTimeMillis ();
        System.out.println (missingNumber (nums));
        long end = System.currentTimeMillis ();
        System.out.println ("total:"+(end-start));
    }

    public static int missingNumber(int[] nums) {

        int left=0;
        for(int i=0;i<nums.length;i++){
            int de = nums[i]-i;
            left+=de;
        }

        return nums.length-left;

    }
}
