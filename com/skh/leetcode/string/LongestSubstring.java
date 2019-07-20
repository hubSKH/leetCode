package leetcode.string;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
public class LongestSubstring {
    public static void main(String[] args) {
        String str= "abcabcbb";
        System.out.println (lengthOfLongestSubstring (str));
    }

    public static int lengthOfLongestSubstring(String s) {
        int max=0,len= s.length ();
        int i=0 ,j =0;
        Set<Character> characterSet = new HashSet<Character> ();
        while (i < len && j < len) {
            if (characterSet.contains (s.charAt (j))) {
                characterSet.remove (s.charAt (i++));
            } else {
                characterSet.add (s.charAt (j++));
                max = Math.max (max, j - i);
            }
        }
        return max;
    }
}
