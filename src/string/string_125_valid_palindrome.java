package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true
Example 2:

Input: "race a car"
Output: false
 */
public class string_125_valid_palindrome {
    public static boolean isPalindrome(String s) {
        if (s.isEmpty()){
            return true;
        }
        int i = 0;
        int j = s.length() - 1;
        while (i < j && i < s.length()-1 && j > 0){
            if (!isInSize(s.charAt(i))){
                i ++;
                continue;
            }
            if (!isInSize(s.charAt(j))){
                j --;
                continue;
            }
            if (uplower(s.charAt(i))!= uplower(s.charAt(j))){
                return false;
            }
            i ++;
            j --;
        }
        return true;
    }

    private static boolean isInSize(char t){
        return t <= '9' && t >= '0' || t <='z' && t >='a' || t >= 'A' && t <= 'Z';
    }

    private static char uplower(char t){
        if (t >= 'A' && t <= 'Z'){
            return (char) (t - 'A' + 'a');
        }
        return t;
    }


    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome(" "));
        System.out.println(isPalindrome("race a car"));
    }

    /**
     * 能用一个循环，千万不要用两个循环
     */
}
