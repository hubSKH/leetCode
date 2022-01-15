package leetcode.string;

/**
 * 557. 反转字符串中的单词 III
 * @Description
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 * 注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 * 输入: "Let's take LeetCode contest"
 * 输出: "s'teL ekat edoCteeL tsetnoc"
 *
 * @auther SHENKAIHUAN
 * @create 2019-09-10 23:14
 */
public class ReverseWordsinaStringIII {
    public static void main(String[] args) {
        String s ="Let's take LeetCode contest";
        long start =System.currentTimeMillis ();
        System.out.println (reverseWords (s));
        long end =System.currentTimeMillis ();
        System.out.println ("total:"+(end-start));

    }

    public static String reverseWords(String s) {

        char[] chars =s.toCharArray ();
        int i=0,j=0;
        int len =chars.length;
        while (j<=len){
            if(j==len ||chars[j]==' '){
                reverseWords (chars,i,j-1);
                j++;
                i=j;
            }
            j++;
        }

        return new String (chars);
    }

    private static void reverseWords(char[] chars, int i, int j) {
        while (i<j){
            char c =chars[i];
            chars[i]=chars[j];
            chars[j]=c;
            i++;
            j--;
        }
    }


}
