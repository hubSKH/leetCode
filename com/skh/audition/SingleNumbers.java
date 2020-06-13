package audition;

import java.util.*;

/**
 * 面试题56 - I. 数组中数字出现的次数
 * @Description
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 *
 * 输入：nums = [4,1,4,6]
 * 输出：[1,6] 或 [6,1]
 * @auther SHENKAIHUAN
 * @create 2020-06-13 15:05
 */
public class SingleNumbers {
    public static void main(String[] args) {
        int[] nums =new int[]{4,1,4,6};
        System.out.println (Arrays.toString (singleNumbers (nums)));

    }
    public static int[] singleNumbers(int[] nums) {
        int mix = 0;
        for (int num: nums){
            mix ^=num;
        }
        int mask = 1;
        while((mix & mask) == 0) {
            mask <<= 1;
        }
        int a = 0;
        int b = 0;

        for(int num: nums) {
            if((num & mask) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }

        return new int[]{a, b};
    }
}
