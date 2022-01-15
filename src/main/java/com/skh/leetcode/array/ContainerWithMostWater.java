package leetcode.array;

/**
 * 11. 盛最多水的容器
 * @Description
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 *
 * 输入: [1,8,6,2,5,4,8,3,7]
 * 输出: 49
 * @auther SHENKAIHUAN
 * @create 2019-10-03 12:15
 */
public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] nums = new int[]{1,8,6,2,5,4,8,3,7};
        long start =System.currentTimeMillis ();
        System.out.println (maxArea (nums));
        long end =System.currentTimeMillis ();
        System.out.println ("total:"+(end-start));
    }

    /**
     * 暴力破解
     * @param height
     * @return
     */
   /* public static int maxArea(int[] height) {

        int max =0;
        for (int i=0;i<height.length-1;i++){
            for(int j=i+1;j<height.length;j++){
                int contain = Math.min (height[i],height[j])*(j-i);
                max = Math.max (contain,max);
            }
        }
        return  max;

    }*/

    /**
     * 双指针
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        int left =0,right=height.length-1;
        int max =0;
        while (left<right){
            max= Math.max (Math.min (height[left],height[right])*(right-left),max);
            if(height[left]<height[right]){
                left++;
            }else {
                right--;
            }
        }
        return max;
    }
}
