package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description
 * 给定一个整数数组，判断是否存在重复元素。
 * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 *
 * 输入: [1,2,3,1]
 * 输出: true
 *
 * 输入: [1,2,3,4]
 * 输出: false
 *
 * @auther SHENKAIHUAN
 * @create 2019-07-18 23:15
 */
public class RepeateElement {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,1};
        long start =System.currentTimeMillis ();
        System.out.println (containsDuplicate (nums));
        long end =System.currentTimeMillis ();
        System.out.println ("total:"+(end-start));
    }


    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> integerSet =new HashSet<> ();
        for(int num :nums){
            if(!integerSet.add (num)){
                return true;
            }
        }
        return  false;
    }
}
