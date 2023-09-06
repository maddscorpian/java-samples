package com.madd.samples.problemsolving;

import java.util.Stack;

public class ReverseString {
    public static void main(String[] args) {
        String input = "madd";
        String reverseStr = reversee(input);
        System.out.println(reverseStr);
        System.out.println(reverse2(input));
    }

    private static String reversee(String input) {
        Stack<Character> stack = new Stack<>();
        char output[] = new char[input.length()];
        for (char c : input.toCharArray()) {
            stack.push(c);
        }
        int idx = 0;
        while (!stack.empty()) {
            output[idx++] = stack.pop();
        }

        return new String(output);
    }

    private static String reverse2(String input) {
        String rev = "";
        for (char c : input.toCharArray()) {
            rev = c+rev;
        }
        return rev;
    }

}
