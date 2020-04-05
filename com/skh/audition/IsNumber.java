package audition;

/**
 * 面试题20. 表示数值的字符串
 * @Description
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"0123"及"-1E-16"都表示数值，
 * 但"12e"、"1a3.14"、"1.2.3"、"+-5"及"12e+5.4"都不是。
 *
 * @auther SHENKAIHUAN
 * @create 2020-04-05 15:15
 */
public class IsNumber {
    public static void main(String[] args) {
        String s= "3.1416";
        long start =System.currentTimeMillis ();
        System.out.println (isNumber(s));
        long end =System.currentTimeMillis ();
        System.out.println ("total:"+(end-start));
    }

    /**
     * 有限状态机（DFA)
     * @param s
     * @return
     */
    public static boolean isNumber(String s) {
        int state = 0;
        int finals = 0b101101000;
        int[][] transfer = new int[][]{
                { 0, 1, 6, 2,-1},
                {-1,-1, 6, 2,-1},
                {-1,-1, 3,-1,-1},
                { 8,-1, 3,-1, 4},
                {-1, 7, 5,-1,-1},
                { 8,-1, 5,-1,-1},
                { 8,-1, 6, 3, 4},
                {-1,-1, 5,-1,-1},
                { 8,-1,-1,-1,-1}};
        char[] ss = s.toCharArray();
        for(int i=0; i < ss.length; ++i) {
            int id = make(ss[i]);
            if (id < 0) return false;
            state = transfer[state][id];
            if (state < 0) return false;
        }
        return (finals & (1 << state)) > 0;

    }

    private static int make(char c) {
        switch(c) {
            case ' ': return 0;
            case '+':
            case '-': return 1;
            case '.': return 3;
            case 'e':
            case 'E': return 4;
            default:
                if(c >= 48 && c <= 57) return 2;
        }
        return -1;
    }
}
