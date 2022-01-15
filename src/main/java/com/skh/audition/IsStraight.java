package audition;

import java.util.HashSet;
import java.util.Set;

/**
 * 剑指 Offer 61. 扑克牌中的顺子
 * @Description
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。
 * 2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 *
 * 输入: [1,2,3,4,5]
 * 输出: True
 * @auther SHENKAIHUAN
 * @create 2020-06-26 0:08
 */
public class IsStraight {
    public static void main(String[] args) {
        int[] nums =new int[]{8,2,3,4,5};
        System.out.println (isStraight (nums));

    }
    public static boolean isStraight(int[] nums) {
        Set<Integer> set =new HashSet<> ();
        int max=0,min=14;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0) continue;
            if(!set.add (nums[i])) return false;
             max=Math.max (max,nums[i]);
             min=Math.min (min,nums[i]);
        }
        return max-min<5;

    }
}
