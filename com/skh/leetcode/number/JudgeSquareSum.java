package leetcode.number;

/**
 * 633. 平方数之和
 *
 * @Description 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c。
 * <p>
 * 输入：c = 5
 * 输出：true
 * 解释：1 * 1 + 2 * 2 = 5
 * @auther SHENKAIHUAN
 * @create 2021-08-14 14:39
 */
public class JudgeSquareSum {
    public static void main(String[] args) {
        int num = 4;
        JudgeSquareSum judgeSquareSum = new JudgeSquareSum ();
        System.out.println (judgeSquareSum.judgeSquareSum (num));
    }

    public boolean judgeSquareSum(int c) {
        int left = 0, right = (int) Math.sqrt (c);
        while (right >= left) {
            int square = right * right + left * left;
            if (square == c) {
                return true;
            } else if (square > c) {
                right--;
            } else {
                left++;
            }
        }
        return false;
    }
}
