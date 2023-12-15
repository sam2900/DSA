package ReplaceElementWithRank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

public class BFA {
    public static List<Integer> replaceWithRank(List<Integer> arr, int n) {
        // Write your code here
        List<Integer> a=new ArrayList<>();
        TreeMap<Integer,Integer> map=new TreeMap<>();
        for(Integer i:arr){
            a.add(i);
        }
        Collections.sort(a);
        for(Integer i:a){
            if(!map.containsKey(i)){
                map.put(i,map.size()+1);
            }
        }
        for(int i=0;i<arr.size();i++){
            arr.set(i, map.get(arr.get(i)));
        }
        return arr;
    }
}
