package audition;

import java.util.Arrays;

/**
 * 剑指 Offer 66. 构建乘积数组
 * @Description
 * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B 中的元素 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 *
 * 输入: [1,2,3,4,5]
 * 输出: [120,60,40,30,24]
 * @auther SHENKAIHUAN
 * @create 2020-07-01 22:20
 */
public class ConstructArr {

    public static void main(String[] args) {
        int[] a =new int[]{1,2,3,4,5};
        System.out.println (Arrays.toString (constructArr(a)));

    }

    public static int[] constructArr(int[] a) {
        if(a.length==0) return new int[0];
        int res[]=new int[a.length];
        res[0]=1;
        for(int i=1;i<res.length;i++){
            res[i] =res[i-1]*a[i-1];
        }
        int temp=1;
        for(int i=res.length-2;i>=0;i--){
            temp*=a[i+1];
            res[i]*=temp;
        }
        return res;
    }
}
