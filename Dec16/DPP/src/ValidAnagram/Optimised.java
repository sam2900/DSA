package ValidAnagram;

public class Optimised {
    public boolean isAnagram(String s, String t) {
        //now since we know there will be at-most 26 chars possible
        //so we create a frequency array of 26 chars
        int[] chr=new int[26];
        //here the starting will be 0..25 so a->0 and z->25
        //now to the char is represented as unicode int values, so to get the correct form in index
        //we will subtract it by a i.e., 97
        //now we traverse each char of string s and update the frequency
        //for traversing the chars, we need to convert the string into a character array
        //for this we use string.toCharArray() -> to convert the string into char array
        for(char c:s.toCharArray()){
            chr[c-'a']++;
        }
        //now we have stores the frequency of string s now for string t we will subtract
        //so if the strings are anagram the end result will be 0 frequency for all chars, else non-zero
        for(char c:t.toCharArray()){
            //one optimisation we can do here is, if t has more frequency of a character
            //then it will drop the frequency to -1 in chr[] so if it happens then it wont be a anagram
            // chr[c-'a']--;
            if(--chr[c-'a'] < 0) return false;
        }
        for(int i:chr){
            if(i!=0) return false;
        }
        return true;
    }
}
