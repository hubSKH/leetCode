package leetcode.array;

/**
 * 31. 下一个排列
 * @Description
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * 必须原地修改，只允许使用额外常数空间。
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 * @auther SHENKAIHUAN
 * @create 2019-10-06 22:03
 */
public class NextPermutation {
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,2};
        long start =System.currentTimeMillis ();
        nextPermutation(nums);
        long end =System.currentTimeMillis ();
        for (int num : nums){
            System.out.print(num +", ");
        }
        System.out.println ();
        System.out.println ("total:"+(end-start));
    }

    public static void nextPermutation(int[] nums) {

        int i=nums.length-1;
        for(;i>0;i--){
            //从后往前判断
            if(nums[i-1]<nums[i]){
                break;
            }
        }
        if(i>0){
            int j=nums.length-1;
            for(;j>i-1;j--){
                //从后往前，当j大于i-1的数，交换位置
                if(nums[j]>nums[i-1]){
                    swap (nums,i-1,j);
                    break;
                }
            }
        }
        //翻转数组，从i的位置开始
        for(int k=nums.length-1;i<k;i++,k--){
            swap (nums,i,k);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp =nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

}
