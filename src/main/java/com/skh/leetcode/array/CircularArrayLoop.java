package leetcode.array;

/**
 * 457. 环形数组是否存在循环
 *
 * @Description 存在一个不含 0 的 环形 数组 nums ，每个 nums[i] 都表示位于下标 i 的角色应该向前或向后移动的下标个数：
 * 如果 nums[i] 是正数，向前（下标递增方向）移动 |nums[i]| 步
 * 如果 nums[i] 是负数，向后（下标递减方向）移动 |nums[i]| 步
 * 因为数组是 环形 的，所以可以假设从最后一个元素向前移动一步会到达第一个元素，而第一个元素向后移动一步会到达最后一个元素。
 * 数组中的 循环 由长度为 k 的下标序列 seq 标识：
 * 遵循上述移动规则将导致一组重复下标序列 seq[0] -> seq[1] -> ... -> seq[k - 1] -> seq[0] -> ...
 * 所有 nums[seq[j]] 应当不是 全正 就是 全负
 * k > 1
 * 如果 nums 中存在循环，返回 true ；否则，返回 false 。
 * <p>
 * 输入：nums = [2,-1,1,2,2]
 * 输出：true
 * 解释：存在循环，按下标 0 -> 2 -> 3 -> 0 。循环长度为 3 。
 * @auther SHENKAIHUAN
 * @create 2022/6/25 16:09
 */
public class CircularArrayLoop {
    public static void main(String[] args) {
        int[] nums = {2, -1, 1, 2, 2};
        System.out.println(new CircularArrayLoop().circularArrayLoop(nums));

    }

    public boolean circularArrayLoop(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==0) continue;
            int slow = i, fast = next(nums, slow);
            while (nums[slow] * nums[fast] > 0 && nums[slow] * nums[next(nums, fast)] > 0) {
                if (slow == fast) {
                    if (slow != next(nums, slow)) {
                        return true;
                    } else {
                        break;
                    }
                }
                slow = next(nums, slow);
                fast = next(nums, next(nums, fast));
            }
            //排除 走过的链路
            int head =i;
            while (nums[head]* nums[next(nums,head)]>0){
                int tmp=head;
                head=next(nums,head);
                nums[tmp]=0;
            }
        }
        return false;
    }

    private int next(int[] nums, int slow) {
        int n =nums.length;
        int next =(slow+nums[slow])%n;
        if(next<0) next =(next+n)%n;
        return next;
    }
}
