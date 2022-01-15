package leetcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 290. 单词规律
 * @Description
 * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 * 这里的 遵循 指完全匹配，例如， 
 * pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
 *
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 *
 * 输入:pattern = "abba", str = "dog cat cat fish"
 * 输出: false
 * @auther SHENKAIHUAN
 * @create 2019-11-04 22:45
 */
public class WordPattern {
    public static void main(String[] args) {
        String pattern ="aaaa";
        String str ="dog cat cat dog";
        long start = System.currentTimeMillis ();
        System.out.println (wordPattern (pattern,str));
        long end = System.currentTimeMillis ();
        System.out.println ("total:" + (end - start));
    }

    public static boolean wordPattern(String pattern, String str) {
        String[] strings =str.split (" ");
        if(pattern.length () != strings.length){
            return false;
        }
        int[] charSet =new int[26];
        Map<String,Character> map =new HashMap<> (pattern.length ());
        for(int i =0;i<pattern.length ();i++){
            char c =pattern.charAt (i);
            if(map.get (strings[i])==null){
                int idx =c-'a';
                if(charSet[idx]==0){
                    map.put (strings[i],c);
                    charSet[idx]++;
                    continue;
                }
                return false;
            }
            if(c !=map.get (strings[i])){
                return false;
            }
        }
        return true;
    }
}
