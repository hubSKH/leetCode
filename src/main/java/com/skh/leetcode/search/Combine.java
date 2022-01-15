package leetcode.search;

import java.util.*;

/**
 * 77. 组合
 *
 * @Description 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * 你可以按 任何顺序 返回答案。
 * <p>
 * 输入：n = 4, k = 2
 * 输出：
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 * @auther SHENKAIHUAN
 * @create 2021-10-16 17:20
 */
public class Combine {
    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        List<List<Integer>> combine = new Combine ().combine (n, k);
        for (List<Integer> list : combine) {
            System.out.println (list);
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<> ();
        Deque<Integer> combine = new LinkedList<> ();
        combine (result, combine, 1, n, k);
        return result;
    }

    private void combine(List<List<Integer>> result, Deque<Integer> combineList, int i, int n, int k) {
        if (k==0) {
            result.add (new ArrayList<> (combineList));
            return;
        }
        for (int j = i; j <= n-k+1; j++) {
            combineList.add (j);
            combine (result, combineList, j + 1, n, k-1);
            combineList.removeLast ();
        }
    }
}
