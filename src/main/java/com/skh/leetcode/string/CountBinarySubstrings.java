package leetcode.string;

/**
 * 696. 计数二进制子串
 * @Description
 * 给定一个字符串 s，计算具有相同数量0和1的非空(连续)子字符串的数量，
 * 并且这些子字符串中的所有0和所有1都是组合在一起的。
 *
 * 重复出现的子串要计算它们出现的次数。
 *
 * 输入: "00110011"
 * 输出: 6
 * 解释: 有6个子串具有相同数量的连续1和0：“0011”，“01”，“1100”，“10”，“0011” 和 “01”。
 *
 * @auther SHENKAIHUAN
 * @create 2019-09-12 23:55
 */
public class CountBinarySubstrings {
    public static void main(String[] args) {
        String s = "10101";
        long start =System.currentTimeMillis ();
        System.out.println (countBinarySubstrings (s));
        long end =System.currentTimeMillis ();
        System.out.println ("total:"+(end-start));
    }

   /* public static int countBinarySubstrings(String s) {

        int count =0;
        //记录一段连续数字出现的数量
        int[] bitCount = new int[2];
        char[] chars =s.toCharArray ();
        bitCount[chars[0]-'0']++;
        for(int i =1; i<chars.length;i++){
            int idx =chars[i]-'0';
            if(chars[i]!=chars[i-1]){
                //数字改变,清空改变后数字的原来的计数
                bitCount[idx]=0;
            }
            bitCount[idx]++;
            //正在计数的字符数量小于等于另一个数字之前的数量
            boolean accept =bitCount[idx]<= bitCount[idx^1];
            if(accept){
                count++;
            }
        }
        return count;
    }*/
   public static int countBinarySubstrings(String s) {
       int count =0;

       //初始，当前数字段数字数量1，前一段数字数量0
       int pre=0,cur=1;
       char[] chars =s.toCharArray ();
       for(int i=1;i<chars.length;i++){
           if(chars[i]!=chars[i-1]){
               //跳数字段，重新计算
               pre=cur;
               cur=1;
           }else {
               //当前数字段计数+1
               cur++;
           }
           if(pre>=cur){
               //前面段数字数量大于等于当前计数，说明存在一种结果
               count++;
           }
       }
       return count;

   }
}
