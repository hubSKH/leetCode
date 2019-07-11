package MoveZeroes;

/**
 * @Description
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 示例:
 *   输入: [0,1,0,3,12]
 *   输出: [1,3,12,0,0]
 * 说明:
 *   必须在原数组上操作，不能拷贝额外的数组。
 *   尽量减少操作次数。
 *
 * @auther SHENKAIHUAN
 * @create 2019-07-11 22:50
 */
public class MoveZeroes {
    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,3,12};
        for (int i:nums){
            System.out.print(i+", ");
        }
        System.out.println ();
        long start =System.currentTimeMillis ();
        moveZeroes (nums);
        long end =System.currentTimeMillis ();
        System.out.println ("total:"+(end-start));
        for (int i:nums){
            System.out.print(i+", ");
        }
        System.out.println ();
    }

    public static void moveZeroes(int[] nums) {

        for(int i=nums.length-1,j=nums.length;i>=0;i--){
            if(nums[i]==0){
                move(nums,i,--j);
            }
        }

    }

    private static void move(int[] nums, int i,int j) {
        int temp=nums[i];
        for (;i<j;){
            nums[i]=nums[++i];
        }
        nums[i]=temp;
    }
}
