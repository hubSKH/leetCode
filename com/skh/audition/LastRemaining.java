package audition;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 62. 圆圈中最后剩下的数字
 * @Description
 * 0, 1, , n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。
 * 求出这个圆圈里剩下的最后一个数字。
 *
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，
 * 则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 *
 * 输入: n = 5, m = 3
 * 输出: 3
 * @auther SHENKAIHUAN
 * @create 2020-06-26 10:05
 */
public class LastRemaining {
    public static void main(String[] args) {
        int n=5;
        int m=3;
        System.out.println (lastRemaining (n,m));

    }
   /* public static int lastRemaining(int n, int m) {
        List<Integer> list =new ArrayList<> (n);
        for(int i=0;i<n;i++){
            list.add (i);
        }
        int idx =0;
        while (n>1){
            idx=(idx+m-1)%n;
            list.remove (idx);
            n--;
        }
        return list.get (0);

    }*/
    public static int lastRemaining(int n, int m) {
        int res=0;
        for(int i=2;i<=n;i++){
            res=(res+m)%i;
        }
        return res;
    }

}
