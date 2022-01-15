package leetcode.string;

/**
 * 151. 翻转字符串里的单词
 *
 * @Description 给定一个字符串，逐个翻转字符串中的每个单词。
 * 说明：
 * 无空格字符构成一个 单词 。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * 
 * 输入："the sky is blue"
 * 输出："blue is sky the"
 * @auther SHENKAIHUAN
 * @create 2021-04-17 18:25
 */
public class ReverseWords {
    public static void main(String[] args) {
        String s = "Let's take LeetCode  contest";
        long start = System.currentTimeMillis ();
        System.out.println (reverseWords (s));
        long end = System.currentTimeMillis ();
        System.out.println ("total:" + (end - start));
    }

    public static String reverseWords(String s) {
        if (s == null) return null;
        s = s.trim ();
        char[] chars = s.toCharArray ();
        int i = s.length () - 1, j = s.length () - 1;
        StringBuilder sb = new StringBuilder ();
        while (i >= 0) {
            while (i >= 0 && chars[i] != ' ') i--;
            sb.append (chars, i + 1, j - i).append (' ');
            while (i >= 0 && chars[i] == ' ') i--;
            j = i;
        }
        return sb.toString ().trim ();
    }
}
