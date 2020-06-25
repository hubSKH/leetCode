package audition;

import java.util.Arrays;

/**
 * 剑指 Offer 60. n个骰子的点数
 * @Description
 * 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
 * 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
 *
 * 输入: 1
 * 输出: [0.16667,0.16667,0.16667,0.16667,0.16667,0.16667]
 * @auther SHENKAIHUAN
 * @create 2020-06-25 16:07
 */
public class NSum {

    public static void main(String[] args) {
        int n=2;
        System.out.println (Arrays.toString (twoSum (n)));

    }
    public static double[] twoSum(int n) {
        double[] res = new double[]{1/6d,1/6d,1/6d,1/6d,1/6d,1/6d};
        for(int i=2;i<=n;i++){
            double[] tmp =new double[5*i+1];
            for(int j=0;j<res.length;j++){
                for (int x=0;x<6;x++)
                    tmp[j+x] +=res[j]/6;
            }
            res=tmp;
        }
        return res;

    }
}
