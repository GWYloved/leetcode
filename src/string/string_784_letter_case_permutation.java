package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.  Return a list of all possible strings we could create.

Examples:
Input: S = "a1b2"
Output: ["a1b2", "a1B2", "A1b2", "A1B2"]

Input: S = "3z4"
Output: ["3z4", "3Z4"]

Input: S = "12345"
Output: ["12345"]
Note:

S will be a string with length between 1 and 12.
S will consist only of letters or digits.
 */
class string_784_letter_case_permutation {
    public static List<String> letterCasePermutation(String S) {
        List<String> result = new ArrayList<>();
        result.add(S);
        foo(S, 0, S.length(), result);
        return result;
    }

    private static void foo(String s, int startIndex, int endIndex, List<String> result) {
        for (int i = startIndex; i < endIndex; i++) {
            if ((int) s.charAt(i) >= 97 && (int) s.charAt(i) <= 122) {
                foo(s, i + 1, endIndex, result);
                char[] temp = s.toCharArray();
                temp[i] = Character.toUpperCase(temp[i]);
                s = String.valueOf(temp);
                result.add(s);
                foo(s, i + 1, endIndex, result);
                break;
            }
            if ((int) s.charAt(i) >= 65 && (int) s.charAt(i) <= 90) {
                foo(s, i + 1, endIndex, result);
                char[] temp = s.toCharArray();
                temp[i] = Character.toLowerCase(temp[i]);
                s = String.valueOf(temp);
                result.add(s);
                foo(s, i + 1, endIndex, result);
                break;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(letterCasePermutation("C"));
        System.out.println((int) 'A');
        System.out.println((int) 'Z');
    }

    /**
     * 思路：这题只要递归就好了，有个坑是需要处理一下可能传入的是大写，递归主要就是一个处理之前的对象，
     * 一个处理之后的对象两个。
     */
}
