package leetcode.array;

/**
 * 922. 按奇偶排序数组 II
 * @Description
 * 给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
 * 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
 * 你可以返回任何满足上述条件的数组作为答案。
 *
 * 提示：
 * 2 <= A.length <= 20000
 * A.length % 2 == 0
 * 0 <= A[i] <= 1000
 *
 * 输入：[4,2,5,7]
 * 输出：[4,5,2,7]
 * 解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
 * @auther SHENKAIHUAN
 * @create 2019-10-01 15:10
 */
public class SortArrayByParityII {
    public static void main(String[] args) {
        int[] nums = new int[]{4,2,5,7};
        long start =System.currentTimeMillis ();
        int[] result =sortArrayByParityII (nums);
        long end =System.currentTimeMillis ();
        for (int num : result){
            System.out.print(num+", ");
        }
        System.out.println ();
        System.out.println ("total:"+(end-start));
    }
    public static int[] sortArrayByParityII(int[] A) {

        int even=0;
        int odd=1;
        while (even<A.length || odd<A.length){
            while (even<A.length && A[even]%2==0){
                even+=2;
            }
            while (odd<A.length && A[odd]%2==1){
                odd+=2;
            }
            if(even<A.length && odd<A.length){
                int temp = A[even];
                A[even] =A[odd];
                A[odd]=temp;
                even+=2;
                odd+=2;
            }
        }
        return A;

    }
}
