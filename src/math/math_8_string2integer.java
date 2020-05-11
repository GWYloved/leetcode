package math;

import java.io.Serializable;

/*
Implement atoi which converts a string to an integer.

The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

If no valid conversion could be performed, a zero value is returned.

Note:

Only the space character ' ' is considered as whitespace character.
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. If the numerical value is out of the range of representable values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.
Example 1:

Input: "42"
Output: 42
Example 2:

Input: "   -42"
Output: -42
Explanation: The first non-whitespace character is '-', which is the minus sign.
             Then take as many numerical digits as possible, which gets 42.
Example 3:

Input: "4193 with words"
Output: 4193
Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.
Example 4:

Input: "words and 987"
Output: 0
Explanation: The first non-whitespace character is 'w', which is not a numerical
             digit or a +/- sign. Therefore no valid conversion could be performed.
Example 5:

Input: "-91283472332"
Output: -2147483648
Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.
             Thefore INT_MIN (−231) is returned.
 */
public class math_8_string2integer {
    public static int myAtoi(String str) {
        if (str.length() == 0){
            return 0;
        }
        int firstNumberIndex = -1;
        long container = 0;
        for (int i = 0; i < str.length(); i ++){
            if (isNumber(str.charAt(i))){
                if (firstNumberIndex == -1){
                    firstNumberIndex = i;
                }
                boolean isNegative = firstNumberIndex != 0 && (str.charAt(firstNumberIndex - 1) == '-');
                long temp = container* 10 +(str.charAt(i) - '0');
                //需要判断是否越界
                if (isNegative){
                    if ((temp * -1) <  Integer.MIN_VALUE){
                        return Integer.MIN_VALUE;
                    }
                }else {
                    if (temp > Integer.MAX_VALUE){
                        return Integer.MAX_VALUE;
                    }
                }
                container = temp;
            }else {
                if (firstNumberIndex != -1){
                    break;
                }else if (str.charAt(i) != ' ' && str.charAt(i) != '-' && str.charAt(i) != '+'){
                    return 0;
                }else if (i > 0 && (str.charAt(i) == ' ' || str.charAt(i) == '-' || str.charAt(i) == '+')){
                    if (str.charAt(i - 1) != ' '){
                        return 0;
                    }
                }
            }
        }
        boolean isNegative = firstNumberIndex > 0 && str.charAt(firstNumberIndex - 1) == '-';
        return isNegative?  -(int)container:(int)container;
    }

    public static boolean isNumber(char t){
        return t <= '9' && t >= '0';
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("-32"));
        System.out.println(myAtoi("-33333333"));
        System.out.println(myAtoi("   -42"));
        System.out.println(myAtoi("4193 with words"));
        System.out.println(myAtoi("words and 987"));
        System.out.println(myAtoi(""));
        System.out.println(myAtoi("+"));
    }

    /**
     * 思路：这题主要是要心静进行处理，从什么符号开始进行处理等等
     * 比较难的是如何开始记录这个起始点
     * 但是做这类题目还是需要心静
     */
}
