package leetcode.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 47. 全排列 II
 *
 * @Description 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * <p>
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 * [1,2,1],
 * [2,1,1]]
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * @auther SHENKAIHUAN
 * @create 2021-03-04 23:47
 */
public class PermuteUnique {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2};
        List<List<Integer>> lists = permuteUnique (nums);
        System.out.println (lists);
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<> ();
        permuteUnique (result, nums,  0);
        return result;
    }

    private static void permuteUnique(List<List<Integer>> result, int[] nums, int begin) {
        if (begin == nums.length) {
            List<Integer> list = new ArrayList<> ();
            for (int num : nums) {
                list.add (num);
            }
            result.add (list);
            return;
        }
        Set<Integer> set = new HashSet<> ();
        for (int i = begin; i < nums.length; i++) {
            if(set.contains (nums[i]))continue;
            set.add (nums[i]);
            swap (nums, i, begin);
            permuteUnique (result,nums, begin + 1);
            swap (nums, i, begin);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
