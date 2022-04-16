package leetcode.number;

/**
 * 7. 整数反转
 * <p>
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 * <p>
 * 输入：x = 123
 * 输出：321
 * <p>
 * 输入：x = -123
 * 输出：-321
 *
 * @auther SHENKAIHUAN
 * @create 2022/4/16 16:06
 */
public class Reverse {
    public static void main(String[] args) {
        int x = Integer.MAX_VALUE;
        System.out.println(new Reverse().reverse(x));
    }

    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            if (result < Integer.MIN_VALUE / 10 || result > Integer.MAX_VALUE / 10) return 0;
            int dig = x % 10;
            x /= 10;
            result = result * 10 + dig;
        }
        return result;
    }
}
