package leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 119. 杨辉三角 II
 * @Description
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 *
 * 输入: 3
 * 输出: [1,3,3,1]
 * @auther SHENKAIHUAN
 * @create 2019-08-15 23:22
 */
public class PascalTriangleII {
    public static void main(String[] args) {
        int num = 3;
        long start = System.currentTimeMillis ();
        List<Integer> result =getRow(num);
        long end =System.currentTimeMillis ();
        System.out.println ("total:"+(end-start));
        for (Integer integer : result) {
            System.out.print (integer + ", ");
        }
    }
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> integers = new ArrayList<> ();
        //rowIndex 等于30时 int溢出
        long lastNum = 1;
        for(int i=1;i<=rowIndex+1;i++){
            integers.add ((int)lastNum);
            //数学公式
            lastNum = lastNum * (rowIndex - i + 1)/i;
        }
        return integers ;
    }
}
