package leetcode.array;

/**
 * @Description
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 *
 * @auther SHENKAIHUAN
 * @create 2019-07-27 16:01
 */
public class MergeSortArray {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 =new int[]{2,5,6};
        int m=3;
        System.out.println ("======brefore merge=======");
        for (int i:nums1){
            System.out.print(i+", ");
        }
        System.out.println ();
        long start =System.currentTimeMillis ();
        merge(nums1,m,nums2,nums2.length);
        long end =System.currentTimeMillis ();
        System.out.println ("======after merge=======");
        for (int i:nums1){
            System.out.print(i+", ");
        }
        System.out.println ();
        System.out.println ("total:"+(end-start));
    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        //数组2整体移动到数组1后面
        for(int i=0;i<n;i++){
            nums1[m+i] = nums2[i];
        }
        //进行排序
        quickSort(nums1,0,m+n-1);
    }

    /**
     * 快速排序
     * @param nums1
     * @param low
     * @param hight
     */
    private static void quickSort(int[] nums1, int low, int hight) {

        if(low>hight){
            return;
        }
        int i=low;
        int j=hight;
        int base = nums1[low];
        while (i<j){
            while (nums1[j]>=base && i<j){
                j--;
            }
            nums1[i] =nums1[j];
            while (nums1[i]<=base && i<j){
                i++;
            }
            nums1[j]=nums1[i];
        }
        nums1[i] =base;

        quickSort (nums1,low,j-1);
        quickSort (nums1,j+1,hight);

    }
}
