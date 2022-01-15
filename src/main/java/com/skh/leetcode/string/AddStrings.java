package leetcode.string;

/**
 * 415. 字符串相加
 * @Description
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 * num1 和num2 的长度都小于 5100.
 * num1 和num2 都只包含数字 0-9.
 * num1 和num2 都不包含任何前导零。
 * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。
 *
 * @auther SHENKAIHUAN
 * @create 2019-08-29 0:22
 */
public class AddStrings {
    public static void main(String[] args) {
        String num1="1";
        String num2="9";
        long start = System.currentTimeMillis ();
        System.out.println (addStrings (num1,num2));
        long end =System.currentTimeMillis ();
        System.out.println ("total:"+(end-start));
    }
    public static String addStrings(String num1, String num2) {
        int n1Length = num1.length ();
        int n2Length = num2.length ();
        //进位
        int up = 0;
        int i = n1Length-1;
        int j =n2Length-1;
        char[] chars1= num1.toCharArray ();
        char[] chars2 =num2.toCharArray ();
        StringBuilder sb = new StringBuilder ();
        while (i>=0 || j>=0){
            int n1 = i <0? 0: (chars1[i]-'0');
            int n2 = j <0? 0: (chars2[j]-'0');
            int sum = n1+n2+up;
            sb.append (sum%10);
            up=sum/10;
            i--;
            j--;
        }
        if(up>0){
            sb.append (up);
        }
        return sb.reverse ().toString ();
    }
}
