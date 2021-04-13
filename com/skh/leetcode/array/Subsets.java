package leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. 子集
 * @Description
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * @auther SHENKAIHUAN
 * @create 2021-04-13 20:34
 */
public class Subsets {
    public static void main(String[] args) {
        int[] nums =new int[]{1,2,3};
        System.out.println (subsets (nums));
    }
    public static List<List<Integer>> subsets(int[] nums) {
        if(nums==null) return null;
        List<List<Integer>> result =new ArrayList<> ();
        backLook(result,nums,0,new ArrayList<> ());
        return result;
    }

    private static void backLook(List<List<Integer>> result, int[] nums,int idx, List<Integer> integers) {
        result.add (new ArrayList<> (integers));
        for (; idx <nums.length ; idx++) {
            integers.add (nums[idx]);
            backLook (result, nums, idx+1, integers);
            integers.remove (integers.size ()-1);
        }
    }
}
