package leetcode.array;

/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 * 则中位数是 2.0
 */
public class FindMedianSortedArrays {

    public static void main(String[] args) {
        int[] nums1 = {1,2,3};
        int[] nums2 = {2,5};
        System.out.println (findMedianSortedArrays (nums1,nums2));
    }

//    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        double mid;
//        int n1Len =nums1.length,n2Len=nums2.length ;
//        int[] num3= new int[n1Len+n2Len];
//        for(int i =0;i<nums1.length;i++){
//            num3[i]= nums1[i];
//        }
//        for(int i =0;i<nums2.length;i++){
//            num3[n1Len+i]= nums2[i];
//        }
//        Arrays.sort (num3);
//        int nLen = num3.length;
//        if(nLen%2==0){
//            int up= nLen/2;
//            int low = up-1;
//            mid = (num3[up]+num3[low])/2.0;
//        }else{
//            int ind = (nLen-1)/2;
//            mid = num3[ind]/1.0;
//        }
//        return  mid;
//    }

    public static double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) { // to ensure m<=n
            int[] temp = A; A = B; B = temp;
            int tmp = m; m = n; n = tmp;
        }
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && B[j-1] > A[i]){
                iMin = i + 1; // i is too small
            }
            else if (i > iMin && A[i-1] > B[j]) {
                iMax = i - 1; // i is too big
            }
            else { // i is perfect
                int maxLeft = 0;
                if (i == 0) { maxLeft = B[j-1]; }
                else if (j == 0) { maxLeft = A[i-1]; }
                else { maxLeft = Math.max(A[i-1], B[j-1]); }
                if ( (m + n) % 2 == 1 ) { return maxLeft; }

                int minRight = 0;
                if (i == m) { minRight = B[j]; }
                else if (j == n) { minRight = A[i]; }
                else { minRight = Math.min(B[j], A[i]); }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }
}
