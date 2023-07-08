package com.exercise.strings;

import java.util.HashMap;
import java.util.Map;

public class Subsequence {
    public boolean isSubsequence(String s, String t) {
        int i=0;
        int j=0;
        while(i<s.length()&&j<t.length()){
            if(s.charAt(i)==t.charAt(j))
                j++;
            i++;
        }
        return j==t.length();
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] cArr=new int[26];
        for(int i=0;i<magazine.length();i++){
            cArr[magazine.charAt(i)-'a']++;
        }
        for(int i=0;i<ransomNote.length();i++){
            cArr[ransomNote.charAt(i)-'a']--;
            if(cArr[ransomNote.charAt(i)-'a']<0){
                return false;
            }
        }
        return true;
    }

    public boolean isIsomorphic(String s, String t) {

        Map<Character, Character> mapS=new HashMap<>();
        Map<Character, Character> mapT=new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(mapS.containsKey(s.charAt(i)) || mapT.containsKey(t.charAt(i))){
                System.out.println(s.charAt(i));
                if(!mapS.containsKey(s.charAt(i))||!mapT.containsKey(t.charAt(i)) || mapS.get(s.charAt(i)) != t.charAt(i) || mapT.get(t.charAt(i))!=s.charAt(i))
                    return false;
                System.out.println("S "+mapS);
                System.out.println("T "+mapT);
            }else{
                System.out.println("S "+mapS);
                System.out.println("T "+mapT);
                mapS.put(s.charAt(i), t.charAt(i));
                mapT.put(t.charAt(i), s.charAt(i));
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        System.out.println(new Subsequence().isSubsequence("abasdfcasd","abc"));
//        System.out.println(new Subsequence().canConstruct("ab", "a"));
        System.out.println(new Subsequence().isIsomorphic("badc","baba"));
    }
}
