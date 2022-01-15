package leetcode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 *
 * @Description 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 提示：
 * 1 <= n <= 8
 * <p>
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * <p>
 * 输入：n = 1
 * 输出：["()"]
 * @auther SHENKAIHUAN
 * @create 2021-03-01 23:12
 */
public class GenerateParenthesis {
    public static void main(String[] args) {
        int n = 3;
        List<String> result = generateParenthesis (n);
        System.out.println (result);

    }

    public static List<String> generateParenthesis(int n) {
        StringBuilder stringBuilder = new StringBuilder ();
        List<String> result = new ArrayList<> ();
        generateParenthesis (result, stringBuilder, n, 0, 0);
        return result;
    }

    private static void generateParenthesis(List<String> result, StringBuilder sb, int n, int left, int right) {
        if (n * 2 == sb.length ()) {
            result.add (sb.toString ());
            return;
        }
        if (left < n) {
            sb.append ("(");
            generateParenthesis (result, sb, n, left + 1, right);
            // equals whith " sb.deleteCharAt (sb.length () - 1);"
            sb.setLength (sb.length () - 1);
        }
        if (right < left) {
            sb.append (")");
            generateParenthesis (result, sb, n, left, right + 1);
            sb.setLength (sb.length () - 1);
        }
    }
}
