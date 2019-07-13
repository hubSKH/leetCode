package leetcode;

/**
 * @Description
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * @auther SHENKAIHUAN
 * @create 2019-07-09 23:03
 */
public class DuplicatesFromSortedArray {

    public static void main(String[] args) {
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};

        long start =System.currentTimeMillis ();
        for (int i:nums){
            System.out.print(i+", ");
        }
        System.out.println ();
        System.out.println (removeDuplicates (nums));
        for (int i:nums){
            System.out.print(i+", ");
        }
        System.out.println ();
        long end =System.currentTimeMillis ();
        System.out.println ("total:"+(end-start));
    }

    /**
     * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
     *
     * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
     *
     * 你不需要考虑数组中超出新长度后面的元素。
     */
    public static int removeDuplicates(int[] nums) {
        int j=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]>nums[j]){
                nums[++j] = nums[i];
            }
        }
        return j+1;
    }
}
