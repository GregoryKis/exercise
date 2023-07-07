package com.exercise.strings;

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

    public static void main(String[] args) {
        System.out.println(new Subsequence().isSubsequence("abasdfcasd","abc"));
    }
}
