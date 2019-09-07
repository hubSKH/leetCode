package leetcode.string;

/**
 * 76. 最小覆盖子串
 * @Description
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。
 *说明：
 * 如果 S 中不存这样的子串，则返回空字符串 ""。
 * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 *
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 * @auther SHENKAIHUAN
 * @create 2019-09-03 23:38
 */
public class MinimumWindowSubstring {
    public static void main(String[] args) {

        String s ="ABABC";
        String t="ABC";
        long stat =System.currentTimeMillis ();
        System.out.println (minWindow (s,t));
        long end =System.currentTimeMillis ();
        System.out.println ("total:"+(end-stat));
    }

    public static String minWindow(String s, String t) {

        char[] schars = s.toCharArray ();
        char[] tchars= t.toCharArray ();

        int slen=schars.length;
        int tlen=tchars.length;
        int[] tcaculate = new  int[63];
        int[] record = new int[63];

        for(char c : tchars){
            tcaculate[c-'A']++;
        }

        //最小覆盖串下标
        int low =0,high =0;
        //最小的覆盖串的距离
        int cout=-1;
        int i=0,j=0;
        int lastR =-1;
        while (j<slen){
            Integer idx = schars[j]-'A';
            if(lastR != j){
                //已经记录过的，不重复记
                record[idx]++;
            }
            int len =j-i+1;
            if((len>=tlen) && tcaculate[idx]>0){
                //i j距离至少比t长
                // 当前j指向的字符存在于t中，则可能是覆盖串
                if(mathcString(tcaculate,record)){
                    if(cout==-1|| len<cout){
                        //比之前的串小，记录长度及下标
                        cout=len;
                        low =i;
                        high=j;

                    }
                    //最前面的字符踢出记录
                    record[schars[i]-'A']--;
                    i++;
                    lastR =j;
                }else {
                    j++;
                }
            }else {
                j++;
            }
        }

        if (cout>=tlen){
           return s.substring (low,high+1);
        }

        return "";

    }

    /**
     * 判断覆盖串
     * @param tcaculate 标准串
     * @param record 检测串
     * @return
     */
    private static boolean mathcString(int[] tcaculate, int[] record) {

        for(int i=0;i<tcaculate.length;i++){
            if(tcaculate[i]>record[i]){
                //T串中的字符比检测的多，不符合
                return false;
            }
        }
        return true;
    }
}
