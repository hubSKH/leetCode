package leetcode.string;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 */
public class LongestPalindromicString {
    public static void main(String[] args) {
        String s ="civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
        long start = System.currentTimeMillis ();
        System.out.println (longestPalindrome(s));
        long end = System.currentTimeMillis ();
        System.out.println ((end-start));
    }

    private static String longestPalindrome(String s) {
        if(null == s ){
            return null;
        }
        if(s.length ()<=1){
            return s;
        }
        char[] chars = s.toCharArray ();
        int length =chars.length;
        for(int i= length-1;i>0;i-- ){//步长
            for(int j =0,k=j+i;k<length;j++,k++){//滑动窗格
                //判断回文
                boolean flag =true;
                for(int p =j,q=k;q-p>0;p++,q--){
                    if(chars[p]!=chars[q]){
                        flag=false;
                        break;
                    }
                    flag=true;
                }
                if(flag){
                    return s.substring (j,k+1);
                }
            }
        }
        //没有匹配，返回第一个字母
        return s.substring (0,1);
    }
}
