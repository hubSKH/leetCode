package leetcode.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Description
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2]
 *
 * @auther SHENKAIHUAN
 * @create 2019-07-19 23:50
 */
public class IntersectionofTwoArrays {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,2,1};
        int[] nums2 =new int[]{2,4};
        long start =System.currentTimeMillis ();
        int[] num3 = intersection(nums1,nums2);
        long end =System.currentTimeMillis ();
        for (int i:num3){
            System.out.print(i+", ");
        }
        System.out.println ();
        System.out.println ("total:"+(end-start));
    }

    public static int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> integerSet =new HashSet<> ();
        for(int num : nums1){
            integerSet.add (num);
        }
        Set<Integer> interSet =new HashSet<> ();
        for(int num : nums2){
            if(integerSet.contains (num)){
                interSet.add (num);
            }
        }
        int[] num3 = new int[interSet.size ()];
        int i=0;
        for(int num: interSet){
            num3[i++] = num;
        }
        return num3;
    }
}
