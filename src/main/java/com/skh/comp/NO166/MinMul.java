package comp.NO166;



/**
 * @Description
 * @auther SHENKAIHUAN
 * @create 2019-12-08 11:19
 */
public class MinMul {
    public static void main(String[] args) {
        int n = 4421;
        System.out.println (subtractProductAndSum(n));



    }

    public static int subtractProductAndSum(int n) {
        java.math.BigInteger mul =java.math.BigInteger.ONE;
        java.math.BigInteger sum = java.math.BigInteger.ZERO;
        while (n!=0){
            int num = n%10;
            mul =mul.multiply (java.math.BigInteger.valueOf (num));
            sum =sum.add (java.math.BigInteger.valueOf (num));
            n/=10;
        }
        return (int) (mul.longValue ()-sum.longValue ());
    }
}
