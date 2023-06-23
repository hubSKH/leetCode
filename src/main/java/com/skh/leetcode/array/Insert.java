package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 57. 插入区间
 * 给你一个 无重叠的 ，按照区间起始端点排序的区间列表。
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 * <p>
 * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出：[[1,5],[6,9]]
 * <p>
 * 0 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= intervals[i][0] <= intervals[i][1] <= 105
 * intervals 根据 intervals[i][0] 按 升序 排列
 * newInterval.length == 2
 * 0 <= newInterval[0] <= newInterval[1] <= 105
 *
 * @Description
 * @auther SHENKAIHUAN
 * @create 2023/6/23 14:22
 */
public class Insert {
    public static void main(String[] args) {
        int[][] intervals = new int[][]{
                {1, 5},
        };
        int[] newInterval = new int[]{2, 7};
        int[][] insert = new Insert().insert(intervals, newInterval);
        for (int i = 0; i < insert.length; i++) {
            System.out.println(Arrays.toString(insert[i]));

        }

    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        boolean insertFlag = true;
        for (int i = 0; i < intervals.length; ) {
            if (insertFlag && intervals[i][0] > newInterval[0]) {
                list.add(newInterval);
                insertFlag = false;
            }
            list.add(intervals[i]);
            i++;
        }
        if (insertFlag) {
            list.add(newInterval);
        }

        List<int[]> result = new ArrayList<>();
        if (!list.isEmpty()) {
            result.add(list.get(0));
            for (int i = 1; i < list.size(); i++) {
                int[] interval = list.get(i);
                int[] lastInterval = result.get(result.size() - 1);
                if (lastInterval[1] >= interval[0]) {
                    lastInterval[0] = Math.min(interval[0], lastInterval[0]);
                    lastInterval[1] = Math.max(interval[1], lastInterval[1]);
                } else {
                    result.add(interval);
                }
            }
        } else {
            result.add(newInterval);
        }
        return result.toArray(new int[0][]);
    }
}
