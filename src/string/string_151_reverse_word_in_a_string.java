package string;

import java.util.ArrayList;
import java.util.List;

/*
Given an input string, reverse the string word by word.

Example:

Input: "the sky is blue",
Output: "blue is sky the".
Note:

A word is defined as a sequence of non-space characters.
Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
You need to reduce multiple spaces between two words to a single space in the reversed string.
Follow up: For C programmers, try to solve it in-place in O(1) space.
 */
class string_151_reverse_word_in_a_string {
    public static String reverseWords(String s) {
        if (s == null || s.length() < 1) {
            return s;
        }
        StringBuilder temp = new StringBuilder();
        int p1 = s.length() - 1;
        while (p1 >= 0) {
            StringBuilder stringBuilder = new StringBuilder();
            while (p1 >= 0 && ' ' != s.charAt(p1)) {
                stringBuilder.append(s.charAt(p1));
                p1--;
                System.out.println(p1);
            }
            temp.append(reverseString(stringBuilder.toString()));
            if (p1 >= 0) {
                temp.append(" ");
            }
            p1--;
        }
        return temp.toString();
    }

    public static String reverseString(String s) {
        if (s == null || s.length() < 1) {
            return s;
        }
        char[] temp = new char[s.length()];
        int start = 0, end = s.length() - 1;
        while (start <= end) {
            temp[start] = s.charAt(end);
            temp[end] = s.charAt(start);
            start++;
            end--;
        }
        return String.valueOf(temp);
    }


    public static void main(String[] args) {
        System.out.println(reverseWords(" "));
    }
}
