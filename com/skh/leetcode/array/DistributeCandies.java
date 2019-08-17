package leetcode.array;

import java.util.HashSet;
import java.util.Set;

/**
 * 575. 分糖果
 * @Description
 * 给定一个偶数长度的数组，其中不同的数字代表着不同种类的糖果，每一个数字代表一个糖果。
 * 你需要把这些糖果平均分给一个弟弟和一个妹妹。返回妹妹可以获得的最大糖果的种类数。
 *
 * 输入: candies = [1,1,2,2,3,3]
 * 输出: 3
 * 解析: 一共有三种种类的糖果，每一种都有两个。
 *      最优分配方案：妹妹获得[1,2,3],弟弟也获得[1,2,3]。这样使妹妹获得糖果的种类数最多。
 *
 * 输入: candies = [1,1,2,3]
 * 输出: 2
 * 解析: 妹妹获得糖果[2,3],弟弟获得糖果[1,1]，妹妹有两种不同的糖果，弟弟只有一种。这样使得妹妹可以获得的糖果种类数最多。
 *
 * 注意:
 * 数组的长度为[2, 10,000]，并且确定为偶数。
 * 数组中数字的大小在范围[-100,000, 100,000]内。
 * @auther SHENKAIHUAN
 * @create 2019-08-17 14:44
 */
public class DistributeCandies {
    public static void main(String[] args) {
        int[] nums = new int[]{100000,0,100000,0,100000,0,100000,0,100000,0,100000,0};
        long start =System.currentTimeMillis ();
        System.out.println (distributeCandies (nums));
        long end =System.currentTimeMillis ();
        System.out.println ("total:"+(end-start));
    }

    public static int distributeCandies(int[] candies) {

        //妹妹获得的种类
        int count =0;
        //每种一个，极限情况，最多只能分得数组长度数量一半的种类
        int maXCount = candies.length/2;
        //记录已计算的种类的,初始化容量和负载，避免扩容，提升效率
        Set<Integer> set = new HashSet<> (maXCount,2);

        for (int i = 0;i<candies.length && count<maXCount;i++ ){
            if(set.add (candies[i])){
                count ++;
            }
        }
        return count;

    }
}
