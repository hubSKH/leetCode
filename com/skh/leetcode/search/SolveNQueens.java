package leetcode.search;

import java.util.*;

/**
 * 51. N 皇后
 *
 * @Description n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
 * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * <p>
 * 输入：n = 1
 * 输出：[["Q"]]
 * @auther SHENKAIHUAN
 * @create 2021-10-17 9:02
 */
public class SolveNQueens {
    public static void main(String[] args) {
        int n = 4;
        List<List<String>> solveNQueens = new SolveNQueens ().solveNQueens (n);
        for (List<String> solveNQueen : solveNQueens) {
            System.out.println (solveNQueen);
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<> ();
        int[] queens = new int[n];
        Arrays.fill (queens, -1);
        boolean[] colFlags = new boolean[n];
        boolean[] ldiagonal = new boolean[2 * n];
        boolean[] rdiagonal = new boolean[2 * n];
        solveNQueens (result, queens, colFlags, ldiagonal, rdiagonal, 0, n);

        return result;
    }

    private void solveNQueens(List<List<String>> result, int[] queens, boolean[] colFlags, boolean[] ldiagonal, boolean[] rdiagonal, int rowIndx, int n) {
        if (rowIndx == n) {
            List<String> ans = new ArrayList<> ();
            for (int i = 0; i < n; i++) {
                char[] row = new char[n];
                Arrays.fill (row, '.');
                row[queens[i]] = 'Q';
                ans.add (new String (row));
            }
            result.add (ans);
            return;
        }
        for (int i = 0; i < n; i++) {
            // +n 防止坐标差为负数
            int ldiag = rowIndx - i + n;
            int rdiag = rowIndx + i;
            if (colFlags[i] || ldiagonal[ldiag] || rdiagonal[rdiag]) {
                continue;
            }
            colFlags[i] = ldiagonal[ldiag] = rdiagonal[rdiag] = true;
            queens[rowIndx] = i;
            solveNQueens (result, queens, colFlags, ldiagonal, rdiagonal, rowIndx + 1, n);
            colFlags[i] = ldiagonal[ldiag] = rdiagonal[rdiag] = false;
            queens[rowIndx] = -1;
        }

    }


/*  //使用集合，性能较慢，好理解
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<> ();
        int[] queens = new int[n];
        Arrays.fill (queens, -1);
        boolean[] colFlags = new boolean[n];
        Deque<Integer> ldiagonal = new LinkedList ();
        Deque<Integer> rdiagonal = new LinkedList ();
        solveNQueens (result, queens, colFlags, ldiagonal, rdiagonal, 0, n);

        return result;
    }

    private void solveNQueens(List<List<String>> result, int[] queens, boolean[] colFlags, Deque<Integer> ldiagonal, Deque<Integer> rdiagonal, int rowIndx, int n) {
        if (rowIndx == n) {
            List<String> ans = new ArrayList<> ();
            for (int i = 0; i < n; i++) {
                char[] row = new char[n];
                Arrays.fill (row, '.');
                row[queens[i]] = 'Q';
                ans.add (new String (row));
            }
            result.add (ans);
            return;
        }
        for (int i = 0; i < n; i++) {
            // 方向一的斜线为从左上到右下方向，同一条斜线上的每个位置满足行下标与列下标之差相等
            int ldiag = rowIndx - i;
            // 方向二的斜线为从右上到左下方向，同一条斜线上的每个位置满足行下标与列下标之和相等
            int rdiag = rowIndx + i;
            if (colFlags[i] || ldiagonal.contains (ldiag) || rdiagonal.contains (rdiag)) {
                continue;
            }

            colFlags[i] = true;
            ldiagonal.add (ldiag);
            rdiagonal.add (rdiag);
            queens[rowIndx] = i;
            solveNQueens (result, queens, colFlags, ldiagonal, rdiagonal, rowIndx + 1, n);
            colFlags[i] = false;
            ldiagonal.removeLast ();
            rdiagonal.removeLast ();
            queens[rowIndx] = -1;
        }
    }*/
}
