package audition;

import java.util.*;

/**
 * 剑指 Offer 59 - I. 滑动窗口的最大值
 * @Description
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 *
 *   滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * @auther SHENKAIHUAN
 * @create 2020-06-22 20:56
 */
public class MaxSlidingWindow {
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
        int k=3;
        System.out.println (Arrays.toString (maxSlidingWindow (nums,k)));

    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length==0 || k==0) return new int[0];
        Deque<Integer> deque = new LinkedList<> ();
        int[] res = new int[nums.length-k+1];
        for(int j=0,i=1-k;j<nums.length;j++,i++){
            if(i>0 && deque.peekFirst ()==nums[i-1]) deque.removeFirst ();
            while (!deque.isEmpty () && deque.peekLast ()<nums[j]) deque.removeLast ();
            deque.addLast (nums[j]);
            if(i>=0) res[i]= deque.peekFirst ();
        }
        return res;

    }
}
