package binary_search;

/*
Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.

Return the quotient after dividing dividend by divisor.

The integer division should truncate toward zero.

Example 1:

Input: dividend = 10, divisor = 3
Output: 3
Example 2:

Input: dividend = 7, divisor = -3
Output: -2
Note:

Both dividend and divisor will be 32-bit signed integers.
The divisor will never be 0.
Assume we are dealing with an environment which could only store integers
within the 32-bit signed integer range: [−231,  231 − 1].
For the purpose of this problem, assume that your function returns 231 − 1 when the division result overflows.
 */
class bs_29_divide_two_integers {
    public static int divide(int dividend, int divisor) {
        boolean isDsorNeg = false;
        boolean isDiviNeg = false;
        boolean isAll = false;
        if (Math.abs(divisor) == 1) {
            if (divisor == 1) {
                return dividend;
            } else {
                if (dividend == Integer.MIN_VALUE) {
                    return Integer.MAX_VALUE;
                } else {
                    return -dividend;
                }
            }
        }
        if (dividend < 0 && divisor < 0) {
            isAll = true;
        } else if (divisor < 0) {
            isDsorNeg = true;
            divisor = -divisor;
        } else if (dividend < 0) {
            isDiviNeg = true;
            divisor = -divisor;
        }

        if (dividend < divisor && !isAll) {
            return 0;
        } else if (dividend > divisor && isAll) {
            return 0;
        }

        int temp = 1, high = dividend;
        if (!isAll) {
            while (high > divisor) {
                high = high >> 1;
                temp += temp;
            }
        } else {
            while (high < divisor) {
                high = high >> 1;
                temp += temp;
            }
        }
        temp--;
        return isDsorNeg || isDiviNeg ? -temp : temp;
    }

    public static void main(String[] args) {
        System.out.println(divide(-1
                , 1));
    }
    /**
     * 思路：这题没啥大意思，注意一点，int为-2147483648时，需要转换为long
     */
}
