package leetcode.array;

/**
 * 122. 买卖股票的最佳时机 II
 * @Description
 * 给定一个数组 prices ，其中 prices[i] 是一支给定股票第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * 输入: prices = [7,1,5,3,6,4]
 * 输出: 7
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
 * @auther SHENKAIHUAN
 * @create 2021-07-26 23:11
 */
public class MaxProfit2 {
    public static void main(String[] args) {
        int[] prices = new int[]{7,1,5,3,6,7};
        MaxProfit2 maxProfit2 = new MaxProfit2 ();
        System.out.println (maxProfit2.maxProfit (prices));
    }

    /**
     * 贪心
     * 计算的过程并不是实际交易的过程
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int result =0;
        for (int i = 1; i < prices.length; i++) {
            result+=Math.max (0,prices[i]-prices[i-1]);
        }
        return result;
    }

//    /**
//     * 贪心--按实际交易计算
//     * @param prices
//     * @return
//     */
//    public int maxProfit(int[] prices) {
//        int min = prices[0];
//        int result =0;
//        for (int i = 1; i < prices.length; i++) {
//            if(prices[i]<prices[i-1]){
//                result+=(prices[i-1]-min);
//                min=prices[i];
//            }else if(prices[i]<min){
//                result+=prices[i]-min;
//                min=prices[i];
//            } else if(i==prices.length-1 && prices[i]>min){
//                result+=prices[i]-min;
//            }
//        }
//        return result;
//    }
}
