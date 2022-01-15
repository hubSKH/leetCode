package leetcode.dynamic;

/**
 * 70. 爬楼梯
 * @Description
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 *
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * @auther SHENKAIHUAN
 * @create 2019-11-26 0:23
 */
public class ClimbingStairs {
    public static void main(String[] args) {
        int n =4;
        long start =System.currentTimeMillis ();
        System.out.println (climbStairs(n));
        long end =System.currentTimeMillis ();
        System.out.println ("total:"+(end-start));
    }

    public static int climbStairs(int n) {
        if(n<3){
            return n;
        }
       int[] results=new int[n];
       results[0]=1;
       results[1]=2;
       for (int i=2;i<results.length;i++){
           results[i]=results[i-1]+results[i-2];
       }
       return results[n-1];

    }
}
