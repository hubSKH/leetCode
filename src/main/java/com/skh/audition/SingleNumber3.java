package audition;

/**
 * 面试题56 - II. 数组中数字出现的次数 II
 * @Description
 * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
 * @auther SHENKAIHUAN
 *
 * 输入：nums = [3,4,3,3]
 * 输出：4
 *
 * @create 2020-06-13 17:58
 */
public class SingleNumber3 {
    public static void main(String[] args) {
        int[] nums =new int[]{4,1,4,4};
        System.out.println (singleNumbers (nums));

    }
    public static int singleNumbers(int[] nums) {
        int ones = 0, twos = 0;
        for(int num : nums){
            ones = ones ^ num & ~twos;
            twos = twos ^ num & ~ones;
        }
        return ones;

    }
}
