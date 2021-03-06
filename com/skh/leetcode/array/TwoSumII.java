package leetcode.array;

/**
 * 167. 两数之和 II - 输入有序数组
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 *
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 *
 * @Description
 * @auther SHENKAIHUAN
 * @create 2019-08-05 23:30
 */
public class TwoSumII {
    public static void main(String[] args) {
        int[] array = {-1,0};
        int target = -1;
        long start = System.currentTimeMillis ();
        int[] indices =twoSum(array,target);
        long end = System.currentTimeMillis ();
        for (int i : indices){
            System.out.print(i+", ");
        }
        System.out.println ();
        System.out.println ("total:"+(end-start));
    }

   /* private static int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<> ();
        for(int i=0;i<numbers.length;i++){
            int firstNum = numbers[i];
            int forNum = target - firstNum;
            if(map.containsKey (forNum)){
                return new int[]{map.get (forNum)+1,i+1};
            }
            map.put (numbers[i],i);
        }
        return  null;
    }*/

    /**
     * 双指针
     * @param numbers
     * @param target
     * @return
     */
   private static int[] twoSum(int[] numbers, int target) {
       int left= 0;
       int right= numbers.length-1;
       while (left< right){
           int sum =numbers[left] + numbers[right];
           if (sum > target){
               right--;
           }else if(sum < target){
               left++;
           }else {
               return new int[]{left+1,right+1};
           }
       }
       return  null;
   }
}
