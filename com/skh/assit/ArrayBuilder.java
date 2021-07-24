package assit;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @auther SHENKAIHUAN
 * @create 2021-07-24 22:03
 */
public class ArrayBuilder {
    public static void main(String[] args) {
        String str = "[[1,9],[7,16],[2,5],[7,12],[9,11],[2,10],[9,16],[3,9],[1,3]]";
        int[][] matrix = buildMatrix (str);
    }

    public static int[][] buildMatrix(String str) {
        List<String> arraySpilt = new ArrayList<> ();

        for (int i = 0; i < str.length (); i++) {
            if (str.charAt (i) - '0' <0 || str.charAt (i) - '0' >9) {
                continue;
            }
            int idx = searchFor (str, i);
            String arrayStr = str.substring (i,idx);
            i=idx;
            arraySpilt.add (arrayStr);
        }
        int[][] result =new int[arraySpilt.size ()][];
        for (int i = 0; i < arraySpilt.size (); i++) {
            String s = arraySpilt.get (i);
            String[] split = s.split (",");
            int[] ints=new int[split.length];
            for (int j = 0; j < split.length; j++) {
                ints[j]=Integer.parseInt (split[j]);
            }
            result[i]=ints;
        }
        return result;
    }

    private static int searchFor(String str, int i) {
        while (i < str.length ()) {
            if (str.charAt (i) == ']') {
                return i;
            }
            i++;
        }
        return i;
    }
}
