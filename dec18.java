//this is temporary
class Solution {
    public int maxProductDifference(int[] nums) {
        PriorityQueue<Integer> max=new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> min=new PriorityQueue<>();

        for(int i:nums){
            max.offer(i);
            min.offer(i);
        }

        return ((max.poll()*max.poll()) - (min.poll()*min.poll()));
    }
}
