package DailyProblemLeetCode;
/**
 * so this is my BFA
 * basically here i maintain oddIndex variable
 * now i traverse through the string and update the oddIndex variable to the
 * last odd number's index in the string
 * suppose we have odd number present only at 1st position then it will be the largest
 * but if we have a odd number present later in the string, then the number starting from 0th index till that odd number
 * will be the largest odd number in the string
 * so in the end we check if we have found an odd number's index or not, if not we return empty string
 * else we return the subtring starting from 0th index till oddIndex + 1
 *
 *
 * things i learnt here
 * to convert a char number into integer, we subtract it by '0'
 */

public class Solution {
    public String largestOddNumber(String num) {
        int oddIndex=-1;
        for(int i=0;i<num.length();i++){
            if((num.charAt(i) - '0')%2!=0){
                oddIndex=i;
            }
        }
        if(oddIndex==-1) return "";
        return num.substring(0,oddIndex+1);
    }
}
