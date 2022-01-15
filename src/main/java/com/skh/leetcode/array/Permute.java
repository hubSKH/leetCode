package leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. 全排列
 *
 * @Description 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * <p>
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 * @auther SHENKAIHUAN
 * @create 2021-03-01 23:52
 */
public class Permute {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> permute = permute (nums);
        System.out.println (permute);
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<> ();
        permute (nums, result, 0);
        return result;
    }

    private static void permute(int[] nums, List<List<Integer>> result, int begin) {
        if (begin == nums.length) {
            List<Integer> list = new ArrayList<> ();
            for (int num : nums) {
                list.add (num);
            }
            result.add (list);
            return;
        }
        for (int i = begin; i < nums.length; i++) {
            swap (nums, i, begin);
            permute (nums, result, begin + 1);
            swap (nums, i, begin);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
