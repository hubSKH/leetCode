package leetcode;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 你可以假设数组中无重复元素。
 *
 * 输入: [1,3,5,6], 5
 * 输出: 2
 *
 * 输入: [1,3,5,6], 2
 * 输出: 1
 *
 * @Description
 * @auther SHENKAIHUAN
 * @create 2019-07-13 17:26
 */
public class SearchInsertPosition {
    public static void main(String[] args) {
        int[] nums = new int[]{1};
        int target =7;
        for (int i:nums){
            System.out.print(i+", ");
        }
        System.out.println ();
        long start =System.currentTimeMillis ();
        System.out.println (searchInsert (nums,target));
        long end =System.currentTimeMillis ();
        System.out.println ("total:"+(end-start));
        for (int i:nums){
            System.out.print(i+", ");
        }
    }
    public static int searchInsert(int[] nums, int target) {
        int i=0;
        for (;i<nums.length;i++){
            if(nums[i]<target){
                if(i<nums.length-1 && nums[++i]>=target){
                    break;
                }
            }else {
                break;
            }
        }
        return i;
    }
}
