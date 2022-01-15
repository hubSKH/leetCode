package leetcode.dynamic;

/**
 * 474. 一和零
 * @Description
 * 在计算机界中，我们总是追求用有限的资源获取最大的收益。
 * 现在，假设你分别支配着 m 个?0?和 n 个?1。另外，还有一个仅包含?0?和?1?字符串的数组。
 * 你的任务是使用给定的?m 个?0?和 n 个?1?，找到能拼出存在于数组中的字符串的最大数量。每个?0?和?1?至多被使用一次。
 * 注意:
 * 给定?0?和?1?的数量都不会超过?100。
 * 给定字符串数组的长度不会超过?600。
 *
 * 输入: Array = {"10", "0001", "111001", "1", "0"}, m = 5, n = 3
 * 输出: 4
 * 解释: 总共 4 个字符串可以通过 5 个 0 和 3 个 1 拼出，即 "10","0001","1","0" 。
 * @auther SHENKAIHUAN
 * @create 2020-09-19 21:32
 */
public class FindMaxForm {
    public static void main(String[] args) {
        String[] strs=new String[]{"10", "0001", "111001", "1", "0"};
        int m=5,n=3;
        System.out.println (findMaxForm (strs,m,n));

    }
    public static int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String s: strs) {
            int[] count = countzeroesones(s);
            for (int zeroes = m; zeroes >= count[0]; zeroes--)
                for (int ones = n; ones >= count[1]; ones--)
                    dp[zeroes][ones] = Math.max(1 + dp[zeroes - count[0]][ones - count[1]], dp[zeroes][ones]);
        }
        return dp[m][n];
    }
    public static int[] countzeroesones(String s) {
        int[] c = new int[2];
        for (int i = 0; i < s.length(); i++) {
            c[s.charAt(i)-'0']++;
        }
        return c;
    }
}
