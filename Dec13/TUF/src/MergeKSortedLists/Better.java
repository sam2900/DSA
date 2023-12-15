package MergeKSortedLists;

import java.util.ArrayList;
import java.util.Collections;

public class Better {
    public ListNode mergeKLists(ListNode[] lists) {
        ArrayList<Integer> list=new ArrayList<>();
        for(ListNode i:lists){
            while(i!=null){
                list.add(i.val);
                i=i.next;
            }
        }
        Collections.sort(list);
        ListNode ans=null;
        ListNode head=null;
        for(Integer i:list){
            ListNode curr=new ListNode(i);
            if(ans==null){
                ans=curr;
                head=ans;
            }else{
                ans.next=curr;
                ans=ans.next;
            }
        }
        return head;
    }
}
