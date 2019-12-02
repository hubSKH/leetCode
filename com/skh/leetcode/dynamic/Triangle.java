package leetcode.dynamic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 120. 三角形最小路径和
 * @Description
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * 例如，给定三角形：
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * 说明：
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 * @auther SHENKAIHUAN
 * @create 2019-11-26 23:16
 */
public class Triangle {
    public static void main(String[] args) {
        List<List<Integer>> triangle=new ArrayList<> ();
//        triangle.add (Arrays.asList (    -1));
//        triangle.add (Arrays.asList (   2,3));
//        triangle.add (Arrays.asList (1,-1,-3));
        triangle.add (Arrays.asList ( 7));
        triangle.add (Arrays.asList (-5,9));
        triangle.add (Arrays.asList (6,5,2));
        triangle.add (Arrays.asList (-8,-2,-7,3));
        triangle.add (Arrays.asList (-2,6,-6,-1,4));
        long start =System.currentTimeMillis ();
        System.out.println (minimumTotal(triangle));
        long end =System.currentTimeMillis ();
        System.out.println ("total:"+(end-start));
    }
//    public static int minimumTotal(List<List<Integer>> triangle) {
//        //计算到达每个终点的最小路径和，存minPath中
//        int[] minPath = null;
//        for(int row =0;row<triangle.size ();row++){
//            List<Integer> thisRow= triangle.get (row);
//            int[] path=new int[thisRow.size ()];
//            if(minPath ==null){
//                //起点行
//                for(int col=0;col<thisRow.size ();col++){
//                    path[col]=thisRow.get (col);
//                }
//            }else {
//                for(int col=0;col<thisRow.size ();col++){
//                    int curPath=thisRow.get (col);
//                    int minPre;
//                    if(col==0){
//                        minPre= minPath[col];
//                    }else if(col==thisRow.size ()-1){
//                        minPre=minPath[col-1];
//                    }else {
//                        minPre=minPath[col-1]<minPath[col]?minPath[col-1]:minPath[col];
//                    }
//                    path[col]=minPre+curPath;
//                }
//            }
//            minPath=path;
//        }
//        //找出最小路径
//        int min=minPath[0];
//        for(int i=1;i<minPath.length;i++){
//            if(minPath[i]<min){
//                min=minPath[i];
//            }
//        }
//        return min;
//
//    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        int rowLen =triangle.size ();
        int[] minLen =new int[rowLen];
        for ( int row=0;row<rowLen;row++){
            if(row==0){
                minLen[0]=triangle.get (row).get (0);
            }else {
                for (int col=0 ;col<=row;col++){
                    int minPre;
                    if(col==0){
                        minPre=minLen[row-col-1];
                    }else if(col==row){
                        minPre=minLen[row-col];
                    }else {
                        minPre=Math.min (minLen[row-col],minLen[row-col-1]);
                    }
                    minLen[row-col] =minPre+triangle.get (row).get (row-col);
                }
            }
        }
        int min=minLen[0];
        for(int i=1;i<minLen.length;i++){
            if(minLen[i]<min){
                min=minLen[i];
            }
        }
        return min;
    }
}
