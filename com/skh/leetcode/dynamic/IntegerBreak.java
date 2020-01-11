package leetcode.dynamic;

/**
 * 343. 整数拆分
 * @Description
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，
 * 并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 *
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 *
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 * @auther SHENKAIHUAN
 * @create 2020-01-11 14:31
 */
public class IntegerBreak {
    public static void main(String[] args) {
        int n= 10;
        long start =System.currentTimeMillis ();
        System.out.println (integerBreak(n));
        long end =System.currentTimeMillis ();
        System.out.println ("total:"+(end-start));

    }
    public static int integerBreak(int n) {

        if(n<=3){
            return n-1;
        }
        int p = n%3;
        int k = n/3;
        int multi = p+(2*p+1)%5;
        k = k - (p&1);
        return (int) (Math.pow (3,k)*multi);

    }
}
