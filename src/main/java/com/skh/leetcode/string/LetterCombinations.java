package leetcode.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 17. 电话号码的字母组合
 * @Description
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * @auther SHENKAIHUAN
 * @create 2021-04-11 15:09
 */
public class LetterCombinations {
    public static void main(String[] args) {
        String str = "435";
        System.out.println (letterCombinations (str).toString ());

    }
    public static List<String> letterCombinations(String digits) {
        List<String> result =new ArrayList<> ();
        if(digits==null || digits.equals ("")) return result;

        Map<Character,char[]> characterMap = new HashMap<> ();
        characterMap.put ('2',new char[]{'a','b','c'});
        characterMap.put ('3',new char[]{'d','e','f'});
        characterMap.put ('4',new char[]{'g','h','i'});
        characterMap.put ('5',new char[]{'j','k','l'});
        characterMap.put ('6',new char[]{'m','n','o'});
        characterMap.put ('7',new char[]{'p','q','r','s'});
        characterMap.put ('8',new char[]{'t','u','v'});
        characterMap.put ('9',new char[]{'w','x','y','z'});
        backtrack(digits,0,characterMap,new StringBuilder (),result);
        return result;
    }

    private static void backtrack(String digits, int idx, Map<Character, char[]> characterMap, StringBuilder stringBuilder, List<String> result) {
        if(idx == digits.length ()){
            result.add (stringBuilder.toString ());
            return;
        }
        char[] chars = characterMap.get (digits.charAt (idx));
        for (int i = 0; i < chars.length; i++) {
            stringBuilder.append (chars[i]);
            backtrack (digits, idx+1, characterMap, stringBuilder, result);
            stringBuilder.deleteCharAt (stringBuilder.length ()-1);
        }
    }
}
