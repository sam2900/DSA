package MergeKSortedLists;

import java.util.PriorityQueue;

public class BFA {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode list=null;
        if(lists.length==0) return null;
        PriorityQueue<Integer> heap=new PriorityQueue<>();
        for(ListNode i:lists){
            while(i!=null){
                heap.offer(i.val);
                i=i.next;
            }
        }
        int curr;
        ListNode head=null;
        while(!heap.isEmpty()){
            curr=heap.poll();
            if(list==null){
                list=new ListNode(curr);
                head=list;
            }else{
                ListNode c=new ListNode(curr);
                list.next=c;
                list=list.next;
            }
        }
        return head;
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
