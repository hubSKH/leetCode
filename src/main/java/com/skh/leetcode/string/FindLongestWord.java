package leetcode.string;

import java.util.Arrays;
import java.util.List;

/**
 * 524. 通过删除字母匹配到字典里最长单词
 *
 * @Description 给你一个字符串 s 和一个字符串数组 dictionary 作为字典，找出并返回字典中最长的字符串，该字符串可以通过删除 s 中的某些字符得到。
 * 如果答案不止一个，返回长度最长且字典序最小的字符串。如果答案不存在，则返回空字符串。
 * <p>
 * 输入：s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
 * 输出："apple"
 * @auther SHENKAIHUAN
 * @create 2021-08-15 11:44
 */
public class FindLongestWord {
    public static void main(String[] args) {
        String s = "wordgoodgoodgoodbestword";
        List<String> dictionary = Arrays.asList ("word","good","best","good");
        FindLongestWord findLongestWord = new FindLongestWord ();
        System.out.println (findLongestWord.findLongestWord (s, dictionary));
    }

    public String findLongestWord(String s, List<String> dictionary) {
        String result = "";
        for (int i = 0; i < dictionary.size (); i++) {
            String detected = detectString (s, dictionary.get (i));
            if (detected.length () > result.length ()) {
                result = detected;
            } else if (detected.length () == result.length ()) {
                result = orderFirst (detected, result);
            }
        }
        return result;
    }

    private String orderFirst(String detected, String result) {
        for (int i = 0; i < result.length (); i++) {
            if (detected.charAt (i) < result.charAt (i)) {
                return detected;
            }else if(detected.charAt (i) > result.charAt (i)){
                return result;
            }
        }
        return result;
    }

    private String detectString(String s, String detectString) {
        int dIdx = 0;
        for (int i = 0; i < s.length (); i++) {
            if (s.charAt (i) == detectString.charAt (dIdx)) {
                dIdx++;
                if (dIdx == detectString.length ()) {
                    return detectString;
                }
            }
        }
        return "";
    }
}
