package audition;

/**
 * 面试题49. 丑数
 * @Description
 * 我们把只包含因子 2、3 和 5 的数称作丑数（Ugly Number）。
 * 求按从小到大的顺序的第 n 个丑数。
 *
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 * @auther SHENKAIHUAN
 * @create 2020-05-26 22:57
 */
public class NthUglyNumber {
    public static void main(String[] args) {
        int n=10;
        System.out.println (nthUglyNumber (n));

    }
    public static int nthUglyNumber(int n) {
        int a=0,b=0,c=0;
        int[] nums=new int[n];
        nums[0]=1;
        for(int i=1;i<n;i++){
            int numA=nums[a]*2,numB=nums[b]*3,numC=nums[c]*5;
            nums[i]= Math.min (Math.min (numA,numB),numC);
            if(nums[i]==numA) a++;
            if(nums[i]==numB) b++;
            if(nums[i]==numC) c++;
        }
        return nums[n-1];
    }
}
