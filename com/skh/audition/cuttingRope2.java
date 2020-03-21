package audition;

/**
 * 面试题14- II. 剪绳子 II
 * @Description
 * 给你一根长度为 n 的绳子，
 * 请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为 k[0],k[1]...k[m] 。
 * 请问 k[0]*k[1]*...*k[m] 可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，
 * 我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1
 * @auther SHENKAIHUAN
 * @create 2020-03-21 19:58
 */
public class cuttingRope2 {
    public static void main(String[] args) {
        int n =120;
        long start =System.currentTimeMillis ();
        System.out.println (cuttingRope(n));
        long end =System.currentTimeMillis ();
        System.out.println ("total:"+(end-start));

    }
    public static int cuttingRope(int n) {
        if(n<=3){
            return n-1;
        }
        int mod= (int) (1e9+7);
        long  result =1;
        while (n>4){
            result *= 3;
            result %= mod;
            n -= 3;
        }
        return (int) (result*n%mod);

    }
}
