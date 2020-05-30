package audition;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 面试题50. 第一个只出现一次的字符
 * @Description
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 *
 * s = "abaccdeff"
 * 返回 "b"
 *
 * s = ""
 * 返回 " "
 *
 * @auther SHENKAIHUAN
 * @create 2020-05-31 0:06
 */
public class FirstUniqChar {
    public static void main(String[] args) {
        String s="abaccdeff";
        System.out.println (firstUniqChar (s));

    }
    public static char firstUniqChar(String s) {
        Map<Character,Boolean> map =new LinkedHashMap<> ();
        char[] chars =s.toCharArray ();
        for(char c : chars) map.put (c,!map.containsKey (c));
        for (Map.Entry<Character,Boolean> entry: map.entrySet ()){
            if(entry.getValue ()) return entry.getKey ();
        }
        return ' ';

    }
}
