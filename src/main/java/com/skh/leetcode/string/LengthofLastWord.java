package leetcode.string;

/**
 * 58. 最后一个单词的长度
 * @Description
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
 * 如果不存在最后一个单词，请返回 0 。
 * 说明：一个单词是指由字母组成，但不包含任何空格的字符串。
 *
 * 输入: "Hello World"
 * 输出: 5
 * @auther SHENKAIHUAN
 * @create 2019-09-01 10:52
 */
public class LengthofLastWord {
    public static void main(String[] args) {
        String s ="Hello World";
        long start =System.currentTimeMillis ();
        System.out.println (lengthOfLastWord (s));
        long end =System.currentTimeMillis ();
        System.out.println ("total:"+(end-start));

    }

    public static int lengthOfLastWord(String s) {

        char[] chars = s.toCharArray ();
        int high = chars.length-1;

        //去除末尾空格
        while (high>=0 && chars[high] ==' '){
                high--;
        }
        int low = high;
        //地位下标往前移，直到遇到空格
        while (low >=0){
            if(chars[low]==' '){
                break;
            }
            low--;
        }
        return high-low;

    }
}
