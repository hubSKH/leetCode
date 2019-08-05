package leetcode.array;

import java.util.HashMap;

/**
 * 219. 存在重复元素 II
 *
 * @Description 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，
 * 使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。
 * <p>
 * 输入: nums = [1,2,3,1], k = 3
 * 输出: true
 * <p>
 * 输入: nums = [1,2,3,1,2,3], k = 2
 * 输出: false
 * @auther SHENKAIHUAN
 * @create 2019-08-04 22:41
 */
public class ContainsDuplicateII {
    public static void main(String[] args) {
        int[] nums = new int[]{4,1,2,3,1,5};
        int k = 3;
        long start = System.currentTimeMillis ();
        System.out.println (containsNearbyDuplicate (nums, k));
        long end = System.currentTimeMillis ();
        System.out.println ("total:" + (end - start));
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<> ();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey (nums[i]) && ( i - map.get (nums[i])<= k)){
                    return true;
            }else {
                map.put (nums[i],i);
            }
        }
        return false;
    }
}
