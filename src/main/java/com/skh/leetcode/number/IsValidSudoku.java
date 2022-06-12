package leetcode.number;

/**
 * 36. 有效的数独
 * <p>
 * 请你判断一个 9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
 * <p>
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
 * <p>
 * 注意：
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 * 空白格用 '.' 表示。
 * <p>
 * 示例 1：
 * 输入：board =
 * [["5","3",".",".","7",".",".",".","."]
 * ,["6",".",".","1","9","5",".",".","."]
 * ,[".","9","8",".",".",".",".","6","."]
 * ,["8",".",".",".","6",".",".",".","3"]
 * ,["4",".",".","8",".","3",".",".","1"]
 * ,["7",".",".",".","2",".",".",".","6"]
 * ,[".","6",".",".",".",".","2","8","."]
 * ,[".",".",".","4","1","9",".",".","5"]
 * ,[".",".",".",".","8",".",".","7","9"]]
 * 输出：true
 *
 * @auther SHENKAIHUAN
 * @create 2022/6/12 14:49
 */
public class IsValidSudoku {
    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        System.out.println(new IsValidSudoku().isValidSudoku(board));
    }
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rowVaild=new boolean[9][9];
        boolean[][] colVaild=new boolean[9][9];
        boolean[][][] blockVaild =new boolean[3][3][9];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if(board[row][col]=='.'){
                    continue;
                }
                int idx =board[row][col]-'0'-1;
                if(rowVaild[row][idx]||colVaild[col][idx] || blockVaild[row/3][col/3][idx]){
                    return false;
                }
                rowVaild[row][idx]=true;
                colVaild[col][idx]=true;
                blockVaild[row/3][col/3][idx]=true;
            }
        }
        return true;
    }
   /* public boolean isValidSudoku(char[][] board) {
        return rowVaild(board) && colVaild(board) && blockVaild(board, 0, 0);
    }

    private boolean blockVaild(char[][] board, int row, int col) {
        if (row >= board.length || col >= board[row].length) {
            return true;
        }
        boolean[] valid = new boolean[10];
        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (valid[board[i][j] - '0']) {
                    return false;
                }
                valid[board[i][j] - '0'] = true;
            }
        }
        return blockVaild(board, row + 3, col) && blockVaild(board, row, col + 3);
    }

    private boolean colVaild(char[][] board) {
        for (int col = 0; col < 9; col++) {
            boolean[] valid = new boolean[10];
            for (int row = 0; row < 9; row++) {
                if (board[row][col] == '.') {
                    continue;
                }
                if (valid[board[row][col] - '0']) {
                    return false;
                }
                valid[board[row][col] - '0'] = true;
            }
        }
        return true;
    }

    private boolean rowVaild(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            boolean[] valid = new boolean[10];
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] == '.') {
                    continue;
                }
                if (valid[board[row][col] - '0']) {
                    return false;
                }
                valid[board[row][col] - '0'] = true;
            }
        }
        return true;
    }*/
}
