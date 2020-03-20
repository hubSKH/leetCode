package audition;

/**
 * 面试题12. 矩阵中的路径
 * @Description
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。
 * 如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。
 * 例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
 *
 * [["a","b","c","e"],
 * ["s","f","c","s"],
 * ["a","d","e","e"]]
 *
 * 但矩阵中不包含字符串“abfb”的路径，
 * 因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，
 * 路径不能再次进入这个格子。
 *
 *
 * @auther SHENKAIHUAN
 * @create 2020-03-14 10:58
 */
public class TraceInMatrix {
    public static void main(String[] args) {
        char[][] board =new char[][]{
                {'A','B','C','E'},
                {'S','F','E','S'},
                {'A','D','E','E'}
        };
        String word = "ABCESEEEFS";

        for (char[] i:board){
            for (char j : i){
                System.out.print(j+", ");
            }
            System.out.println ();
        }
        long start =System.currentTimeMillis ();
        System.out.println (exist(board,word));
        long end =System.currentTimeMillis ();
        System.out.println ("total:"+(end-start));
    }
    public static boolean exist(char[][] board, String word) {
        char[] ws =word.toCharArray ();
        int rows = board.length;
        if(rows ==0){
            return false;
        }
        int columns = board[0].length;
        boolean[][] flag = new boolean[rows][columns];//记录点是否已经使用

        for(int r =0;r<rows;r++){
            for(int l=0;l<columns;l++){
                //判断是否符合
                if(check(board,r,l,ws,0,flag)){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 递归，深度遍历
     * @param board
     * @param r
     * @param l
     * @param ws
     * @param i
     * @param flag
     * @return
     */
    private static boolean check(char[][] board, int r, int l, char[] ws, int i, boolean[][] flag) {
        if(board[r][l] == ws[i] && !flag[r][l]){
            if(i== ws.length-1){
                return true;
            }
            //标记
            flag[r][l] =true;
            i++;
            boolean check = isInBoard (board,r-1,l) && check (board,r-1,l,ws,i,flag)
                    ||  isInBoard (board,r+1,l) &&check (board,r+1,l,ws,i,flag)
                    ||  isInBoard (board,r,l-1) &&check (board,r,l-1,ws,i,flag)
                    ||  isInBoard (board,r,l+1) &&check (board,r,l+1,ws,i,flag);
            flag[r][l] =false;
            return check;
        }
        return false;
    }

    private static boolean isInBoard(char[][] board ,int r,int l){
        if(r<0 || r>board.length-1 || l<0 || l>board[0].length-1){
            //越界了
            return false;
        }
        return true;
    }
}
