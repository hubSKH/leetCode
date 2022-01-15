package leetcode.search;

import assit.ArrayBuilder;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 934. 最短的桥
 * @Description
 * 在给定的二维二进制数组 A 中，存在两座岛。（岛是由四面相连的 1 形成的一个最大组。）
 * 现在，我们可以将 0 变为 1，以使两座岛连接起来，变成一座岛。
 * 返回必须翻转的 0 的最小数目。（可以保证答案至少是 1 。）
 *
 * 输入：A = [[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
 * 输出：1
 * @auther SHENKAIHUAN
 * @create 2021-10-23 15:08
 */
public class ShortestBridge {
    public static void main(String[] args) {
        int[][] grid = ArrayBuilder.buildMatrix ("[[0,0,1,0,1],[0,1,1,0,1],[0,1,0,0,1],[0,0,0,0,0],[0,0,0,0,0]]");
        System.out.println (new ShortestBridge ().shortestBridge (grid));

    }
    public int shortestBridge(int[][] grid) {
        Queue<int[]> queue = new LinkedList<> ();
        boolean isFound =false;
        int row=grid.length,col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(isFound) break;
                if(grid[i][j]==1){
                    dfsFindFirstLand(queue,grid,i,j,row,col);
                    isFound=true;
                }
            }
        }
        // bfs
        int x,y;
        int level =0;
        while (!queue.isEmpty ()){
            level++;
            int size =queue.size ();
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll ();
                for (int j = 0; j < dierections.length; j++) {
                    x =poll[0]+dierections[j][0];
                    y=poll[1]+dierections[j][1];
                    if(x<=0 || y<0||x>=row||y>=col||grid[x][y]==2){
                        continue;
                    }
                    if(grid[x][y]==1){
                        return level;
                    }
                    queue.add (new int[]{x,y});
                    grid[x][y]=2;
                }
            }
        }

        return 0;
    }
    private int[][] dierections=new int[][]{{-1,0},{1,0},{0,-1},{0,1}};

    private void dfsFindFirstLand(Queue<int[]> queue, int[][] grid, int i, int j, int row, int col) {
        if(i<0||j<0||i==row||j==col||grid[i][j]==2){
            return;
        }
        if(grid[i][j]==0){
            queue.add (new int[]{i,j});
            return;
        }
        grid[i][j]=2;
        dfsFindFirstLand (queue, grid, i-1, j, row, col);
        dfsFindFirstLand (queue, grid, i+1, j, row, col);
        dfsFindFirstLand (queue, grid, i, j-1, row, col);
        dfsFindFirstLand (queue, grid, i, j+1, row, col);
    }
}
