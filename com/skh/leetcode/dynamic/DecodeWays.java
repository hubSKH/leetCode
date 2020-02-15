package leetcode.dynamic;

/**
 * 91. 解码方法
 * @Description
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 *
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 * @auther SHENKAIHUAN
 * @create 2020-02-14 20:09
 */
public class DecodeWays {
    public static void main(String[] args) {

        String s ="12120";
        long start =System.currentTimeMillis ();
        System.out.println (numDecodings(s));
        long end = System.currentTimeMillis ();
        System.out.println ("total:"+(end-start));
    }
    public static int numDecodings(String s) {
        int[] nums = new int[s.length ()+1];
        nums[s.length ()]=1;
        if(s.charAt (s.length ()-1)!='0'){
            nums[s.length ()-1]=1;
        }
        for (int i=s.length ()-2;i>=0;i--){
            if(s.charAt (i)=='0'){
                nums[i]=0;
            }else if(s.charAt (i)=='1'||(s.charAt (i)=='2'&&s.charAt (i+1)>='0'&&s.charAt (i+1)<'7')){
                nums[i]=nums[i+1]+nums[i+2];
            }else {
                nums[i]=nums[i+1];
            }

        }
        return nums[0];
    }
}
