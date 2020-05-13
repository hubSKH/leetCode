package audition;

/**
 * 面试题43. 1～n整数中1出现的次数
 * @Description
 * 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
 * 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。
 *
 * 输入：n = 12
 * 输出：5
 *
 * @auther SHENKAIHUAN
 * @create 2020-05-13 21:57
 */
public class CountDigitOne {
    public static void main(String[] args) {
        int n=12;
        System.out.println (countDigitOne (n));

    }
    public static int countDigitOne(int n) {
        int high=n/10,cur =n%10,low=0;
        int count=0,digit =1;
        while (high!=0||cur!=0){
            if(cur==0) count+= digit*high;
            else if(cur==1) count+= high*digit+low+1;
            else count += (high+1)*digit;
            low+=cur*digit;
            digit*=10;
            cur=high%10;
            high/=10;
        }
        return count;
    }
}
