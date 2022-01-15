package leetcode.number;

/**
 * 9. 回文数
 * @Description
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 输入: 121
 * 输出: true
 *
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * @auther SHENKAIHUAN
 * @create 2019-12-14 13:49
 */
public class PalindromeNumber {
    public static void main(String[] args) {
        int nums = 121;
        long start =System.currentTimeMillis ();
        System.out.println (isPalindrome (nums));
        long end =System.currentTimeMillis ();
        System.out.println ("total:"+(end-start));
    }

    public static boolean isPalindrome(int x) {

        String numString = String.valueOf (x);
        char[] chars =numString.toCharArray ();
        int i=0,j=chars.length -1;
        while (i<j){
            if(chars[i]!=chars[j]){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
