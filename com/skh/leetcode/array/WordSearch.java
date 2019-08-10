package leetcode.array;

/**
 * 79. 单词搜索
 * @Description
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * 给定 word = 'ABCCED', 返回 true.
 * 给定 word = 'SEE', 返回 true.
 * 给定 word = 'ABCB', 返回 false.
 *
 * @auther SHENKAIHUAN
 * @create 2019-08-10 12:12
 */
public class WordSearch {
    public static void main(String[] args) {
        char[][] board =new char[][]{
                {'A','B','C','E'},
                {'S','F','E','S'},
                {'A','D','E','E'}
        };
//        char[][] board =new char[][]{
//                {'a','a'},
//        };
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
