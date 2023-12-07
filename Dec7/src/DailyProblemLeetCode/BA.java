package DailyProblemLeetCode;

public class BA {
    public String largestOddNumber(String num) {
        int oddIndex=-1;
        for(int i=num.length()-1;i>=0;i--){
            if((num.charAt(i) - '0')%2!=0){
                oddIndex=i;
                break;
            }
        }
        if(oddIndex==-1) return "";
        return num.substring(0,oddIndex+1);
    }
}
