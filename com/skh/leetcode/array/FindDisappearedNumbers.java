package leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 448. 找到所有数组中消失的数字
 * @Description
 * 给定一个范围在1 ≤ a[i] ≤ n (n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
 *
 * 输入:
 * [4,3,2,7,8,2,3,1]
 *
 * 输出:
 * [5,6]
 * @auther SHENKAIHUAN
 * @create 2021-03-02 22:28
 */
public class FindDisappearedNumbers {
    public static void main(String[] args) {
        int[] nums = new int[]{2,2,1};
        List<Integer> disappearedNumbers = findDisappearedNumbers (nums);
        System.out.println (disappearedNumbers);
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<> ();
        for(int num : nums){
            num = Math.abs (num);
            if(nums[num-1]>0) nums[num-1] = nums[num-1]*-1;
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0) result.add (i+1);
        }
        return result;
    }
}
