package audition;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 57 - II. 和为s的连续正数序列
 * @Description
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 *
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 * @auther SHENKAIHUAN
 * @create 2020-06-20 15:42
 */
public class FindContinuousSequence {
    public static void main(String[] args) {
        int target=9;
        int[][] continuousSequence = findContinuousSequence (target);
    }
    public static int[][] findContinuousSequence(int target) {
        int i=1;
        int j=1;
        int sum=0;
        List<int[]> result=new ArrayList<> ();
        while (i<=target/2){
            if(sum<target){
                sum+=j;
                j++;
            }else if(sum>target){
                sum-=i;
                i++;
            }else {
                int[] res= new int[j-i];
                for(int k=i;k<j;k++){
                    res[k-i]=k;
                }
                result.add (res);
                sum-=i;
                i++;
            }
        }
        return result.toArray (new int[result.size ()][]);

    }
}
