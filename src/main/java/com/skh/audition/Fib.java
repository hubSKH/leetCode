package audition;


/**
 * 面试题10- I. 斐波那契数列
 * @Description
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。斐波那契数列的定义如下：
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 *
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * 输入：n = 2
 * 输出：1
 * @auther SHENKAIHUAN
 * @create 2020-03-02 21:52
 */
public class Fib {

    public static void main(String[] args) {
        int n=84;
        long start =System.currentTimeMillis ();
        System.out.println (fib(n));
        long end =System.currentTimeMillis ();
        System.out.println ("total:"+(end-start));
    }

    public static int fib(int n) {
        int a = 0, b = 1, sum;
        for(int i = 0; i < n; i++){
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;

//        if(n<2) return n;
//        int[] fb =new int[n+1];
//        fb[1]=1;
//        for (int i=2;i<=n;i++){
//            fb[i]= (int) (fb[i-1]+fb[i-2]%(1e9+7));
//        }
//        return fb[n];
    }

}
