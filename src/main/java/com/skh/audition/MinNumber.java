package audition;

/**
 * 面试题45. 把数组排成最小的数
 * @Description
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 *
 * 输入: [10,2]
 * 输出: "102"
 *
 * @auther SHENKAIHUAN
 * @create 2020-05-16 18:11
 */
public class MinNumber {
    public static void main(String[] args) {

        int[] nums=new int[]{1,2,3,1};
        System.out.println (minNumber (nums));

    }
    public static String minNumber(int[] nums) {
        String[] numStrings =new String[nums.length];
        for(int i=0;i<nums.length;i++){
            numStrings[i] = String.valueOf (nums[i]);
        }
        quickSort(numStrings,0,nums.length-1);
        StringBuilder sb =new StringBuilder ();
        for(int i=0;i<numStrings.length;i++){
            sb.append (numStrings[i]);
        }
        return sb.toString ();

    }

    private static void quickSort(String[] strs, int i, int j) {
        if(i>j) return;
        int low=i,high=j;
        String temp=strs[low];
        while (low<high){
            while ((strs[high]+strs[i]).compareTo (strs[i]+strs[high])>=0 && low<high) high--;
            while ((strs[low]+strs[i]).compareTo (strs[i]+strs[low])<=0 && low<high) low++;
            temp=strs[low];
            strs[low]=strs[high];
            strs[high]=temp;
        }
        strs[low] =strs[i];
        strs[i]=temp;
        quickSort (strs,i,low-1);
        quickSort (strs,low+1,j);
    }
}
