package audition;

/**
 * 面试题46. 把数字翻译成字符串
 * @Description
 * 给定一个数字，我们按照如下规则把它翻译为字符串：
 * 0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，
 * 25 翻译成 “z”。一个数字可能有多个翻译。
 * 请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 *
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 * @auther SHENKAIHUAN
 * @create 2020-05-24 10:16
 */
public class TranslateNum {
    public static void main(String[] args) {
        int num =12258;
        System.out.println (translateNum (num));
    }
    public static int translateNum(int num) {
        String str=String.valueOf (num);
        int a=1,b=1;
        for (int i=2;i<=str.length ();i++){
            String sub =str.substring (i-2,i);
            int c = sub.compareTo ("10") >= 0 && sub.compareTo ("25") <= 0 ? a + b : a;
            b=a;
            a=c;
        }
        return a;
    }
}
