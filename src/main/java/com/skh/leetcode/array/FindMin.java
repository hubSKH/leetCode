package leetcode.array;

/**
 * 154. 寻找旋转排序数组中的最小值 II
 *
 * @Description 已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。例如，原数组 nums = [0,1,4,4,5,6,7] 在变化后可能得到：
 * 若旋转 4 次，则可以得到 [4,5,6,7,0,1,4]
 * 若旋转 7 次，则可以得到 [0,1,4,4,5,6,7]
 * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
 * 给你一个可能存在 重复 元素值的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。
 * <p>
 * 输入：nums = [2,2,2,0,1]
 * 输出：0
 * @auther SHENKAIHUAN
 * @create 2021-09-05 20:34
 */
public class FindMin {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 2, 0,};
        System.out.println (new FindMin ().findMin (nums));
    }

    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        int mid;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (nums[right] > nums[mid]) {
                right = mid;
            } else if (nums[right] < nums[mid]) {
                left = mid + 1;
            } else {
                right--;
            }
        }
        return nums[left];

    }
}
