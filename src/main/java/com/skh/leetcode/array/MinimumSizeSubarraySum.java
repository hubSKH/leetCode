package leetcode.array;

/**
 * @Description
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。
 * 如果不存在符合条件的连续子数组，返回 0。
 *
 * 输入: s = 7, nums = [2,3,1,2,4,3]
 * 输出: 2
 * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 * @auther SHENKAIHUAN
 * @create 2019-07-26 0:35
 */
public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        int[] nums = new int[]{2,3,1,2,4,3};
        int s =7;
        for (int i:nums){
            System.out.print(i+", ");
        }
        System.out.println ();
        long start =System.currentTimeMillis ();
        System.out.println (minSubArrayLen(s,nums));
        long end =System.currentTimeMillis ();
        System.out.println ("total:"+(end-start));
    }

    public static int minSubArrayLen(int s, int[] nums) {
        int subSum = 0;
        int minLen=0;
        int q=-1;
        for(int i=0,j=0;j<nums.length;){
            if(q!=j){
                //q==j表示已经加过了
                subSum+= nums[j];
            }
            if(subSum>=s){
                int len = j-i+1;
                if(len<minLen|| minLen ==0){
                    minLen = len;
                }
                q=j;
                //符合条件后，慢指针往前移动，和减去最前面的元素
                subSum-=nums[i];
                i++;
            }else if(j==nums.length-1){
                break;
            }else {
                j++;
            }
        }
        return minLen;
    }
}
