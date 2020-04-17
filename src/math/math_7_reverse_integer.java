package math;
/*
Given a 32-bit signed integer, reverse digits of an integer.

Example 1:

Input: 123
Output: 321
Example 2:

Input: -123
Output: -321
Example 3:

Input: 120
Output: 21
Note:
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1].
For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 */
public class math_7_reverse_integer {
    public static int reverse(int x) {
        long temp = 0;
        while (x != 0){
            int div = x % 10;
            x -= div;
            x /= 10;
            temp *= 10;
            temp += div;
            if (temp > Integer.MAX_VALUE || temp < Integer.MIN_VALUE){
                return 0;
            }
        }
        return (int)temp;
    }

    public static void main(String[] args) {
//        System.out.println(reverse(123));
//        System.out.println(reverse(-123));
//        System.out.println(reverse(120));
        System.out.println(reverse(1534236469));
        System.out.println(reverse(-2147483412));
    }
    /**
     * 这题蛋疼的是边界条件的处理，我想了很久，决定先用long来接数据，然后判断一下，差不多就传出去
     * 的确行啊，beat100%，标准答案也是用long来接的
     */

}
