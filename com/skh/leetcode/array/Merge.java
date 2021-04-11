package leetcode.array;

import java.util.*;

/**
 * 56. 合并区间
 *
 * @Description 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 *
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * @auther SHENKAIHUAN
 * @create 2021-04-11 15:43
 */
public class Merge {
    public static void main(String[] args) {
        int[][] intervals = new int[][]{
                {1, 3},
                {2, 6},
                {8, 10},
                {15, 18}
        };
        int[][] merge = merge (intervals);
        for (int i = 0; i < merge.length; i++) {
            System.out.print (Arrays.toString (merge[i]));
        }
        System.out.println ();
    }

    public static int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return new int[0][2];
        Arrays.sort (intervals, Comparator.comparingInt (a -> a[0]));
        List<int[]> resultList = new ArrayList<> ();
        resultList.add (intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            int[] lastInterval = resultList.get (resultList.size () - 1);
            if (lastInterval[1] >= interval[0]) {
                lastInterval[0] = Math.min (lastInterval[0], interval[0]);
                lastInterval[1] = Math.max (lastInterval[1], interval[1]);
            } else {
                resultList.add (interval);
            }
        }
        return resultList.toArray (new int[0][]);
    }
}
