class Solution {
    public int findSpecialInteger(int[] arr) {
        int maxCount=0;
        int maxIndex=-1;
        int count=0;
        for(int i=0;i<arr.length-1;i++){
            if(arr[i]==arr[i+1]){
                count++;
                if(count>maxCount){
                    maxCount=count;
                    maxIndex=i;
                }
            }else{
                count=0;
            }
        }
        if(maxIndex==-1) return arr[0];
        return arr[maxIndex];
    }
}