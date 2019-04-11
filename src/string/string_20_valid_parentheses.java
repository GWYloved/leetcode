package string;

import java.util.Stack;

/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.

Example 1:

Input: "()"
Output: true
Example 2:

Input: "()[]{}"
Output: true
Example 3:

Input: "(]"
Output: false
Example 4:

Input: "([)]"
Output: false
Example 5:

Input: "{[]}"
Output: true
 */
public class string_20_valid_parentheses {
    public static boolean isValid(String s) {
        char[] temp = s.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        for (char t : temp){
            if (!stack.isEmpty() && stack.peek() == getReverse(t)){
                stack.pop();
            }else {
                stack.push(t);
            }
        }
        return stack.isEmpty();
    }
    private static char getReverse(char t){
        switch (t){
            case '(':
                return ')';
            case ')':
                return '(';
            case '{':
                return '}';
            case '}':
                return '{';
            case '[':
                return ']';
            case ']':
                return '[';
        }
        return ' ';
    }

    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("([)]"));
        System.out.println(isValid("{[]}"));
    }
    /**
     * 用stack做比较容易
     */
}
