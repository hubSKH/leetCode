package leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 118. 杨辉三角
 * @Description
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * 输入: 5
 * 输出:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 * @auther SHENKAIHUAN
 * @create 2019-08-13 22:53
 */
public class PascalTriangle {
    public static void main(String[] args) {
        int num = 5;
        long start = System.currentTimeMillis ();
        List<List<Integer>> result =generate(num);
        long end =System.currentTimeMillis ();
        System.out.println ("total:"+(end-start));
        for(List<Integer> list : result){
            for(Integer integer :list){
                System.out.print(integer+", ");
            }
            System.out.println ();
        }
    }
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<> ();
        List<Integer> lastList=null;
        if(numRows<1){
            return lists;
        }
        for(int i=1;i<=numRows;i++){
            List<Integer> integers = new ArrayList<> ();
            for(int j=0;j<i;j++){
                if(j==0 || j==i-1){
                    integers.add (1);
                }else {
                    int num = lastList.get (j-1)+lastList.get (j);
                    integers.add (num);
                }
            }
            lists.add (integers);
            lastList =integers;
        }
        return lists;
    }
}
