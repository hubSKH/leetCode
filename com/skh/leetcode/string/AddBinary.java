package leetcode.string;

/**
 * 67. 二进制求和
 * @Description
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 * 输入为非空字符串且只包含数字 1 和 0。
 *
 * 输入: a = "11", b = "1"
 * 输出: "100"
 *
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 * @auther SHENKAIHUAN
 * @create 2019-09-08 13:32
 */
public class AddBinary {
    public static void main(String[] args) {

        String a ="11";
        String b="1";
        long start = System.currentTimeMillis ();
        System.out.println (addBinary (a,b));
        long end = System.currentTimeMillis ();
        System.out.println ("total:"+(end-start));

    }

    public static String addBinary(String a, String b) {
        int i= a.length ()-1;
        int j= b.length ()-1;
        StringBuilder sb = new StringBuilder ();
        int up =0;
        while (i>=0||j>=0){
            int anum = i>=0?a.charAt (i)-'0':0;
            int bnum = j>=0?b.charAt (j)-'0':0;

            int sum=anum+bnum+up;
            sb.append (sum%2);
            up=sum/2;
            i--;
            j--;
        }
        if(up>0){
            sb.append (up);
        }

        return sb.reverse ().toString ();
    }
}
