package ValidAnagram;

import java.util.HashMap;

public class BFA {
    public static boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        HashMap<Character,Integer> s1=new HashMap<>();
        HashMap<Character,Integer> s2=new HashMap<>();
        for(int i=0;i<s.length();i++){
            s1.put(s.charAt(i),s1.getOrDefault(s.charAt(i),0)+1);
            s2.put(t.charAt(i),s2.getOrDefault(t.charAt(i),0)+1);
        }
        for(Character c:s1.keySet()){
            if(!s2.containsKey(c)){
                return false;
            }
            System.out.println(s1.get(c) + " " + s2.get(c));
            if(s1.get(c)-s2.get(c) != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
