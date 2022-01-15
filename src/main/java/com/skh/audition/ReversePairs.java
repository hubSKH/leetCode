package audition;

/**
 * 剑指 Offer 51. 数组中的逆序对
 * @Description
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组，求出这个数组中的逆序对的总数。
 *
 * 输入: [7,5,6,4]
 * 输出: 5
 * @auther SHENKAIHUAN
 * @create 2020-07-20 21:30
 */
public class ReversePairs {
    public static void main(String[] args) {
        int[] nums =new int[]{7,5,6,4};
         System.out.println (reversePairs (nums));
    }



    public static int reversePairs(int[] nums) {

        if (nums.length<2) return 0;
        int len =nums.length;
        int[] copy =nums.clone ();
        int[] temp=new int[len];
        return reversePairs (copy,0,len-1,temp);

    }

    private static int reversePairs(int[] copy, int left, int right, int[] temp) {
        if (left==right) return 0;
        int mid = left+(right-left)/2;
        int leftPairs = reversePairs (copy,left,mid,temp);
        int rightPairs =reversePairs (copy,mid+1,right,temp);
        if(copy[mid]<=copy[mid+1]) return leftPairs+rightPairs;
        int crossPairs = mergeAndCount(copy,left,mid,right,temp);
        return leftPairs+rightPairs+crossPairs;
    }

    private static int mergeAndCount(int[] copy, int left, int mid, int right, int[] temp) {
        System.arraycopy (copy,left,temp,left,right-left+1);

        int i=left;
        int j=mid+1;
        int count =0;
        for(int k=left;k<=right;k++){
            if (i==mid+1){
                copy[k]=temp[j];
                j++;
            }else  if(j==right+1){
                copy[k]=temp[i];
                i++;
            }else if(temp[i]<=temp[j]){
                copy[k]=temp[i];
                i++;
            }else {
                copy[k]=temp[j];
                j++;
                count+=(mid-i+1);
            }
        }
        return count;
    }
}
