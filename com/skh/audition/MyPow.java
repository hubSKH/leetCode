package audition;

/**
 * 面试题16. 数值的整数次方
 * @Description
 * 实现函数double Power(double base, int exponent)，求base的exponent次方。
 * 不得使用库函数，同时不需要考虑大数问题。
 *
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * @auther SHENKAIHUAN
 * @create 2020-04-04 14:44
 */
public class MyPow {
    public static void main(String[] args) {
        double x=2.000;
        int n = 2;
        long start = System.currentTimeMillis ();
        System.out.println (myPow (x,n));
        long end = System.currentTimeMillis ();
        System.out.println ("total:" + (end - start));
    }

    public static double myPow(double x, int n) {
        if(x == 0) return 0;
        long b = n;
        double res = 1.0;
        if(b < 0) {
            x = 1 / x;
            b = -b;
        }
        while(b > 0) {
            if((b & 1) == 1) res *= x;
            x *= x;
            b >>= 1;
        }
        return res;
    }
}
