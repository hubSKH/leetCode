package leetcode.array;

import assit.ArrayBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * 406. 根据身高重建队列
 *
 * @Description 假设有打乱顺序的一群人站成一个队列，数组 people 表示队列中一些人的属性（不一定按顺序）。
 * 每个 people[i] = [hi, ki] 表示第 i 个人的身高为 hi ，前面 正好 有 ki 个身高大于或等于 hi 的人。
 * 请你重新构造并返回输入数组 people 所表示的队列。
 * 返回的队列应该格式化为数组 queue ，其中 queue[j] = [hj, kj] 是队列中第 j 个人的属性（queue[0] 是排在队列前面的人）。
 * <p>
 * 输入：people = [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
 * 输出：[[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]
 * 解释：
 * 编号为 0 的人身高为 5 ，没有身高更高或者相同的人排在他前面。
 * 编号为 1 的人身高为 7 ，没有身高更高或者相同的人排在他前面。
 * 编号为 2 的人身高为 5 ，有 2 个身高更高或者相同的人排在他前面，即编号为 0 和 1 的人。
 * 编号为 3 的人身高为 6 ，有 1 个身高更高或者相同的人排在他前面，即编号为 1 的人。
 * 编号为 4 的人身高为 4 ，有 4 个身高更高或者相同的人排在他前面，即编号为 0、1、2、3 的人。
 * 编号为 5 的人身高为 7 ，有 1 个身高更高或者相同的人排在他前面，即编号为 1 的人。
 * 因此 [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]] 是重新构造后的队列。
 * @auther SHENKAIHUAN
 * @create 2021-08-08 15:44
 */
public class ReconstructQueue {
    public static void main(String[] args) {
        String arrayStr = "[[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]";
        int[][] people = ArrayBuilder.buildMatrix (arrayStr);
        ReconstructQueue reconstructQueue = new ReconstructQueue ();
        int[][] afterConstruct = reconstructQueue.reconstructQueue (people);
        System.out.print ("[");
        for (int[] ints : afterConstruct) {
            System.out.print ("[");
            for (int anInt : ints) {
                System.out.print (anInt + ",");
            }
            System.out.print ("]");
        }
        System.out.println ("]");
    }

    /**
     * 按升高从大到小
     * 按人数从小到大
     * @param people
     * @return
     */
    public int[][] reconstructQueue(int[][] people) {
        heapSort (people);
        List<int[]> resultList = new ArrayList<> (people.length);
        for (int[] person : people) {
            resultList.add (person[1],person);
        }
        return resultList.toArray (new int[people.length][]);
    }

    int len;

    private void heapSort(int[][] people) {
        len = people.length;
        buildHeap (people);
        while (len > 0) {
            swap (people, 0, len - 1);
            len--;
            adjustHeap (people, 0);
        }
    }

    private void buildHeap(int[][] people) {
        for (int i = (len - 1) / 2; i >= 0; i--) {
            adjustHeap (people, i);
        }
    }

    private void adjustHeap(int[][] people, int i) {
        int idx = i;
        if (2 * i + 1 < len) {
            if (people[2 * i + 1][0] < people[idx][0]) {
                idx = 2 * i + 1;
            } else if (people[2 * i + 1][0] == people[idx][0] && people[2 * i + 1][1] > people[idx][1]) {
                idx = 2 * i + 1;
            }
        }
        if (2 * i + 2 < len) {
            if (people[2 * i + 2][0] < people[idx][0]) {
                idx = 2 * i + 2;
            } else if (people[2 * i + 2][0] == people[idx][0] && people[2 * i + 2][1] > people[idx][1]) {
                idx = 2 * i + 2;
            }
        }

        if (idx != i) {
            swap (people, idx, i);
            adjustHeap (people, idx);
        }
    }

    private void swap(int[][] people, int i, int j) {
        int[] tmp = people[i];
        people[i] = people[j];
        people[j] = tmp;
    }
}
