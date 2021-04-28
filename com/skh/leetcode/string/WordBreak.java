package leetcode.string;

import java.util.*;

/**
 * 139. 单词拆分
 *
 * @Description 给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 * 说明：
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 *
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 * @auther SHENKAIHUAN
 * @create 2021-04-25 22:44
 */
public class WordBreak {
    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = Arrays.asList ("leet", "code");
        System.out.println (wordBreak (s, wordDict));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length () == 0) return false;
        boolean[] flags = new boolean[s.length () + 1];
        flags[0] = true;
        for (int i = 0; i < s.length (); i++) {
            if (!flags[i]) continue;
            for (String word : wordDict) {
                if (word.length () + i <= s.length () && s.startsWith (word, i)) {
                    flags[word.length () + i] = true;
                }
            }
        }
        return flags[s.length ()];
    }
}
