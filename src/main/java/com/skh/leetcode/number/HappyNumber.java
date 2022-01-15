package leetcode.number;

import java.util.HashSet;
import java.util.Set;

/**
 * 202. 快乐数
 * @Description
 * 编写一个算法来判断一个数是不是“快乐数”。
 * 一个“快乐数”定义为：对于一个正整数，
 * 每一次将该数替换为它每个位置上的数字的平方和，
 * 然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。
 * 如果可以变为 1，那么这个数就是快乐数。
 *
 * 输入: 19
 * 输出: true
 * 解释:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 * @auther SHENKAIHUAN
 * @create 2019-09-30 23:23
 */
public class HappyNumber {
    public static void main(String[] args) {
        int nums = 19;
        long start =System.currentTimeMillis ();
        System.out.println (isHappy (nums));
        long end =System.currentTimeMillis ();
        System.out.println ("total:"+(end-start));
    }

    public static boolean isHappy(int n) {

        int happer = getHappy(n);
        Set<Integer> set = new HashSet<> ();
        while (happer!=1){
            happer = getHappy (happer);
            if(!set.add (happer)){
                break;
            }
        }
        return happer==1;

    }

    private static int getHappy(int n) {
        int sum = 0;
        while (n>0){
            int num = n%10;
//            System.out.print(num+", ");
            sum+=Math.pow (num,2);
            n=n/10;
        }
//        System.out.println ();
//        System.out.println ("============sum=======");
//        System.out.println (sum);
        return sum;
    }
}
