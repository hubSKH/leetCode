package leetcode.array;

import java.util.HashSet;
import java.util.Set;

/**
 * 128. 最长连续序列
 *
 * @Description 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 进阶：你可以设计并实现时间复杂度为 O(n) 的解决方案吗？
 * <p>
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * @auther SHENKAIHUAN
 * @create 2021-06-13 14:55
 */
public class LongestConsecutive {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 0, 1};
        LongestConsecutive longestConsecutive = new LongestConsecutive ();
        System.out.println (longestConsecutive.longestConsecutive (nums));
    }

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<> (nums.length);
        for (int num : nums) {
            set.add (num);
        }
        int result = 0;
        for (int num : set) {
            if (set.contains (num - 1)) {
                continue;
            }
            int count = 1;
            while (set.contains (num + 1)) {
                count += 1;
                num += 1;
            }
            result = Math.max (result, count);
        }
        return result;
      /*  if(nums.length<=1)return nums.length;
        buildHeap(nums);
        int i=0;
        int result=1;
        for (; i < nums.length; i++) {
            int count=1;
            while (i+1<nums.length){
                if(nums[i]==nums[i+1]){
                    i++;
                }else if(nums[i]+1==nums[i+1]){
                    count++;
                    i++;
                }else {
                    break;
                }
            }
            result=Math.max (result,count);

        }
        return result;*/
    }

    int len;

    private void buildHeap(int[] nums) {
        len = nums.length;
        //从最后一个非叶子节点开始向上构造最大堆
        for (int i = (len - 1) / 2; i >= 0; i--) {
            adjustHeap (nums, i);
        }
        // sort
        for (; len > 0; ) {
            swap (nums, 0, len - 1);
            len--;
            adjustHeap (nums, 0);
        }
    }

    private void adjustHeap(int[] nums, int i) {
        int maxIdx = i;
        //left
        if (2 * i + 1 < len && nums[2 * i + 1] > nums[maxIdx]) maxIdx = 2 * i + 1;
        //right
        if (2 * i + 2 < len && nums[2 * i + 2] > nums[maxIdx]) maxIdx = 2 * i + 2;
        if (maxIdx != i) {
            swap (nums, i, maxIdx);
            adjustHeap (nums, maxIdx);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
