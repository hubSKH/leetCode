package audition;

/**
 * 剑指 Offer 57. 和为s的两个数字
 * @Description
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，
 * 使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
 *
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[2,7] 或者 [7,2]
 * @auther SHENKAIHUAN
 * @create 2020-06-20 13:48
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] array = {2,7,11,15};
        int target = 26;
        int[] indices =twoSum(array,target);
        for (int i : indices){
            System.out.print(i+", ");
        }
        System.out.println ();
    }

    private static int[] twoSum(int[] nums, int target) {
        int left= 0;
        int right= nums.length-1;
        while (left< right){
            int sum =nums[left] + nums[right];
            if (sum > target){
                right--;
            }else if(sum < target){
                left++;
            }else {
                return new int[]{nums[left], nums[right]};
            }
        }
        return  null;
    }
}
