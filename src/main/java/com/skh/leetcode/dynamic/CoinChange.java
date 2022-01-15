package leetcode.dynamic;

/**
 * 322. 零钱兑换
 * @Description
 * 给定不同面额的硬币 coins 和一个总金额 amount。
 * 编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 * 如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 *
 * @auther SHENKAIHUAN
 * @create 2020-02-05 20:54
 */
public class CoinChange {
    public static void main(String[] args) {

        int[] coins=new int[]{186,419,83,408};
        int amount = 6249;
//        int[] coins=new int[]{1,2,5};
//        int amount=11;
        long start =System.currentTimeMillis ();
        System.out.println (coinChange(coins,amount));
        long end = System.currentTimeMillis ();
        System.out.println ("total:"+(end-start));
    }
    public static int coinChange(int[] coins, int amount) {

       int[] arr = new int[amount+1];
       for (int i=1;i<arr.length;i++) arr[i]=-1;
       for(int num =1;num<=amount;num++){
           for (int i=0; i<coins.length;i++){
               if(num-coins[i]>=0 && arr[num-coins[i]]>-1){
                   if(arr[num]==-1 || arr[num]>arr[num-coins[i]]+1){
                       arr[num]=arr[num-coins[i]]+1;
                   }
               }
           }
       }
       return arr[amount];
    }
}
