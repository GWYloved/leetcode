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
        int left = 1, right = x;
        while (true){
            int mid = (left + right)>>>1;
            if (mid> x/mid){
                right = mid -1;
            }else {
                if (mid + 1 > x/(mid + 1)){
                    return mid;
                }
                left = mid + 1;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(2147395599));
    }
    /**
     * 思路：这题思路其实需要理解一下，
     * 如果找到一个数，它的平方比目标数小，它+1的和的平方比目标数大，那么这个数就是目标数
     * 另外有个不注意会漏掉的地方，就是如果用X和mid*mid比，会溢出，使用x/mid和mid比才可以
     * ps：二分法的中间值应该使用(left+right)>>>1
     */
}
