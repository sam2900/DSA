package CodeStudio.MergeKSortedLists;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class BFA {
    public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> kArrays, int k)
    {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(ArrayList<Integer> list:kArrays){
            for(Integer i:list){
                pq.offer(i);
            }
        }
        ArrayList<Integer> ans=new ArrayList<>();
        while(!pq.isEmpty()){
            ans.add(pq.poll());
        }
        return ans;
    }
}
