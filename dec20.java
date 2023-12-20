class Solution {
    public int buyChoco(int[] prices, int money) {
        int min=Integer.MAX_VALUE;
        int sMin=Integer.MAX_VALUE;

        for(int i:prices){
            if(i<min){
                sMin=min;
                min=i;
            }else{
                if(i<sMin){
                    sMin=i;
                }
            }
        }

        if(sMin+min > money) return money;
        return money-(sMin+min);
    }
}
