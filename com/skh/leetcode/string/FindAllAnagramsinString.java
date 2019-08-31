package leetcode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * 438. 找到字符串中所有字母异位词
 * @Description
 * 给定一个字符串 s 和一个非空字符串 p，
 * 找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
 *
 * 说明：
 * 字母异位词指字母相同，但排列不同的字符串。
 * 不考虑答案输出的顺序。
 *
 * 输入:
 * s: "cbaebabacd" p: "abc"
 * 输出:
 * [0, 6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
 * @auther SHENKAIHUAN
 * @create 2019-08-30 23:01
 */
public class FindAllAnagramsinString {
    public static void main(String[] args) {

        String s ="cbaebabacd";
        String p="abc";
        long start =System.currentTimeMillis ();
        List<Integer> list =findAnagrams (s,p);
        long end =System.currentTimeMillis ();
        System.out.println ("total:"+(end-start));
        for(Integer i : list){
            System.out.print (i+", ");
        }
        System.out.println ();

    }

    public static List<Integer> findAnagrams(String s, String p) {

        List<Integer> result =new ArrayList<> ();
        char[] schars = s.toCharArray ();
        char[] pchars = p.toCharArray ();

        int slen =s.length (),plen=p.length ();
        int[] pcaculate = new int[26];
        for(char c : pchars){
            //将p字符串含有的字符记录在数组中
            pcaculate[c-'a'] ++;
        }
        //滑动窗口思路
        int left =0 ,right=0;
        while (right<slen){
            if(pcaculate[schars[right]-'a']>0){
                //p中含有的字符，匹配到了数量减一，由下标往前移
                pcaculate[schars[right]-'a']--;
                right++;
                //左右长度等于p字符串长度，则左右包含的串异位相等
                if(right-left==plen){
                    result.add (left);
                }
            }else {
                //不含字符，或字符已匹配，
                // 记录下这个字符（右下标往前移时，p字符串的记录减掉了，左下标移动的时候加回来）
                // 左下标往前移
                pcaculate[schars[left]-'a']++;
                left++;
            }
        }
        return result;
    }

}
