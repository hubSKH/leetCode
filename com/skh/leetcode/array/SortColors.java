package leetcode.array;

import java.util.Arrays;

/**
 * @Description
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 *
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 *
 * @auther SHENKAIHUAN
 * @create 2019-07-22 23:02
 */
public class SortColors {
    public static void main(String[] args) {
        int[] nums = new int[]{2,0,2,1,1,0};
        for (int i:nums){
            System.out.print(i+", ");
        }
        System.out.println ();
        long start =System.currentTimeMillis ();
        sortColors(nums);
        long end =System.currentTimeMillis ();
        System.out.println ("total:"+(end-start));
        for (int i:nums){
            System.out.print(i+", ");
        }
        System.out.println ();
    }

    public static void sortColors(int[] nums) {

        quickSort(nums,0,nums.length-1);

    }

    /**
     * 快速排序
     * @param nums
     * @param low
     * @param hight
     */
    private static void quickSort(int[] nums, int low, int hight) {
        if(low>hight){
            return;
        }
        int i=low;
        int j =hight;
        int temp =nums[i];
        while (i<j){
            //先排右部分数组
            while (nums[j]>=temp && i<j){
                j--;
            }
            //比基准小的放左边
            nums[i] = nums[j];
            //后排左部分数组
            while (nums[i]<=temp && i<j){
                i++;
            }
            //比基准大的放右边
            nums[j] = nums[i];

        }
        nums[i] = temp;
        quickSort (nums,low,j-1);
        quickSort (nums,j+1,hight);

        return;
    }
}
