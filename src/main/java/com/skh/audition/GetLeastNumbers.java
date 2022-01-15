package audition;

import java.util.Arrays;

/**
 * 面试题40. 最小的k个数
 * @Description
 * 输入整数数组 arr ，找出其中最小的 k 个数。
 * 例如，输入4、5、1、6、2、7、3、8这8个数字，
 * 则最小的4个数字是1、2、3、4。
 * @auther SHENKAIHUAN
 * @create 2020-05-06 21:41
 */
public class GetLeastNumbers {
    public static void main(String[] args) {
        int[] nums =new int[]{3,2,1,0,5,7,9};
        int k=2;
        int[] leastNumbers = getLeastNumbers (nums, k);
        System.out.println ();

    }
    public static int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        return quickSelect(arr,0,arr.length-1,k-1);

    }
    private static int[] quickSelect(int[] nums, int low, int hight, int pos) {
        int pov_idx = position(nums,low,hight);
        if (pov_idx == pos) {
            return Arrays.copyOf (nums, pov_idx + 1);
        } else if (pov_idx > pos) {
            return quickSelect (nums, low, pov_idx - 1, pos);
        } else {
            return quickSelect (nums,pov_idx+1,hight,pos);
        }
    }

    /**
     *
     * @param nums
     * @param low
     * @param hight
     * @return
     */
    private static int position(int[] nums, int low, int hight) {

        int num =nums[low];
        int store_idx = low,j=hight+1;
        while (true){
            while (++store_idx <=hight && nums[store_idx]<num);
            while (--j >=low && nums[j]>num);
            if(store_idx>=j) break;
            int temp=nums[store_idx];
            nums[store_idx]=nums[j];
            nums[j]=temp;
        }
        nums[low] =nums[j];
        nums[j] =num;
        return j;
    }

}
