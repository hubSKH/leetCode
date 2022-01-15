package leetcode.string;

/**
 * 13. 罗马数字转整数
 * @Description
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 *例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。
 *  27 写做  XXVII, 即为 XX + V + II 。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。
 * 但也存在特例，例如 4 不写做 IIII，而是 IV。
 * 数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。
 * 同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 *
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 *
 * 输入: "III"
 * 输出: 3
 *
 * 输入: "LVIII"
 * 输出: 58
 * 解释: L = 50, V= 5, III = 3.
 *
 * 输入: "MCMXCIV"
 * 输出: 1994
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 * @auther SHENKAIHUAN
 * @create 2019-09-02 23:35
 */
public class RomantoInteger {
    public static void main(String[] args) {

        String s = "MCMXCIV";
        long start =System.currentTimeMillis ();
        System.out.println (romanToInt (s));
        long end = System.currentTimeMillis ();

    }

    public static int romanToInt(String s) {

        int sum =0;
        char[] chars =s.toCharArray ();
        int len =chars.length;
        for(int i=0;i<len;i++){
            char c =chars[i];
            if(c=='M'){
                sum+=1000;
            }else if(c=='D'){
                sum+=500;
            }else if(c=='C'){
                int next=i+1;
                if(next<len &&chars[next]=='M'){
                    sum+=900;
                    i++;
                }else if(next<len &&chars[next]=='D'){
                    sum+=400;
                    i++;
                }else {
                    sum+=100;
                }
            }else if(c=='L'){
                sum+=50;
            }else if(c=='X'){
                int next=i+1;
                if(next<len &&chars[next]=='C'){
                    sum+=90;
                    i++;
                }else if(next<len &&chars[next]=='L'){
                    sum+=40;
                    i++;
                }else {
                    sum+=10;
                }
            }else if(c=='V'){
                sum+=5;
            }else if(c=='I'){
                int next=i+1;
                if(next<len &&chars[next]=='X'){
                    sum+=9;
                    i++;
                }else  if(next<len &&chars[next]=='V'){
                    sum+=4;
                    i++;
                }else {
                    sum+=1;
                }
            }
        }
        return sum;
    }
}
