package MoveZeroes;

/**
 * @Description
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 *
 * @auther SHENKAIHUAN
 * @create 2019-07-13 1:21
 */
public class PlusOne {
    public static void main(String[] args) {
        int[] nums = new int[]{9};
        long start =System.currentTimeMillis ();
        int[] after =plusOne (nums);
        long end =System.currentTimeMillis ();
        System.out.println ("total:"+(end-start));
        for (int i:after){
            System.out.print(i+", ");
        }
        System.out.println();
    }

    public static int[] plusOne(int[] digits) {
        int i=digits.length-1;
        boolean flag =true;
        do{
            int sum = ++digits[i];
            if (sum==10){
                digits[i]=0;
                if(i==0){
                    //最高位进位 扩容
                    int[] result =new int[digits.length+1];
                    System.arraycopy (digits,0,result,1,digits.length);
                    result[0] =1;
                    digits = result;
                    flag =false;
                }else {
                    i--;
                }
            }else {
                flag = false;
            }
        }while (flag);
        return digits;
    }

}
