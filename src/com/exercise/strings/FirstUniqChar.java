package com.exercise.strings;

public class FirstUniqChar {

    public int firstUniqChar(String s) {

        // only english lower later are allowed.
        int[] recurrenceArr = new int[26];

        for (int i = 0; i < s.length(); i++) {
            recurrenceArr[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if(recurrenceArr[s.charAt(i) - 'a'] == 1){
                return i;
            }
        }

        return -1;
    }


    public static void main(String[] args) {
        FirstUniqChar firstUniqChar = new FirstUniqChar();
        String[] inputGood = {"a", "z", "aabbbc"};
        for (int i = 0; i < inputGood.length; i++) {
            int ret = firstUniqChar.firstUniqChar(inputGood[i]);
            System.out.println("The return is = " + ret + ", the char =" + inputGood[i].charAt(ret) + ", string =" + inputGood[i]);
        }

        String[] inputBad = {"aa", "zz", "aabbb"};
        for (int i = 0; i < inputBad.length; i++) {
            int ret = firstUniqChar.firstUniqChar(inputBad[i]);
            System.out.println("The return is = " + ret);
        }
    }
}
