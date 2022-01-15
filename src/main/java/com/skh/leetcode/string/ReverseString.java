package leetcode.string;

/**
 * 344. 反转字符串
 * @Description
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
 *
 * 输入：["h","e","l","l","o"]
 * 输出：["o","l","l","e","h"]
 *
 * @auther SHENKAIHUAN
 * @create 2019-09-08 14:58
 */
public class ReverseString {
    public static void main(String[] args) {
        char[] s = new char[]{'H','a','n','n','a','h'};

        System.out.println ("==========before=========");
        for (char c : s){
            System.out.print (c+", ");
        }
        System.out.println ();
        long start = System.currentTimeMillis ();
        reverseString (s);
        long end =System.currentTimeMillis ();
        System.out.println ("==========after=========");
        for (char c : s){
            System.out.print (c+", ");
        }
        System.out.println ();
        System.out.println ("total:"+(end-start));
    }


    public static void reverseString(char[] s) {
        int i=0;
        int j=s.length-1;

        while (j > i) {
            char c = s[i];
            s[i]=s[j];
            s[j]=c;
            i++;
            j--;
        }
    }
}
