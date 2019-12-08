package leetcode.string;

/**
 * 5. 最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 */
public class LongestPalindromicString {
    public static void main(String[] args) {
        String s ="cbbd";
        long start = System.currentTimeMillis ();
        System.out.println (longestPalindrome(s));
        long end = System.currentTimeMillis ();
        System.out.println ((end-start));
    }

    private static String longestPalindrome(String s) {
        if(null == s ||s.length ()<=1){
            return s;
        }
        int[] result =new int[2];
        char[] chars =s.toCharArray ();
        for (int i = 0; i < chars.length; i++) {
            findResult(chars,i,i,result);
        }
        return s.substring (result[0],result[1]+1);
    }

    private static void findResult(char[] chars,int left,int right,int[] result){
        //从左边第一个字符开始，
        // 右指针所指字符与左指针字符一样的话（字符一样必为回文），右指针往右移
        while (right < chars.length - 1 && chars[left] == chars[right + 1]) {
            right++;
        }
        //左右指针不越界，并且向外扩展字符符合回文
        while (left > 0 && right < chars.length - 1 && chars[left - 1] == chars[right + 1]) {
            left--;
            right++;
        }
        if (right - left > result[1] - result[0]) {
            result[0] = left;
            result[1] = right;
        }
    }

//    private static String longestPalindrome(String s) {
//        if(null == s ){
//            return null;
//        }
//        if(s.length ()<=1){
//            return s;
//        }
//        char[] chars = s.toCharArray ();
//        int length =chars.length;
//        for(int i= length-1;i>0;i-- ){//步长
//            for(int j =0,k=j+i;k<length;j++,k++){//滑动窗格
//                //判断回文
//                boolean flag =true;
//                for(int p =j,q=k;q-p>0;p++,q--){
//                    if(chars[p]!=chars[q]){
//                        flag=false;
//                        break;
//                    }
//                    flag=true;
//                }
//                if(flag){
//                    return s.substring (j,k+1);
//                }
//            }
//        }
//        //没有匹配，返回第一个字母
//        return s.substring (0,1);
//    }

}
