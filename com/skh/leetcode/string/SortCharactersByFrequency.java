package leetcode.string;

import java.util.*;

/**
 * 451. 根据字符出现频率排序
 * @Description
 * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
 *
 * 输入:
 * "tree"
 *
 * 输出:
 * "eert"
 *
 * 解释:
 * 'e'出现两次，'r'和't'都只出现一次。
 * 因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
 *
 * @auther SHENKAIHUAN
 * @create 2019-11-05 22:31
 */
public class SortCharactersByFrequency {
    public static void main(String[] args) {
        String str ="AAAabb";
        long start = System.currentTimeMillis ();
        System.out.println (frequencySort (str));
        long end =System.currentTimeMillis ();
        System.out.println ("total:"+(end-start));
    }
    public static String frequencySort(String s) {
        int[] counts =new int[256];
        int letterCount =0;
        for(int i=0;i<s.length ();i++){
            int letterIdx =s.charAt (i);
            if(counts[letterIdx]==0){
                letterCount++;
            }
            counts[letterIdx]++;
        }
        char[] letters =new char[letterCount];
        for(int i=0;i<counts.length;i++){
            if(i==letterCount){
                break;
            }
            int max =counts[i];
            int maxIdx = i;
            for(int j=i;j<counts.length;j++){
                if(counts[j]>max){
                    max = counts[j];
                    maxIdx =j;
                }
            }
            letters[i] =(char)maxIdx;
            exchange(counts,i,maxIdx);
        }
        char[] result =new char[s.length ()];
        int resIdx=0;
        for(int i=0;i<letterCount;i++){
            if(counts[i]==0){
                return new String (result);
            }
            for (int j=0;j<counts[i];j++){
                result[resIdx] =letters[i];
                resIdx++;
            }
        }
        return new String (result);
    }
    private static void exchange(int[] counts, int i, int maxIdx) {
        int temp =counts[i];
        counts[i]=counts[maxIdx];
        counts[maxIdx]=temp;
    }
    private static void exchange(char[] letters, int i, int maxIdx) {
        char temp =letters[i];
        letters[i]=letters[maxIdx];
        letters[maxIdx]=temp;
    }
//    public static String frequencySort(String s) {
//
//        Map<Character,Integer> counts =new HashMap<> ();
//        for(int i=0;i<s.length ();i++){
//            char key = s.charAt (i);
//            if(counts.containsKey (key)){
//                counts.put (key,counts.get (key)+1);
//            }else {
//                counts.put (key,1);
//            }
//        }
//        List<Map.Entry<Character,Integer>> list =new LinkedList<> (counts.entrySet ());
//        Collections.sort (list, new Comparator<Map.Entry<Character, Integer>> () {
//            @Override
//            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
//                return -o1.getValue ()+o2.getValue ();
//            }
//        });
//
//        StringBuilder sb =new StringBuilder ();
//        for(Map.Entry<Character,Integer> entry : list){
//            for (int i=0;i<entry.getValue ();i++){
//                sb.append (entry.getKey ());
//            }
//        }
//        return sb.toString ();
//
//    }

}
