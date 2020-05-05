package audition;

/**
 * 面试题39. 数组中出现次数超过一半的数字
 * @Description
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
 * 输出: 2
 * @auther SHENKAIHUAN
 * @create 2020-05-05 15:42
 */
public class MajorityElement {
    public static void main(String[] args) {
        int[] nums=new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2};
        long start = System.currentTimeMillis ();
        System.out.println (majorityElement(nums));
        long end =System.currentTimeMillis ();
        System.out.println ("total:"+(end-start));
    }
    public static int majorityElement(int[] nums) {
        int num = 0;
        int vote =0;
        for(int i=0;i<nums.length;i++){
            if(vote==0) num=nums[i];
            vote+= num==nums[i]?1:-1;
        }
        return num;

    }
}
