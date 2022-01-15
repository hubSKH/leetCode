package leetcode.string;

/**
 * 38. 报数
 * @Description
 * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 *
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
 * 注意：整数顺序将表示为一个字符串。
 * @auther SHENKAIHUAN
 * @create 2019-08-27 22:20
 */
public class CountandSay {
    public static void main(String[] args) {
        int n =30;
        long start = System.currentTimeMillis ();
        System.out.println (countAndSay (n));
        long end =System.currentTimeMillis ();
        System.out.println ("total:"+(end-start));
    }

    public static String countAndSay(int n) {

        StringBuilder lastSB = new StringBuilder ("1");
        for(int i=1;i<n;i++){
            StringBuilder sb = new StringBuilder ();
            int lastLength =lastSB.length ();
            for(int j=0;j<lastLength;j++){
                int count =1;
                char c = lastSB.charAt (j);
                while (j+1<lastLength &&lastSB.charAt (j+1)==c){
                    count++;
                    j++;
                }
               sb.append (count).append (c);
            }
            lastSB = sb;
        }
        return lastSB.toString ();
    }
}
