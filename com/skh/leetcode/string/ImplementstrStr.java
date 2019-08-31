package leetcode.string;

/**
 * 28. 实现 strStr()
 * @Description
 * 实现 strStr() 函数。
 * 给定一个 haystack 字符串和一个 needle 字符串，
 * 在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。
 * 如果不存在，则返回  -1。
 *
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 *
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * @auther SHENKAIHUAN
 * @create 2019-08-30 0:18
 */
public class ImplementstrStr {
    public static void main(String[] args) {
        String haystack ="mississippi";
        String needle = "mississippi";
        long start = System.currentTimeMillis ();
        System.out.println (strStr (haystack,needle));
        long end =System.currentTimeMillis ();
        System.out.println ("total:"+(end-start));
    }
    public static int strStr(String haystack, String needle) {

        if("".equals (needle)){
            return 0;
        }
        char[] stackChars = haystack.toCharArray ();
        char[] dleChars = needle.toCharArray ();

        int left =0;
        int needleLen =dleChars.length;
        int right = stackChars.length-needleLen+1;
        for (;left<right;left++){
            int start = left;
            int i=0;
            for(;i<needleLen;i++){
                if(stackChars[start]!=dleChars[i]){
                    //不符合串。左下标往前移
                    break;
                }
                start++;
            }
            if(i==needleLen){
                //找到第一个符合
                return left;
            }
        }
        return -1;
    }
}
