package math;

import utils.ListUtils;

import java.util.ArrayList;
import java.util.List;

/*
Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

Example 1:

Input: 121
Output: true
Example 2:

Input: -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
Example 3:

Input: 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
Follow up:

Coud you solve it without converting the integer to a string?
 */
public class math_9_palindrome_Number {
    public static boolean isPalindrome(int x) {
        if (x < 0){
            return false;
        }
        if (x < 10){
            return true;
        }
        int[] container = new int[10];
        int flag = 0;
        while (x > 0){
            int temp = x % 10;
            container[flag] = temp;
            flag ++;
            x = x /10;
        }
        flag --;
        int start = 0;
        int end = flag;
        while (start <= end){
            if (container[start] != container[end]){
                return false;
            }
            start ++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(-121));
        System.out.println(isPalindrome(10));
        System.out.println(isPalindrome(111));
        System.out.println(isPalindrome(0));
    }
    /**
     * 思路：很简单的easy，刚开始用arraylist来存，之后想了一下int最多10位，因此用int数组来存，int数组来存就可以beat100%了
     * 这题直接写就很快，刚开始想可否不借用额外空间，后来发现与其多想不如多些
     */
}
