package leetcode.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 20. 有效的括号
 * @Description
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 输入: "()"
 * 输出: true
 * 输入: "()[]{}"
 * 输出: true
 * 输入: "([)]"
 * 输出: false
 * 输入: "{[]}"
 * 输出: true
 * @auther SHENKAIHUAN
 * @create 2019-08-26 23:29
 */
public class ValidParentheses {
    public static void main(String[] args) {
        String s ="}";
        long start = System.currentTimeMillis ();
        System.out.println (isValid (s));
        long end =System.currentTimeMillis ();
        System.out.println ("total:"+(end-start));

    }

    public static boolean isValid(String s) {
        if(null == s){
            return  false;
        }
        if("".endsWith (s)){
            return true;
        }
        Map<Character,Character> characterMap = new HashMap<> ();
        characterMap.put (')','(');
        characterMap.put (']','[');
        characterMap.put ('}','{');
        char[] chars = s.toCharArray ();
        if(chars.length%2 !=0){
            return false;
        }
        Stack<Character> characterStack = new Stack<> ();
        for(char c : chars){
            if(characterMap.containsKey (c)){
                if(characterStack.isEmpty ()){
                    return false;
                }
                char cs =  characterStack.pop ();
                if(characterMap.get (c)!=cs){
                    return false;
                }
            }else {
                characterStack.push (c);
            }
        }
        return characterStack.isEmpty ();

    }
}
