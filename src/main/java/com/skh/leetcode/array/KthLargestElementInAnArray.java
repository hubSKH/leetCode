package leetcode.array;

import java.util.Random;

/**
 * 215. 数组中的第K个最大元素
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
        int[] nums = new int[]{5,6,4,3,2,1};
        int k=2;
        for (int i: nums){
            System.out.print (i+",");
        }
        System.out.println ();
        long start =System.currentTimeMillis ();
        System.out.println (findKthLargest(nums,k));
        long end =System.currentTimeMillis ();
        System.out.println ("===============after==============");
        for (int i: nums){
            System.out.print (i+",");
        }
        System.out.println ();
        System.out.println ("total:"+(end-start));
    }
//    public static int findKthLargest(int[] nums, int k) {
//        Arrays.sort (nums);
//        return nums[nums.length-k];
//    }

    /**
     * 快速排序思路
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargest(int[] nums, int k) {
        System.out.println (quickSelect(nums,0,nums.length-1,nums.length-k));
        return quickSelect(nums,0,nums.length-1,nums.length-k);
    }

    private static int quickSelect(int[] nums, int low, int hight, int pos) {

        if(low == hight){
            return nums[low];
        }

        int i=low;
        int j=hight;
        int pov_idx = position(nums,low,hight,low+new Random ().nextInt(hight - low));
        if(pov_idx == pos){
            return nums[pov_idx];
        }else if(pov_idx > pos){
            return quickSelect (nums,low,pov_idx-1,pos);
        }else {
            return quickSelect (nums,pov_idx+1,hight,pos);
        }
    }

    /**
     *
     * @param nums
     * @param low
     * @param hight
     * @param pos
     * @return
     */
    private static int position(int[] nums, int low, int hight, int pos) {

        int num =nums[pos];
        int store_idx = low;
        swap(nums,pos, hight);
        for(int i=low;i<=hight;i++){
            if(nums[i]<num){
                swap (nums,store_idx,i);
                store_idx++;
            }
        }
        swap (nums,store_idx,hight);
        return store_idx;
    }

    /**
     * 交换
     * @param nums
     * @param i
     * @param j
     */
    private static void swap (int[] nums ,int i ,int j ){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
