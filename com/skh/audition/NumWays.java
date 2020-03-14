package audition;

/**
 * 面试题10- II. 青蛙跳台阶问题
 * @Description
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * 输入：n = 2
 * 输出：2
 * @auther SHENKAIHUAN
 * @create 2020-03-05 23:21
 */
public class NumWays {

    public static void main(String[] args) {
        int n=7;
        long start = System.currentTimeMillis ();
        System.out.println (numWays(n));
        long end = System.currentTimeMillis ();
        System.out.println ("total:"+(end-start));
    }

    public static int numWays(int n) {
        int a=1;
        int b=1;
        for (int i=2;i<=n;i++){
            int sum= (a+b)%1000000007;
            b=a;
            a=sum;
        }
        return a;
    }
}
