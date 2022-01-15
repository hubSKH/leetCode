package leetcode.array;

import assit.ArrayBuilder;

/**
 * 452. 用最少数量的箭引爆气球
 *
 * @Description 在二维空间中有许多球形的气球。对于每个气球，提供的输入是水平方向上，气球直径的开始和结束坐标。
 * 由于它是水平的，所以纵坐标并不重要，因此只要知道开始和结束的横坐标就足够了。开始坐标总是小于结束坐标。
 * <p>
 * 一支弓箭可以沿着 x 轴从不同点完全垂直地射出。在坐标 x 处射出一支箭，
 * 若有一个气球的直径的开始和结束坐标为 xstart，xend， 且满足  xstart ≤ x ≤ xend，
 * 则该气球会被引爆。可以射出的弓箭的数量没有限制。 弓箭一旦被射出之后，可以无限地前进。
 * 我们想找到使得所有气球全部被引爆，所需的弓箭的最小数量。
 * <p>
 * 给你一个数组 points ，其中 points [i] = [xstart,xend] ，返回引爆所有气球所必须射出的最小弓箭数。
 * <p>
 * 输入：points = [[10,16],[2,8],[1,6],[7,12]]
 * 输出：2
 * 解释：对于该样例，x = 6 可以射爆 [2,8],[1,6] 两个气球，以及 x = 11 射爆另外两个气球
 * @auther SHENKAIHUAN
 * @create 2021-07-24 18:05
 */
public class FindMinArrowShots {
    public static void main(String[] args) {
        FindMinArrowShots findMinArrowShots = new FindMinArrowShots ();
        String str = "[[10,16],[2,8],[1,6],[7,12]]";
        int[][] points = ArrayBuilder.buildMatrix (str);
        System.out.println (findMinArrowShots.findMinArrowShots (points));
    }


    public int findMinArrowShots(int[][] points) {
        if (points.length < 2) return points.length;
        heapSortByleft (points);
        int result = 1, maxRight = points[0][1];
        for (int i = 0; i < points.length; i++) {
            if (points[i][0] > maxRight) {
                result++;
                maxRight=points[i][1];
            }
        }
        return result;
    }

    int len;

    private void heapSortByleft(int[][] points) {
        len = points.length;
        buildHeap (points);
        while (len > 0) {
            swap (points, 0, len - 1);
            len--;
            adjustHeap (points, 0);
        }
    }

    private void buildHeap(int[][] points) {
        for (int i = (len - 1) / 2; i >= 0; i--) {
            adjustHeap (points, i);
        }
    }

    private void adjustHeap(int[][] points, int i) {
        int idx = i;
        if (2 * i + 1 < len && points[2 * i + 1][1] > points[idx][1]) idx = 2 * i + 1;
        if (2 * i + 2 < len && points[2 * i + 2][1] > points[idx][1]) idx = 2 * i + 2;
        if (idx != i) {
            swap (points, i, idx);
            adjustHeap (points, idx);
        }
    }

    private void swap(int[][] points, int i, int j) {
        int[] tmp = points[i];
        points[i] = points[j];
        points[j] = tmp;
    }
}
