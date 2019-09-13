package leetcode.string;

/**
 * 434. 字符串中的单词数
 * @Description
 * 统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
 * 请注意，你可以假定字符串里不包括任何不可打印的字符。
 *
 * 输入: "Hello, my name is John"
 * 输出: 5
 * @auther SHENKAIHUAN
 * @create 2019-09-13 12:00
 */
public class NumberofSegmentsInaString {
    public static void main(String[] args) {
        String s ="  ";
        long start =System.currentTimeMillis ();
        System.out.println (countSegments (s));
        long end =System.currentTimeMillis ();
        System.out.println ("total:"+(end-start));
    }

    /*public static int countSegments(String s) {

        int result =0;
        int count =0;
        for(int i=0;i<s.length ();i++){
            if(s.charAt (i) != ' ' && count==0){
                result++;
                count++;
            }else if(i==0||i==s.length ()-1||(s.charAt (i)==' '&& s.charAt (i-1)!=' ')){
                count=0;
            }
        }
        return result;

    }*/

    public static int countSegments(String s) {

        int count =0;
        for(int i=0;i<s.length ();i++){
            if((i==0||s.charAt (i-1)==' ')&& s.charAt (i)!=' '){
                count++;
            }
        }
        return count;

    }
}
