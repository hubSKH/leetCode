package audition;

/**
 * 剑指 Offer 58 - I. 翻转单词顺序
 * @Description
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
 * 为简单起见，标点符号和普通字母一样处理。
 * 例如输入字符串"I am a student. "，则输出"student. a am I"。
 *
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 * @auther SHENKAIHUAN
 * @create 2020-06-21 23:17
 */
public class RreverseWords {
    public static void main(String[] args) {
        String s ="Let's take LeetCode  contest";
        long start =System.currentTimeMillis ();
        System.out.println (reverseWords (s));
        long end =System.currentTimeMillis ();
        System.out.println ("total:"+(end-start));

    }

    public static String reverseWords(String s) {
        if(s==null) return null;
        s=s.trim ();
        char[] chars=s.toCharArray ();
        int i=s.length ()-1,j= s.length ()-1;
        StringBuilder sb =new StringBuilder ();
        while (i>=0){
            while (i>=0 && chars[i] !=' ') i--;
            sb.append (chars,i+1,j-i).append (' ');
            while (i>=0 && chars[i] ==' ') i--;
            j=i;
        }
        return sb.toString ().trim ();
    }
}
