package audition;

/**
 * 面试题15. 二进制中1的个数
 *
 * @Description 请实现一个函数，输入一个整数，输出该数二进制表示中 1 的个数。\
 * 例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。
 * <p>
 * 输入：00000000000000000000000000001011
 * 输出：3
 * 解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
 * @auther SHENKAIHUAN
 * @create 2020-04-04 10:38
 */
public class HammingWeight {
    public static void main(String[] args) {
        int n = 9;
        long start = System.currentTimeMillis ();
        System.out.println (hammingWeight (n));
        long end = System.currentTimeMillis ();
        System.out.println ("total:" + (end - start));
    }

    //    // you need to treat n as an unsigned value
//    public static int hammingWeight(int n) {
//
//        int count =0;
//        while (n!=0){
//            count+= n&1;
//            n=n>>>1;
//        }
//        return count;
//    }
// you need to treat n as an unsigned value
    public static int hammingWeight(int n) {

        int count = 0;
        while (n != 0) {
            count ++;
            n = n & (n-1);
        }
        return count;
    }
}
