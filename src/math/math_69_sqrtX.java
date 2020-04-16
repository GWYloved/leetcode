package math;
/*
Implement int sqrt(int x).

Compute and return the square root of x, where x is guaranteed to be a non-negative integer.

Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.

Example 1:

Input: 4
Output: 2
Example 2:

Input: 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since
             the decimal part is truncated, 2 is returned.
 */
public class math_69_sqrtX {
    public static int mySqrt(int x) {
        if (x == 0){
            return 0;
        }
        if (x <= 2){
            return 1;
        }
        int start = 0;
        int end = x;
        int maxDiff = Integer.MAX_VALUE;
        int temp = x;
        while (start < end){
            int mid = (end + start)>>>1;
            int t = x - mid * mid;
            if (t < 0){
                end = mid - 1;
            }else {
                if (t < maxDiff){
                    maxDiff = t;
                    temp = mid;
                    start = mid + 1;
                }else {
                    end = mid - 1;
                }
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(8));
        System.out.println(mySqrt(4));
    }
}
