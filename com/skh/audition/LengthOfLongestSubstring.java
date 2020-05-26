package audition;

/**
 * 面试题48. 最长不含重复字符的子字符串
 * @Description
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * @auther SHENKAIHUAN
 * @create 2020-05-26 22:44
 */
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        String str= "abcabcbb";
        System.out.println (lengthOfLongestSubstring (str));

    }
    public static int lengthOfLongestSubstring(String s) {
        int max=0,len= s.length ();
        int i=0 ,startIdx=0;
        char[] chars = s.toCharArray ();
        for(;i<len;i++){
            for(int j=startIdx;j<i;j++){
                if(chars[j] == chars[i]){
                    startIdx = j+1;
                    break;
                }
            }
            if(i-startIdx+1>max){
                max = i-startIdx+1;
            }
        }
        return max;
    }
}
