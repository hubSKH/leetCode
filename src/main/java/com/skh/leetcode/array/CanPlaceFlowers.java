package leetcode.array;

/**
 * 605. 种花问题
 *
 * @Description 假设你有一个很长的花坛，一部分地块种植了花，另一部分却没有。
 * 可是，花卉不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 * <p>
 * 给定一个花坛（表示为一个数组包含0和1，其中0表示没种植花，1表示种植了花），和一个数 n 。
 * 能否在不打破种植规则的情况下种入 n 朵花？能则返回True，不能则返回False。
 * <p>
 * 输入: flowerbed = [1,0,0,0,1], n = 1
 * 输出: True
 * @auther SHENKAIHUAN
 * @create 2020-09-13 9:54
 */
public class CanPlaceFlowers {

    public static void main(String[] args) {
        int[] flowerbed = new int[]{1,0,0,0,0,1};
        int n = 2;
        System.out.println (new CanPlaceFlowers().canPlaceFlowers (flowerbed, n));
    }

    //    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
//
//        int count=0;
//        for (int i=0;i<flowerbed.length;i++){
//            if(flowerbed[i]==0 && (i==0 || flowerbed[i-1]==0) && (i==flowerbed.length-1 || flowerbed[i+1]==0)){
//                flowerbed[i]=1;
//                count++;
//            }
//            if(count>=n) return true;
//        }
//        return false;
//
//    }
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int pre = -1, count = 0, length = flowerbed.length;
        for (int i = 0; i < length; i++) {
            if (flowerbed[i] == 1) {
                if (pre == -1) {
                    count += i / 2;
                } else {
                    count += (i - pre - 2) / 2;
                }
                pre = i;
            }
        }
        if (pre == -1) {
            count += (length + 1) / 2;
        } else {
            count += (length - pre - 1) / 2;
        }
        return count >= n;
    }
}
