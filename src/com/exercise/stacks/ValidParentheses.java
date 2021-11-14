package com.exercise.stacks;

import java.util.Stack;

public class ValidParentheses {

    public boolean isValid(String s) {

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            char op = 0;

            if (c == ')')
                op = '(';
            if (c == '}')
                op = '{';
            if (c == ']')
                op = '[';

            if (!stack.empty() && stack.peek().equals((int) op)) {
                stack.pop();
                continue;
            }
            stack.push((int) s.charAt(i));
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        ValidParentheses validParentheses = new ValidParentheses();
        String[] inputGood = {"", "()", "{}", "[]", "({[]})()[]{}"};
        for (int i = 0; i < inputGood.length; i++) {
            boolean ret = validParentheses.isValid(inputGood[i]);
            if (!ret)
                System.out.println("The return is = " + ret + ", expected = true  string =" + inputGood[i]);
        }

        String[] inputBad = {"(", "(]", "(){", "({})("};
        for (int i = 0; i < inputBad.length; i++) {
            boolean ret = validParentheses.isValid(inputBad[i]);
            if (ret)
                System.out.println("The return is = " + ret + ", expected = false");
        }
    }
}
