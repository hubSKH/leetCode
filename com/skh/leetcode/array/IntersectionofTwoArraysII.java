package leetcode.array;

import java.util.*;

/**
 * @Description
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 *
 * @auther SHENKAIHUAN
 * @create 2019-07-16 23:23
 */
public class IntersectionofTwoArraysII {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,2,1};
        int[] nums2 =new int[]{2,4};
        long start =System.currentTimeMillis ();
        int[] num3 = intersect(nums1,nums2);
        long end =System.currentTimeMillis ();
        for (int i:num3){
            System.out.print(i+", ");
        }
        System.out.println ();
        System.out.println ("total:"+(end-start));
    }

    public static int[] intersect(int[] nums1, int[] nums2) {

        //放num2 已确认交集元素下标
        Map<Integer,Integer> flag = new HashMap<> ();
        for(int i :nums1){
            for (int j=0;j<nums2.length;j++){
                if(i==nums2[j] && !flag.containsKey (j)){
                    //相等 并且之前没确认交集
                    flag.put (j,nums2[j]);
                    break;
                }
            }
        }
        int[] num3 =new int[flag.size ()];
        int i =0;
        for(int num :flag.values ()){
            num3[i++] = num;

        }
        return  num3;
    }
}
