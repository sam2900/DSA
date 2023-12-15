package TopKFrequentElements;

import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

class BFA {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        PriorityQueue<Pair> heap=new PriorityQueue<>(Collections.reverseOrder());
        for(Integer i:map.keySet()){
            heap.offer(new Pair(i,map.get(i)));
        }
        int[] ans=new int[k];
        int i=0;
        while(k!=0){
            ans[i]=heap.poll().value;
            i++;
            k--;
        }
        return ans;
    }
}

class Pair implements Comparable<Pair>{
    int value;
    int freq;

    public Pair(int value, int freq){
        this.value=value;
        this.freq=freq;
    }
    @Override
    public int compareTo(Pair o){
        if(this.freq < o.freq){
            return -1;
        }else{
            return 1;
        }
    }
}