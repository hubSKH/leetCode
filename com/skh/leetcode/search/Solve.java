package leetcode.search;

/**
 * 130. 被围绕的区域
 *
 * @Description 给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 * @auther SHENKAIHUAN
 * 输入：board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
 * 输出：[["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
 * 解释：被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。
 * 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。
 * 如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 * @create 2021-10-26 21:18
 */
public class Solve {
    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };
        new Solve ().solve (board);
        for (char[] chars : board) {
            System.out.println (chars);
        }
    }

    public void solve(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < row; i++) {
            dfs (board, i, 0, row, col);
            dfs (board, i, col - 1, row, col);
        }
        for (int i = 0; i < col; i++) {
            dfs (board, 0, i, row, col);
            dfs (board, row - 1, i, row, col);
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j, int row, int col) {
        if (i < 0 || j < 0 || i == row || j == col || board[i][j] != 'O') {
            return;
        }
        board[i][j] = 'A';
        dfs (board, i - 1, j, row, col);
        dfs (board, i + 1, j, row, col);
        dfs (board, i, j - 1, row, col);
        dfs (board, i, j + 1, row, col);
    }
}
