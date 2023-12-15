package ReplaceElementWithRank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class Better {
    public static List<Integer> replaceWithRank(List<Integer> arr, int n) {
        // Write your code here
        List<Integer> ans=new ArrayList<>();
        HashMap<Integer,Integer> map=new HashMap<>();
        PriorityQueue<Integer> heap=new PriorityQueue<>();

        for(Integer i:arr){
            heap.add(i);
        }
        int rank=1;
        while(!heap.isEmpty()){
            int top=heap.poll();
            if(!map.containsKey(top)){
                map.put(top, rank++);
            }
        }
        for(Integer i:arr){
            ans.add(map.get(i));
        }
        return ans;
    }
}
