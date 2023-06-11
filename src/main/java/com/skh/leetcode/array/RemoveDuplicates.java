package leetcode.array;

/**
 * 80. 删除有序数组中的重复项 II
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 输入：nums = [1,1,1,2,2,3]
 * 输出：5, nums = [1,1,2,2,3]
 * 解释：函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。 不需要考虑数组中超出新长度后面的元素。
 *
 * @Description
 * @auther SHENKAIHUAN
 * @create 2023/6/11 14:27
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 1, 2, 2, 3, 3};
        int len = new RemoveDuplicates().removeDuplicates(nums);
        System.out.println(len);
    }

    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        if (length <= 2) {
            return length;
        }
        int slow = 2;
        int fast = 2;
        while (fast < length) {
            if (nums[slow - 2] != nums[fast]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }

//    public int removeDuplicates(int[] nums) {
//        int length = nums.length;
//        if (length == 0) {
//            return 0;
//        }
//        int tmp = nums[0];
//        int tmpLen = 1;
//        int len = 1;
//        int i = 1;
//        while (i < length) {
//            if (nums[i] == tmp) {
//                tmpLen++;
//            } else {
//                tmpLen = 1;
//                tmp = nums[i];
//            }
//            if (tmpLen <= 2) {
//                len++;
//                i++;
//            } else {
//                for (int j = i; j < length - 1; j++) {
//                    nums[j] = nums[j + 1];
//                }
//                length--;
//            }
//        }
//        return len;
//    }
}
