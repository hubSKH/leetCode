package leetcode.array;

/**
 * 540. 有序数组中的单一元素
 *
 * @Description 给定一个只包含整数的有序数组，每个元素都会出现两次，唯有一个数只会出现一次，找出这个数。
 * 输入: nums = [1,1,2,3,3,4,4,8,8]
 * 输出: 2
 * @auther SHENKAIHUAN
 * @create 2021-10-08 21:40
 */
public class SingleNonDuplicate {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8};
        System.out.println (new SingleNonDuplicate ().singleNonDuplicate (nums));

    }

    public int singleNonDuplicate(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            boolean isOdd = (right - mid) % 2 == 0;
            if (nums[mid] == nums[mid + 1]) {
                if (isOdd) {
                    left = mid + 2;
                } else {
                    right = mid - 1;
                }
            } else if (nums[mid - 1] == nums[mid]) {
                if (isOdd) {
                    right = mid - 2;
                } else {
                    left = mid + 1;
                }
            } else {
                return nums[mid];
            }

        }
        return nums[left];
    }
}
