package com.exercise.strings;

import java.util.Arrays;

public class Binary {
    public String add(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = 0, carry = 0, lenA = a.length() - 1, lenB = b.length() - 1;
        while (i <= lenA && i <= lenB) {
            int s = carry + (a.charAt(lenA - i) - '0') + (b.charAt(lenB - i) - '0');
            System.out.println("i=" + i + ", carry=" + carry + ", s=" + s + ", sb=" + sb);
            sb.append((char) ('0' + s % 2));
            System.out.println(sb);
            if (s > 1)
                carry = 1;
            else
                carry = 0;
            i++;
        }
        System.out.println("i=" + i + ", carry=" + carry + ", sb=" + sb);
        int lenC = 0;
        String c;
        if (lenA > lenB) {
            lenC = lenA;
            c = a;
        } else {
            lenC = lenB;
            c = b;
        }
        while (i <= lenC) {
            int s = carry + (c.charAt(lenC - i) - '0');
            sb.append((char) ('0' + s % 2));
            if (s > 1)
                carry = 1;
            else
                carry = 0;
            i++;
        }
        if (carry > 0)
            sb.append('1');
        return sb.reverse().toString();
    }

    public static int reverse(int n) {
        n = (n & 0xffff0000 >> 16) | (n & 0x0000ffff << 16);
        n = (n & 0xff00ff00 >> 8) | (n & 0x00ff00ff << 8);
        n = (n & 0xf0f0f0f >> 4) | (n & 0x0f0f0f0f << 4);
        n = (n & 0xccccccc >> 2) | (n & 0x33333333 << 2);
        n = (n & 0xbbbbbbb >> 1) | (n & 0x55555555 << 1);
        return n;
    }

    public int singleNumber(int[] nums) {
        int[] bitArr= new int[32];
        for(int i=0;i<32;i++){
            for(int num:nums){
                if(((num>>>i)&1)>0){
                    bitArr[i]++;
                }
                System.out.println(Arrays.toString(bitArr));
            }
        }
        int ret=0;
        for(int i=0;i<32;i++){
            bitArr[i]%=3;
            System.out.print(bitArr[i]);
            ret|=(bitArr[i]<<i);
        }
        System.out.println();
        return ret;
    }
    public static void main(String[] args) {
//        System.out.println(new Binary().add("1010", "1011"));
//        System.out.println(new Binary().reverse(3330791104));
        System.out.println(new Binary().singleNumber(new int[]{2,2,-3,2}));
    }
}
