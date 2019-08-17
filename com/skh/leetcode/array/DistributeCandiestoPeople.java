package leetcode.array;

/**
 * 1103. 分糖果 II
 * @Description
 * 排排坐，分糖果。
 * 我们买了一些糖果 candies，打算把它们分给排好队的 n = num_people 个小朋友。
 *
 * 给第一个小朋友 1 颗糖果，第二个小朋友 2 颗，依此类推，直到给最后一个小朋友 n 颗糖果。
 *
 * 然后，我们再回到队伍的起点，给第一个小朋友 n + 1 颗糖果，第二个小朋友 n + 2 颗，
 * 依此类推，直到给最后一个小朋友 2 * n 颗糖果。
 *
 * 重复上述过程（每次都比上一次多给出一颗糖果，当到达队伍终点后再次从队伍起点开始），直到我们分完所有的糖果。
 * 注意，就算我们手中的剩下糖果数不够（不比前一次发出的糖果多），这些糖果也会全部发给当前的小朋友。
 *
 * 返回一个长度为 num_people、元素之和为 candies 的数组，
 * 以表示糖果的最终分发情况（即 ans[i] 表示第 i 个小朋友分到的糖果数）。
 *
 * 输入：candies = 7, num_people = 4
 * 输出：[1,2,3,1]
 * 解释：
 * 第一次，ans[0] += 1，数组变为 [1,0,0,0]。
 * 第二次，ans[1] += 2，数组变为 [1,2,0,0]。
 * 第三次，ans[2] += 3，数组变为 [1,2,3,0]。
 * 第四次，ans[3] += 1（因为此时只剩下 1 颗糖果），最终数组变为 [1,2,3,1]。
 *
 * 输入：candies = 10, num_people = 3
 * 输出：[5,2,3]
 * 解释：
 * 第一次，ans[0] += 1，数组变为 [1,0,0]。
 * 第二次，ans[1] += 2，数组变为 [1,2,0]。
 * 第三次，ans[2] += 3，数组变为 [1,2,3]。
 * 第四次，ans[0] += 4，最终数组变为 [5,2,3]。
 * @auther SHENKAIHUAN
 * @create 2019-08-17 15:35
 */
public class DistributeCandiestoPeople {
    public static void main(String[] args) {
        int candies =10;
        int numPeople = 3;
        long start =System.currentTimeMillis ();
        int[] result =distributeCandies (candies,numPeople);
        long end =System.currentTimeMillis ();
        for(int i: result ){
            System.out.print (i+", ");
        }
        System.out.println ("total:"+(end-start));
    }

    public static int[] distributeCandies(int candies, int num_people) {

        int[] result = new int[num_people];
        //当前分配的糖果数量
        int currentCandies = 1;
        //分配人的下标
        int person = 0;

        while (candies > 0) {
            if (candies > currentCandies) {
                result[person] = result[person] + currentCandies;
                candies -= currentCandies;
            } else {
                //数量不足，全部给最后一个人
                result[person] = result[person] + candies;
                candies=0;
            }

            if (person +1 == num_people) {
                //重新回到第一个人
                person = 0;
            }else {
                person++;
            }
            currentCandies++;
        }
        return result;
    }

    //数学方法解，根据等差公式Sn=na1+ (n-1)d/2 ==> Sn=(1+n)n/2
   /* public int[] distributeCandies(int candies, int num_people) {
        int[] woe = new int[num_people];
        double total_1 = (1+num_people)*num_people/2;
        double subtract = num_people*num_people;
        double b = total_1-subtract/2;
        double a = subtract/2;
        double up = Math.sqrt(b*b+4*a*candies)-b;
        int iterations = (int) (up/2/a);
        int candy =  num_people*iterations;
        int surplus = candies - (1+candy)*candy/2;
        for(int i=0; i<num_people; i++) {
            if(surplus>candy) {
                ++candy;
                woe[i] = (i+1)*iterations+num_people*iterations*(iterations-1)/2+candy;
                surplus-=candy;
            }
            else {
                woe[i] = (i+1)*iterations+num_people*iterations*(iterations-1)/2+surplus;
                surplus=0;
            }
        }
        return woe;
    }*/
}
