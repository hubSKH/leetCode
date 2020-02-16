package audition;

/**
 * 面试题05. 替换空格
 * @Description
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 * @auther SHENKAIHUAN
 * @create 2020-02-16 23:55
 */
public class ReplaceSpace {
    public static void main(String[] args) {
        String s="We are happy.";
        long start =System.currentTimeMillis ();
        System.out.println (replaceSpace(s));
        long end =System.currentTimeMillis ();
        System.out.println ("total:"+(end-start));
    }
    public static String replaceSpace(String s) {
        char[] chars =s.toCharArray ();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<chars.length;i++){
            if(chars[i]==' '){
                sb.append ("%20");
            }else {
                sb.append (chars[i]);
            }
        }
        return sb.toString ();

    }
}
