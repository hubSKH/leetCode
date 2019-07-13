package leetcode;

/**
 * @Description
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 *
 * @auther SHENKAIHUAN
 * @create 2019-07-10 22:15
 */
public class RotateArray {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7};
        int k=3;
        long start =System.currentTimeMillis ();
        for (int i:nums){
            System.out.print(i+", ");
        }
        System.out.println ();
        rotate (nums,k);
        for (int i:nums){
            System.out.print(i+", ");
        }
        System.out.println ();
        long end =System.currentTimeMillis ();
        System.out.println ("total:"+(end-start));
    }

    public static void rotate(int[] nums, int k) {

        int temp;
        int length=nums.length;
        for (int i = 0; i < k; i++) {
             temp =nums[length-1];
            for(int j=length-1;j>0;j--){
                nums[j] =nums[j-1];
            }
            nums[0]=temp;
        }

    }
}
