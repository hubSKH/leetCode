package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 830. 较大分组的位置
 * @Description
 * 在一个由小写字母构成的字符串 S 中，包含由一些连续的相同字符所构成的分组。
 * 例如，在字符串 S = "abbxxxxzyy" 中，就含有 "a", "bb", "xxxx", "z" 和 "yy" 这样的一些分组。
 * 我们称所有包含大于或等于三个连续字符的分组为较大分组。找到每一个较大分组的起始和终止位置。
 * 最终结果按照字典顺序输出。
 *
 * 输入: "abbxxxxzzy"
 * 输出: [[3,6]]
 * 解释: "xxxx" 是一个起始于 3 且终止于 6 的较大分组。
 * @auther SHENKAIHUAN
 * @create 2019-10-02 23:36
 */
public class PositionsofLargeGroups {
    public static void main(String[] args) {
        String s = "abcdddeeeeaabbbcd";
        long start =System.currentTimeMillis ();
        List<List<Integer>> result=largeGroupPositions (s);
        long end =System.currentTimeMillis ();
        for(List<Integer> list :result){
            System.out.print("[");
            for(Integer num: list){
                System.out.print(num+", ");
            }
            System.out.println ("]");
        }
        System.out.println ("total:"+(end-start));
    }

    public static List<List<Integer>> largeGroupPositions(String S) {

        List<List<Integer>> result =new ArrayList<> ();
        for (int i=0;i<S.length ();i++){
            char c = S.charAt (i);
            for(int j=i;j<S.length ();j++){
                if(j+1<S.length () && S.charAt (j+1)==c){
                    //数组没越界，字符与之前记录的相等，则继续
                }else {
                    //不相等，连续超过3个则记录符合结果
                    //然后继续下一个
                    if(j-i>=2){
                        result.add (Arrays.asList (i,j));
                    }
                    i=j;
                    break;
                }

            }
        }
        return  result;
    }
}
