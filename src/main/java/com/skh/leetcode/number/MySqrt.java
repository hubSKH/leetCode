package leetcode.number;

/**
 * 69. x 的平方根
 *
 * @Description 实现 int sqrt(int x) 函数。
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * <p>
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 * 由于返回类型是整数，小数部分将被舍去。
 * @auther SHENKAIHUAN
 * @create 2021-08-22 22:53
 */
public class MySqrt {
    public static void main(String[] args) {
        int x = 8;
        System.out.println (new MySqrt ().mySqrt (x));
    }

    public int mySqrt(int x) {
        if (x == 0) return x;
        int left = 1, right = x;
        int mid, sqrt;
        while (left <= right) {
            mid = left + (right - left) / 2;
            sqrt = x / mid;
            if (sqrt == mid) {
                return mid;
            } else if (sqrt > mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }
}
