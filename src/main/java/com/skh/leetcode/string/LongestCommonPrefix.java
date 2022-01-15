package leetcode.string;

/**
 * 14. 最长公共前缀
 * @Description
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 *  说明:
 * 所有输入只包含小写字母 a-z 。
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * @auther SHENKAIHUAN
 * @create 2019-09-07 17:49
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {

        String[] strs =new String[]{
                "dog","racecar","car"
        };
        long start =System.currentTimeMillis ();
        System.out.println (longestCommonPrefix (strs));
        long end =System.currentTimeMillis ();
        System.out.println ("total:"+(end-start));
    }

    public static String longestCommonPrefix(String[] strs) {

        if(strs.length<1){
            return "";
        }
        String prefix=strs[0];
        for(int i=1;i<strs.length;i++){
            prefix=longestPrefix(prefix,strs[i]);
            if("".equals (prefix)){
                //前面没有公共前缀，则后面也没有，直接跳出循环
                break;
            }
        }
        return prefix;
    }

    /**
     * 返回公共前缀
     * @param prefix
     * @param str
     * @return
     */
    private static String longestPrefix(String prefix, String str) {
        int i=0;
        for(;i<prefix.length () && i<str.length ();i++){
            if(prefix.charAt (i)!=str.charAt (i)){
                break;
            }
        }
        return prefix.substring (0,i);
    }
}
