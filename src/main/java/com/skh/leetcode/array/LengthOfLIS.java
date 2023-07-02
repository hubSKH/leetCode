package leetcode.array;

/**
 * 300. 最长递增子序列
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 * <p>
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 *
 * @Description
 * @auther SHENKAIHUAN
 * @create 2023/7/2 14:52
 */
public class LengthOfLIS {
    public static void main(String[] args) {
        int[] nums = new int[]{10,9,2,5,3,7,101,18};
        System.out.println(new LengthOfLIS().lengthOfLIS(nums));
    }
    //dp
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] lengths = new int[nums.length];
        lengths[0] = 1;
        int maxSunLen = 1;
        for (int i = 1; i < nums.length; i++) {
            lengths[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    lengths[i] = Math.max(lengths[i], lengths[j] + 1);
                }
            }
            maxSunLen = Math.max(lengths[i], maxSunLen);
        }
        return maxSunLen;
    }

/* 解法0   public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        boolean[] flags = new boolean[nums.length];
        int[] lengths = new int[nums.length];
        flags[nums.length - 1] = true;
        Arrays.fill(lengths, 1);
        int maxSunLen = 0;
        for (int i = 0; i < nums.length; i++) {
            int length = calLength(nums, flags, lengths, i);
            maxSunLen = Math.max(maxSunLen, length);
        }
        return maxSunLen;
    }

    private int calLength(int[] nums, boolean[] flags, int[] lengths, int idx) {
        if (flags[idx]) return lengths[idx];
        int max = 0;
        for (int i = idx + 1; i < nums.length; i++) {
            if (nums[idx] < nums[i]) {
                max = Math.max(max, calLength(nums, flags, lengths, i));
            }
        }
        flags[idx] = true;
        lengths[idx] += max;
        return lengths[idx];
    }*/
}
