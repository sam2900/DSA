package MergeKSortedLists;

public class Best {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null || lists.length==0) return null;
        return mergeSort(lists,0,lists.length-1);
    }

    public ListNode mergeSort(ListNode[] lists, int start, int end){
        if(start==end) return lists[start];
        //since only 1 element so already sorted

        int mid= start + (end-start) /2;
        ListNode left=mergeSort(lists,start,mid);
        ListNode right=mergeSort(lists,mid+1,end);
        return merge(left,right);
    }

    public ListNode merge(ListNode l1, ListNode l2){
        ListNode list=new ListNode(0);
        ListNode head=list;

        while(l1!=null && l2!=null){
            if(l1.val<=l2.val){
                head.next=l1;
                l1=l1.next;
            }else{
                head.next=l2;
                l2=l2.next;
            }
            head=head.next;
        }
        //now here there can be a possibility that either of them is non empty
        head.next=(l1!=null) ? l1:l2;
        return list.next;
    }
}
