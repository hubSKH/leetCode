package leetcode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * 763. 划分字母区间
 *
 * @Description 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。
 * 返回一个表示每个字符串片段的长度的列表。
 * <p>
 * 输入：S = "ababcbacadefegdehijhklij"
 * 输出：[9,7,8]
 * 解释：
 * 划分结果为 "ababcbaca", "defegde", "hijhklij"。
 * 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
 * @auther SHENKAIHUAN
 * @create 2021-07-25 23:00
 */
public class PartitionLabels {
    public static void main(String[] args) {

        PartitionLabels partitionLabels = new PartitionLabels ();
        String str = "ababcbacadefegdehijhklij";
        List<Integer> list = partitionLabels.partitionLabels (str);
        System.out.println (list);
    }

    public List<Integer> partitionLabels(String s) {
        int[] maxIdxArray = new int[26];
        int len = s.length ();
        for (int i = 0; i < len; i++) {
            maxIdxArray[s.charAt (i) - 'a'] = i;
        }
        List<Integer> result = new ArrayList<> ();
        int left = 0, right = 0;
        for (int i = 0; i < len; i++) {
            right = Math.max (right, maxIdxArray[s.charAt (i) - 'a']);
            if (i == right) {
                result.add (right - left + 1);
                left = right + 1;
            }
        }
        return result;
    }

/*    public List<Integer> partitionLabels(String s) {
        Map<Character, int[]> map = new HashMap<> ();
        for (int i = 0; i < s.length (); i++) {
            char c = s.charAt (i);
            if (map.containsKey (c)) {
                int[] ints = map.get (c);
                ints[1] = i;
            } else {
                map.put (c, new int[]{i, i});
            }
        }
        int[][] matrix = map.values ().toArray (new int[map.size ()][]);
        heapSortByRight (matrix);
        int minLeft = matrix[0][0], maxRight = matrix[0][1];
        List<Integer> result = new ArrayList<> ();
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] > maxRight) {
                result.add (maxRight - minLeft + 1);
                minLeft = matrix[i][0];
                maxRight = matrix[i][1];
            } else {
                maxRight = Math.max (maxRight, matrix[i][1]);
            }
        }
        result.add (maxRight - minLeft + 1);
        return result;
    }

    int len;

    private void heapSortByRight(int[][] matrix) {
        len = matrix.length;
        buildHeap (matrix);
        while (len > 0) {
            swap (matrix, 0, len - 1);
            len--;
            adjustHeap (matrix, 0);
        }
    }

    private void buildHeap(int[][] matrix) {
        for (int i = (len - 1) / 2; i >= 0; i--) {
            adjustHeap (matrix, i);
        }
    }

    private void adjustHeap(int[][] matrix, int i) {
        int idx = i;
        if (2 * i + 1 < len && matrix[2 * i + 1][0] > matrix[idx][0]) idx = 2 * i + 1;
        if (2 * i + 2 < len && matrix[2 * i + 2][0] > matrix[idx][0]) idx = 2 * i + 2;
        if (idx != i) {
            swap (matrix, idx, i);
            adjustHeap (matrix, idx);
        }
    }

    private void swap(int[][] matrix, int i, int j) {
        int[] tmp = matrix[i];
        matrix[i] = matrix[j];
        matrix[j] = tmp;
    }*/
}
