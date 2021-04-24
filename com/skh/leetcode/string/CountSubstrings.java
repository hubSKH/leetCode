package leetcode.string;

/**
 * 647. 回文子串
 *
 * @Description 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 *
 * 输入："abc"
 * 输出：3
 * 解释：三个回文子串: "a", "b", "c"
 * @auther SHENKAIHUAN
 * @create 2021-04-24 11:06
 */
public class CountSubstrings {
    public static void main(String[] args) {
        String s = "aaa";
        System.out.println (countSubstrings (s));

    }

    public static int countSubstrings(String s) {
        int result = 0;
        int len = s.length ();
        for (int i = 0; i < 2 * len - 1; i++) {
            int left = i / 2, right = i / 2 + i % 2;
            while (left >= 0 && right < len && s.charAt (left) == s.charAt (right)) {
                left--;
                right++;
                result++;
            }
        }
        return result;
    }
}
