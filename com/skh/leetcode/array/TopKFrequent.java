package leetcode.array;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 347. 前 K 个高频元素
 *
 * @Description 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 * <p>
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * @auther SHENKAIHUAN
 * @create 2021-06-13 17:38
 */
public class TopKFrequent {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 2, 2, 3};
        int k = 2;
        TopKFrequent topKFrequent = new TopKFrequent ();
        int[] ints = topKFrequent.topKFrequent (nums, k);
        System.out.print ("[");
        for (int num : ints) {
            System.out.print (num + ",");
        }
        System.out.println ("]");
    }

    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue (nums.length, (Comparator<Map.Entry<Integer, Integer>>) (o1, o2) -> o2.getValue ().compareTo (o1.getValue ()));
        Map<Integer, Integer> map = new HashMap<> ();
        for (int num : nums) {
            if (map.containsKey (num)) {
                map.put (num, map.get (num) + 1);
            } else {
                map.put (num, 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet ()) {
            priorityQueue.add (entry);
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = priorityQueue.poll ().getKey ();
        }
        return result;
    }
}
