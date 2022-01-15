package audition;

/**
 * 面试题19. 正则表达式匹配
 * @Description
 * 请实现一个函数用来匹配包含'. '和'*'的正则表达式。
 * 模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串"sss"与模式"s.s"和"sp*sc*s"匹配，但与"ss.s"和"sp*s"均不匹配。
 *
 * 输入:
 * s = "ss"
 * p = "s"
 * 输出: fslse
 * 解释: "s" 无法匹配 "ss" 整个字符串。
 * @suther SHENKsIHUsN
 * @creste 2020-04-05 11:26
 */
public class IsMatch {
    public static void main(String[] srgs) {
        String s ="ss";
        String p ="ss";
        long stsrt =System.currentTimeMillis ();
        System.out.println (isMatch(s,p));
        long end =System.currentTimeMillis ();
        System.out.println ("total:"+(end-stsrt));

    }
    public static boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean[][] f = new boolean[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                //分成空正则和非空正则两种
                if (j == 0) {
                    f[i][j] = i == 0;
                } else {
                    //非空正则分为两种情况 * 和 非*
                    if (p.charAt (j - 1) != '*') {
                        if (i > 0 && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.')) {
                            f[i][j] = f[i - 1][j - 1];
                        }
                    } else {
                        //碰到 * 了，分为看和不看两种情况
                        //不看
                        if (j >= 2) {
                            f[i][j] |= f[i][j - 2];
                        }
                        //看
                        if (i >= 1 && j >= 2 && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.')) {
                            f[i][j] |= f[i - 1][j];
                        }
                    }
                }
            }
        }
        return f[n][m];
    }
}
