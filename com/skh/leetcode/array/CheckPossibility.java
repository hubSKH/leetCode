package leetcode.array;

/**
 * 665. 非递减数列
 *
 * @Description 给你一个长度为 n 的整数数组，请你判断在 最多 改变1 个元素的情况下，该数组能否变成一个非递减数列。
 * <p>
 * 我们是这样定义一个非递减数列的：对于数组中任意的i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。
 * <p>
 * 输入: nums = [4,2,3]
 * 输出: true
 * @auther SHENKAIHUAN
 * @create 2021-08-08 22:02
 */
public class CheckPossibility {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 4, 2, 3};
        CheckPossibility checkPossibility = new CheckPossibility ();
        System.out.println (checkPossibility.checkPossibility (nums));
    }

    public boolean checkPossibility(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                count++;
                if (count > 1) {
                    return false;
                }
                if (i > 0 && nums[i + 1] < nums[i - 1]) {
                    nums[i + 1] = nums[i];
                }
            }
        }
        return true;
    }

}
