package audition;

/**
 * 面试题44. 数字序列中某一位的数字
 * @Description
 * 数字以0123456789101112131415…的格式序列化到一个字符序列中。
 * 在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。
 * 请写一个函数，求任意第n位对应的数字。
 *
 * 输入：n = 3
 * 输出：3
 * @auther SHENKAIHUAN
 * @create 2020-05-16 14:54
 */
public class FindNthDigit {
    public static void main(String[] args) {

        int n=1000000000;
        System.out.println (findNthDigit (n));
    }
    public static int findNthDigit(int n) {
        int digit=1;
        long start= 1;
        long count=9;
        while (n>count){
            n-=count;
            digit++;
            start*=10;
            count=digit*start*9;
        }
        long num= start+(n-1)/digit;
        return Long.toString (num).charAt ((n-1)%digit)-'0';
    }
}
