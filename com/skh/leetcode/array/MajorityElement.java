package leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 169. 求众数
 * @Description
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 *
 * 输入: [3,2,3]
 * 输出: 3
 *
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 * @auther SHENKAIHUAN
 * @create 2019-09-13 15:15
 */
public class MajorityElement {
    public static void main(String[] args) {

        int[] nums = new int[]{3,2,3};
        long start =System.currentTimeMillis ();
        System.out.println (majorityElement (nums));
        long end =System.currentTimeMillis ();
        System.out.println ("total:"+(end-start));

    }

    /*public static int majorityElement(int[] nums) {

        int half =(nums.length+1)/2;
        Map<Integer,Integer> map=new HashMap<> (nums.length);
        for (int num : nums){
            int count = map.get (num)==null?0:map.get (num);
            if(++count>=half){
                return num;
            }
            map.put (num,count);
        }
        return -1;


    }*/

    /**
     * Boyer-Moore 投票算法
     * @param nums
     * @return
     */
    public static int majorityElement(int[] nums) {

        int result=0;
        int count =0;
        for(int i=0;i<nums.length;i++){
            if(count==0){
                result=nums[i];
            }
            if(nums[i]==result){
                count++;
            }else {
                count--;
            }
        }
        return result;


    }
}
