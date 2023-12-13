package KthLargestElement;

import java.util.Collections;
import java.util.PriorityQueue;

public class BFA {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap=new PriorityQueue<>(Collections.reverseOrder());
        for(Integer i: nums){
            heap.add(i);
        }

        while(k!=1){
            heap.poll();
            k--;
        }
        if(k==1){
            return heap.poll();
        }
        return -1;
    }
}
