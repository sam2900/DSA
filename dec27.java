class Solution {
    public int minCost(String colors, int[] neededTime) {
        int time=0;
        int i=0;
        int j=i+1;
        while(j<colors.length()){
            if(colors.charAt(i)==colors.charAt(j)){
                if(neededTime[i]<neededTime[j]){
                    time+=neededTime[i];
                    i=j;
                    j++;
                }else{
                    time+=neededTime[j];
                    j++;
                }
            }else{
                i=j;
                j++;
            }
        }
        return time;
    }
}
