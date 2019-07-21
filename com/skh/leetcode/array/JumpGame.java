package leetcode.array;

/**
 * @Description
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个位置。
 *
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 从位置 0 到 1 跳 1 步, 然后跳 3 步到达最后一个位置。
 *
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 *
 * @auther SHENKAIHUAN
 * @create 2019-07-21 1:05
 */
public class JumpGame {
    public static void main(String[] args) {
        int[]  nums = new int[]{2,0,0};
        long start = System.currentTimeMillis ();
        System.out.println (canJump (nums));
        long end = System.currentTimeMillis ();
        System.out.println ("total:" + (end - start));
    }

    public static boolean canJump(int[] nums) {
       /*//动态规划，低效
        if(nums.length<2){
            return true;
        }
        return  judge(nums,0);*/

       //贪心算法
        int lastIdx =nums.length-1;
        for(int i = nums.length-1;i>=0;i--){
            if(nums[i]+i>=lastIdx){
                lastIdx = i;
            }
        }
        return lastIdx==0;
    }

    /**
     * 动态规划，低效
     * @param nums
     * @param i
     * @return
     */
    private static boolean judge(int[] nums, int i) {
        if(i>=nums.length-1){
            return true;
        }
        for (int j =1;j<=nums[i];j++){
           if(judge (nums,i+j)){
               return true;
            }
        }
        return false;
    }
}
