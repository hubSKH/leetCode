package leetcode.array;

/**
 * @Description
 *
 * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 *
 * 给定 nums = [3,2,2,3], val = 3,
 * 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
 * 你不需要考虑数组中超出新长度后面的元素。
 *
 * @auther SHENKAIHUAN
 * @create 2019-07-20 10:55
 */
public class RemoveElement {
    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,3,12};
        int val =0;
        for (int i:nums){
            System.out.print(i+", ");
        }
        System.out.println ();
        long start =System.currentTimeMillis ();
        System.out.println (removeElement (nums,val));
        long end =System.currentTimeMillis ();
        System.out.println ("total:"+(end-start));
        for (int i:nums){
            System.out.print(i+", ");
        }
        System.out.println ();
    }

    public static int removeElement(int[] nums, int val) {
        int length = nums.length;
        for(int i=0;i<length;){
            if(nums[i] == val){
                nums[i] = nums[length-1];
                //交换
//                nums[i] +=nums[length-1];
//                nums[length-1] = nums[i] - nums[length-1];
//                nums[i] =nums[i] - nums[length-1];
                length--;
            }else {
                i++;
            }
        }
        return length;
    }
}
