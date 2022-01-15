package leetcode.array;

import java.util.HashMap;

/**
 * 697. 数组的度
 * @Description
 * 给定一个非空且只包含非负数的整数数组 nums, 数组的度的定义是指数组里任一元素出现频数的最大值。
 * 你的任务是找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
 * nums.length 在1到50,000区间范围内。
 * nums[i] 是一个在0到49,999范围内的整数。
 *
 * 输入: [1, 2, 2, 3, 1]
 * 输出: 2
 * 解释:
 * 输入数组的度是2，因为元素1和2的出现频数最大，均为2.
 * 连续子数组里面拥有相同度的有如下所示:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * 最短连续子数组[2, 2]的长度为2，所以返回2.
 *
 * 输入: [1,2,2,3,1,4,2]
 * 输出: 6
 *
 * @auther SHENKAIHUAN
 * @create 2019-09-28 11:33
 */
public class DegreeofanArray {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2, 3, 1};
        long start =System.currentTimeMillis ();
        System.out.println (findShortestSubArray (nums));
        long end =System.currentTimeMillis ();
        System.out.println ("total:"+(end-start));
    }

    public static int findShortestSubArray(int[] nums) {
        //第一次出现的下标
        HashMap<Integer,Integer> left = new HashMap<> ();
        //最后出现的下标
        HashMap<Integer,Integer> right = new HashMap<> ();
        //数字出现的个数
        HashMap<Integer,Integer> count = new HashMap<> ();

        for (int i=0;i<nums.length;i++){
            int num = nums[i];
            if(left.get (num)==null){
                left.put (num,i);
            }
            right.put (num, i);
            count.put (num, count.getOrDefault (num,0)+1);
        }
        int min = nums.length;
        int maxCount = 0;
        for (Integer num : count.keySet ()){
            int c =count.get (num);
            if(maxCount<c){
                maxCount = count.get (num);
                min = getLength(left,right,num);
            }else if(maxCount == c){
                int len = getLength (left,right,num);
                if(min> len){
                    min =len;
                }
            }
        }

        return min;

    }

    private static int getLength(HashMap<Integer, Integer> left, HashMap<Integer, Integer> right, Integer num) {
        return right.get (num)-left.get (num)+1;
    }
}
