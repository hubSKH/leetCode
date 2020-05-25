package audition;

/**
 * 面试题64. 求1+2+…+n
 * @Description
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 *
 * 输入: n = 3
 * 输出: 6
 * @auther SHENKAIHUAN
 * @create 2020-05-24 15:08
 */
public class SumNums {
    public static void main(String[] args) {

        int num=3;
        System.out.println (sumNums (num));

    }
    public static int sumNums(int n) {
        int sum=n;
        boolean x= n>0 && (sum+=sumNums (n-1))>0;
        return sum;
    }
}
