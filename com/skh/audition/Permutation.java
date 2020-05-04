package audition;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 面试题38. 字符串的排列
 * @Description
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 *
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 * @auther SHENKAIHUAN
 * @create 2020-05-04 20:55
 */
public class Permutation {
    public static void main(String[] args) {
        String str= "abcd";
        long start = System.currentTimeMillis ();
        String[] permutation = permutation (str);
        long end =System.currentTimeMillis ();
        System.out.println ("total:"+(end-start));
    }
    public static String[] permutation(String s) {
        char[] chars = s.toCharArray ();
        List<String> result =new ArrayList<> ();
        dfs(chars,0,result);
        return result.toArray (new String[result.size ()]);
    }

    private static void dfs(char[] chars, int idx, List<String> result) {
        if(idx==chars.length-1){
            result.add (new String (chars));
            return;
        }
        HashSet<Character> set = new HashSet<> ();
        for(int i=idx;i<chars.length;i++){
            if(set.contains (chars[i]))continue;
            set.add (chars[i]);
            swap(chars,i,idx);
            dfs (chars,idx+1,result);
            swap(chars,idx,i);
        }
    }

    private static void swap(char[] chars, int i, int j) {
        char temp=chars[i];
        chars[i]=chars[j];
        chars[j]=temp;
    }
}
