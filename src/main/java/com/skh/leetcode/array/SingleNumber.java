package leetcode.array;

/**
 * 136. 只出现一次的数字
 * @Description
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 说明：
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * 输入: [2,2,1]
 * 输出: 1
 * @auther SHENKAIHUAN
 * @create 2021-03-15 21:35
 */
public class SingleNumber {
    public static void main(String[] args) {
        int[] nums = new int[]{2,1,1};
        System.out.println (singleNumber (nums));
    }
    public static int singleNumber(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] ^=nums[i-1];
        }
        return nums[nums.length-1];
    }
}
