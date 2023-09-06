package com.madd.samples.problemsolving;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class BalancedBrackets {
    public static void main(String[] args) {
        String brackets = "{{[}}";
        if (isBalanced(brackets)) {
            System.out.println("Balanced");
        } else {
            System.out.println("Un Balanced");
        }
    }

    private static boolean isBalanced(String brackets) {
        // Odd length string cannot be balanced.
        if (brackets == null || brackets.length() == 0 || brackets.length() % 2 != 0) {
            return false;
        } else {
            char[] ch = brackets.toCharArray();
            List<Character> ltValid = Arrays.asList('[', '{', '(');
            List<Character> rtValid = Arrays.asList(']', '}', ')');
            Stack<Character> stack = new Stack<>();
            for (char c : ch) {
//                if (!(c == '{' || c == '[' || c == '(' || c == '}' || c == ']' || c == ')')) {
//                    return false;
//                }

                if (ltValid.contains(c)) {
                    stack.push(c);
                } else if (rtValid.contains(c)) {
                    if (stack.empty()) {
                        return false;
                    }
                    Character top = stack.pop();
                    Character match  = rtValid.get(ltValid.indexOf(top));
                    if (!match.equals(c)) {
                        return false;
                    }
                } else {
                    // Not a valid character.
                    return false;
                }
            }
        }
        return true;
    }
}
