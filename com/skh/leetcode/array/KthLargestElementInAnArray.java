package leetcode.array;

import java.util.Arrays;

/**
 * @Description
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 *
 * 说明:
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 * @auther SHENKAIHUAN
 * @create 2019-07-30 22:39
 */
public class KthLargestElementInAnArray {
    public static void main(String[] args) {
        int[] nums = new int[]{1};
        int k=1;
        for (int i: nums){
            System.out.print (i+",");
        }
        System.out.println ();
        long start =System.currentTimeMillis ();
        System.out.println (findKthLargest(nums,k));
        long end =System.currentTimeMillis ();
        System.out.println ("total:"+(end-start));
    }
    public static int findKthLargest(int[] nums, int k) {
        Arrays.sort (nums);
        return nums[nums.length-k];
    }

//    /**
//     * 快速排序思路
//     * @param nums
//     * @param k
//     * @return
//     */
//    public static int findKthLargest(int[] nums, int k) {
//        int temp=nums[0];
//        for(int i=0;i<k;i++){
//            for(int j=i;j<nums.length;j++){
//                if(nums[j]>nums[i]){
//                    temp = nums[j];
//                    nums[j] = nums[i];
//                    nums[i] = temp;
//                }
//            }
//        }
//        return nums[k-1];
//    }

}
