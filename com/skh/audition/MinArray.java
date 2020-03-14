package audition;

/**
 * 面试题11. 旋转数组的最小数字
 * @Description
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
 *
 * 输入：[3,4,5,1,2]
 * 输出：1
 *
 * @auther SHENKAIHUAN
 * @create 2020-03-14 10:11
 */
public class MinArray {
    public static void main(String[] args) {
        int[] numbers=new int[]{3,4,5,1,2};
        long start =System.currentTimeMillis ();
        System.out.println (minArray(numbers));
        long end =System.currentTimeMillis ();
        System.out.println ("total:"+(end-start));
    }
    public static int minArray(int[] numbers) {
        for(int i=1;i<numbers.length;i++){
            if(numbers[i]<numbers[i-1]){
                return numbers[i];
            }
        }
        return numbers[0];
    }

}
