package leetcode.string;

/**
 * 541. 反转字符串 II
 * @Description
 * 给定一个字符串和一个整数 k，
 * 你需要对从字符串开头算起的每个 2k 个字符的前k个字符进行反转。
 * 如果剩余少于 k 个字符，则将剩余的所有全部反转。
 * 如果有小于 2k 但大于或等于 k 个字符，则反转前 k 个字符，并将剩余的字符保持原样。
 * 要求:
 * 该字符串只包含小写的英文字母。
 * 给定字符串的长度和 k 在[1, 10000]范围内。
 *
 * 输入: s = "abcdefg", k = 2
 * 输出: "bacdfeg"
 *
 * @auther SHENKAIHUAN
 * @create 2019-09-09 23:03
 */
public class ReverseStringII {
    public static void main(String[] args) {
        String s ="abcd";
        int k =2;
        long start =System.currentTimeMillis ();
        System.out.println (reverseStr (s,k));
        long end =System.currentTimeMillis ();
        System.out.println ("total:"+(end-start));
    }

    public static String reverseStr(String s, int k) {

        char[] chars =s.toCharArray ();
        int step =2*k,len=chars.length;
        int l=0,r=k;
        while (l<len){
            if(r>len){
                r=len;
            }
            reverseStr (chars,l,r-1);
            l+=step;
            r+=step;
        }
        return new String (chars);

    }

    private static void reverseStr(char[] chars, int l, int r) {
        for(;l<r;){
            char c = chars[l];
            chars[l]=chars[r];
            chars[r]=c;
            l++;
            r--;
        }
    }

}
