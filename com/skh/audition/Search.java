package audition;

/**
 * 面试题53 - I. 在排序数组中查找数字 I
 * @Description
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 * 统计一个数字在排序数组中出现的次数。
 * @auther SHENKAIHUAN
 * @create 2020-06-06 17:05
 */
public class Search {
    public static void main(String[] args) {
        int[] nums =new int[]{5,7,7,8,8,10};
        int target = 7;
        System.out.println (search (nums,target));

    }
    public static int search(int[] nums, int target) {
        return halfSerach (nums,target)-halfSerach (nums,target-1);

    }
    public static int halfSerach(int[] nums,int target){
        int i=0,j=nums.length-1;
        while (i<=j){
            int mid=(i+j)/2;
            if(nums[mid]<=target) i=mid+1;
            else j=mid-1;
        }
        return i;
    }
}
