package leetcode.array;

/**
 * 1184. 公交站间的距离
 * @Description
 *
 * 环形公交路线上有 n 个站，按次序从 0 到 n - 1 进行编号。
 * 我们已知每一对相邻公交站之间的距离，
 * distance[i] 表示编号为 i 的车站和编号为 (i + 1) % n 的车站之间的距离。
 * 环线上的公交车都可以按顺时针和逆时针的方向行驶。
 * 返回乘客从出发点 start 到目的地 destination 之间的最短距离。
 *
 * 输入：distance = [1,2,3,4], start = 0, destination = 1
 * 输出：1
 * 解释：公交站 0 和 1 之间的距离是 1 或 9，最小值是 1。
 * @auther SHENKAIHUAN
 * @create 2019-10-10 23:54
 */
public class DistanceBetweenBusStops {
    public static void main(String[] args) {
        int[] nums = new int[]{7,10,1,12,11,14,5,0};
        int st =7;
        int destination=2;
        long start =System.currentTimeMillis ();
        System.out.println (distanceBetweenBusStops (nums,st,destination));
        long end =System.currentTimeMillis ();
        System.out.println ("total:"+(end-start));
    }
    public static int distanceBetweenBusStops(int[] distance, int start, int destination) {

        int lineFirst = 0;
        int lineSec =0;
        int min = Math.min (start,destination);
        int max = Math.max (start,destination);
        for(int i=0;i<distance.length;i++){
            if(i>=min && i<max){
                lineFirst+=distance[i];
            }else {
                lineSec+=distance[i];
            }
        }
        return Math.min (lineFirst,lineSec);

    }
}
