package leetcode.string;

/**
 * 680. 验证回文字符串 Ⅱ
 *
 * @Description 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 * <p>
 * 输入: s = "abca"
 * 输出: true
 * 解释: 你可以删除c字符。
 * @auther SHENKAIHUAN
 * @create 2021-08-15 11:11
 */
public class ValidPalindrome {
    public static void main(String[] args) {
        String s = "abca";
        ValidPalindrome validPalindrome = new ValidPalindrome ();
        System.out.println (validPalindrome.validPalindrome (s));
    }

    public boolean validPalindrome(String s) {
        int left = 0, right = s.length () - 1;
        for (; left < right; left++, right--) {
            if (s.charAt (left) != s.charAt (right)) {
                return validPalindrome (s, left + 1, right) || validPalindrome (s, left, right - 1);
            }

        }
        return true;
    }

    private boolean validPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt (i) != s.charAt (j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
