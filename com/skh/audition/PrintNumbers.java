package audition;

/**
 * 面试题17. 打印从1到最大的n位数
 * @Description
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。
 * 比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 *
 * 输入: n = 1
 * 输出: [1,2,3,4,5,6,7,8,9]
 * @auther SHENKAIHUAN
 * @create 2020-04-05 1:00
 */
public class PrintNumbers {
    public static void main(String[] args) {
        int n =3;
        long start =System.currentTimeMillis ();
        System.out.println (printNumbers(n));
        long end =System.currentTimeMillis ();
        System.out.println ("total:"+(end-start));

    }
    public static int[] printNumbers(int n) {
        int size = (int) (Math.pow (10,n)-1);
        int[] result= new int[size];
        for (int i=0;i<size;i++){
            result[i]=i+1;
        }
        return result;

    }
}
