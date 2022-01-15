package leetcode.array;

import java.util.List;

/**
 * 417. 太平洋大西洋水流问题
 * @Description
 * 给定一个 m x n 的非负整数矩阵来表示一片大陆上各个单元格的高度。“太平洋”处于大陆的左边界和上边界，而“大西洋”处于大陆的右边界和下边界。
 * 规定水流只能按照上、下、左、右四个方向流动，且只能从高到低或者在同等高度上流动。
 * 请找出那些水流既可以流动到“太平洋”，又能流动到“大西洋”的陆地单元的坐标。
 * 提示：
 * 输出坐标的顺序不重要
 * m 和 n 都小于150
 *
 * @auther SHENKAIHUAN
 * @create 2021-10-12 22:21
 */
public class PacificAtlantic {
    public static void main(String[] args) {
        int[][] height =new int[][]{
                {1,2,2,3,5},
                {3,2,3,4,4},
                {2,4,5,3,1},
                {6,7,1,4,5},
                {5,1,1,2,4}
        };
        List<List<Integer>> list = new PacificAtlantic ().pacificAtlantic (height);
        for (List<Integer> integers : list) {
            System.out.println (integers);
        }
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
return null;
    }
}
