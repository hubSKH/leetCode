package comp.NO166;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @auther SHENKAIHUAN
 * @create 2019-12-08 11:28
 */
public class UserGroup {
    public static void main(String[] args) {
        int[] groupSizes = new int[]{3,3,3,3,3,1,3};
        groupThePeople(groupSizes);
    }
    public static List<List<Integer>> groupThePeople(int[] groupSizes) {

        List<List<Integer>> result =new ArrayList<> ();
        Map<Integer,List<Integer>> groupSizeMap = new HashMap<> ();
        for(int i=0;i<groupSizes.length;i++){
            if(groupSizeMap.containsKey (groupSizes[i])){
                groupSizeMap.get (groupSizes[i]).add (i);
            }else {
                List<Integer> list =new ArrayList<> ();
                list.add (i);
                groupSizeMap.put (groupSizes[i],list);
            }
        }
        for (Map.Entry<Integer,List<Integer>> entry : groupSizeMap.entrySet ()){
            int size =entry.getKey ();
            List<Integer> integerList =entry.getValue ();
            for(int i =0;i<integerList.size ();i=i+size){
                result.add (integerList.subList (i,i+size));
            }
        }
        return result;

    }
}
