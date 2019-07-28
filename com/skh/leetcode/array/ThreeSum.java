package leetcode.array;

import java.util.*;

/**
 * @Description
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 *
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 * @auther SHENKAIHUAN
 * @create 2019-07-27 23:17
 */
public class ThreeSum {

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        for (int i: nums){
            System.out.print (i+",");
        }
        System.out.println ();
        long start =System.currentTimeMillis ();
        List<List<Integer>> lists =threeSum (nums);
        long end =System.currentTimeMillis ();
        System.out.println ("total:"+(end-start));
        for (List<Integer> list :lists){
            for (Integer i : list){
                System.out.print(i+", ");
            }
            System.out.println();
        }
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<> ();
        if (nums.length<3){
            return result;
        }
        //先排序
        Arrays.sort (nums);
        for(int i =0;i<nums.length-2;i++){
            //跳过与前一个元素相同的计算，防止结果重复
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            //左边起点
            int left=i+1;
            //右边起点
            int right=nums.length-1;
            //目标值，当left、right两个对应元素值和等于目标值（a+b+c=0），加入结果
            int target = - nums[i];
            while (left<right){
                if(nums[left]+nums[right]>target){
                    //和大于目标值，说明右边的数值较大（因为数组已排序），需要往前挪
                    right--;
                }else if(nums[left]+nums[right]<target){
                    //和小于目标值，左边的数往后挪
                    left++;
                }else{
                    //和相等，得出符合结果
                    result.add (Arrays.asList (nums[i],nums[left],nums[right]));
                    //继续计算
                    left++;
                    right--;
                    //排除相同的结果
                    while (left < right && nums[left] == nums[left - 1]){
                        left++;
                    }
                    while (right > left && right < nums.length - 1 && nums[right] == nums[right + 1]){
                        right--;
                    }
                }
            }
        }
        return result;
    }


}
