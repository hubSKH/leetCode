package leetcode.array;

import java.util.*;

/**
 * 49. 字母异位词分组
 *
 * @Description 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * <p>
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * @auther SHENKAIHUAN
 * @create 2021-04-12 20:50
 */
public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println (groupAnagrams (strs));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> resultMap = new HashMap<> ();
        for (String str : strs) {
            char[] arr = new char[26];
            for (char c : str.toCharArray()) {
                arr[c - 'a']++;
            }
            String key = String.valueOf(arr);
            List<String> stringList = resultMap.getOrDefault (key, new ArrayList<> ());
            stringList.add (str);
            resultMap.put (key,stringList);
        }
        return new ArrayList<> (resultMap.values ());
    }
}
