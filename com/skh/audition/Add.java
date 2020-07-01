package audition;

/**
 * 剑指 Offer 65. 不用加减乘除做加法
 * @Description
 * 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
 * @auther SHENKAIHUAN
 * 输入: a = 1, b = 1
 * 输出: 2
 * @create 2020-07-01 22:15
 */
public class Add {
    public static void main(String[] args) {
        int a=1;
        int b=1;
        System.out.println (add(a,b));
    }
    public static int add(int a, int b) {
        while (b!=0){
            int c= (a&b) <<1;
            a^=b;
            b=c;
        }
        return a;
    }
}
