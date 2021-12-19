package leetcode.number;

/**
 * 29. 两数相除
 *
 * @Description 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 * <p>
 * 提示：
 * 被除数和除数均为 32 位有符号整数。
 * 除数不为 0。
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−2^31, 2^31− 1]。本题中，如果除法结果溢出，则返回 2^31− 1。
 * <p>
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
 * @auther SHENKAIHUAN
 * @create 2021-12-18 10:28
 */
public class Divide {

    public static void main(String[] args) {
        int dividend = -2147483648;
        int divisor = 2147483647;
        System.out.println (new Divide ().divide (dividend, divisor));
    }

    public int divide(int dividend, int divisor) {
        // 被除数最小的情况
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == 1) {
                return Integer.MIN_VALUE;
            } else if (divisor == -1) {
                return Integer.MAX_VALUE;
            }
        }
        // 除数最大的情况
        if (divisor == Integer.MAX_VALUE) {
            return dividend == Integer.MAX_VALUE ? 1 : dividend == Integer.MIN_VALUE ? -1 : 0;
        } else if (divisor == 0) {
            // 除数为0
            return 0;
        }
        // 最后结果正负
        boolean neg = false;
        // 所有正数转负数，只考虑一种情况
        if (dividend > 0) {
            dividend = -dividend;
            neg = !neg;
        }
        if (divisor > 0) {
            divisor = -divisor;
            neg = !neg;
        }
        int left = 1, right = Integer.MAX_VALUE;
        int result = 0;
        while (left <= right) {
            // 避免溢出
            int mid = left + ((right - left) >> 1);
            boolean check = quickAdd (divisor, mid, dividend);
            if (check) {
                result = mid;
                if (mid == Integer.MAX_VALUE) {
                    break;
                }
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return neg ? -result : result;
    }

    private boolean quickAdd(int y, int z, int x) {
        int result = 0, add = y;
        while (z != 0) {
            if ((z & 1) != 0) {
                // 奇数
                if (result < x - add) {
                    // 保证 result+add>=x
                    return false;
                }
                result += add;
            }
            if (z != 1) {
                if (add < x - add) {
                    // 保证 add+add>=x
                    return false;
                }
                add += add;
            }
            // 除以2
            z >>= 1;
        }
        return true;
    }
}
