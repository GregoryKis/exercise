package com.exercise.algorithms;
public class Test {
    public boolean isPalindrome(String s) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ('0' <= c && c <= '9') {
                str.append(c);
            } else if ('A' <= c && c <= 'Z') {
                str.append((char)(c + 32));
            } else if ('a' <= c && c <= 'z') {
                str.append(c);
            }
        }
        System.out.println(str);
        String s1 = str.toString();
        for (int i = 0; i < s1.length() / 2; i++) {
            if (s1.charAt(i) != s1.charAt(s1.length() - 1 - i)) {
                System.out.println(i);
                System.out.println(s1.charAt(i) +" "+s1.charAt(s1.length() - 1 - i));
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Test().isPalindrome("ab2a"));
    }


}
