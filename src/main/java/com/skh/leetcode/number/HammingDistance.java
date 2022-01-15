package leetcode.number;

/**
 * 461. 汉明距离
 * @Description
 * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 * 给出两个整数 x 和 y，计算它们之间的汉明距离。
 * 注意：
 * 0 ≤ x, y < 231.
 *
 * 输入: x = 1, y = 4
 * 输出: 2
 * 解释:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ↑   ↑
 * 上面的箭头指出了对应二进制位不同的位置。
 * @auther SHENKAIHUAN
 * @create 2021-03-17 20:43
 */
public class HammingDistance {
    public static void main(String[] args) {
        int x = 1;
        int y =4;
        System.out.println (hammingDistance (x,y));

    }
    public static int hammingDistance(int x, int y) {
        return Integer.bitCount (x^y);
    }
    //布赖恩·克尼根算法
//    public int hammingDistance(int x, int y) {
//        int xor = x ^ y;
//        int distance = 0;
//        while (xor != 0) {
//            distance += 1;
//            // remove the rightmost bit of '1'
//            xor = xor & (xor - 1);
//        }
//        return distance;
//    }
}
