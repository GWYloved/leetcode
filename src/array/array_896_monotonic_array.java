package array;

/*
An array is monotonic if it is either monotone increasing or monotone decreasing.

An array A is monotone increasing if for all i <= j, A[i] <= A[j].  An array A is monotone decreasing if for all i <= j, A[i] >= A[j].

Return true if and only if the given array A is monotonic.



Example 1:

Input: [1,2,2,3]
Output: true
Example 2:

Input: [6,5,4,4]
Output: true
Example 3:

Input: [1,3,2]
Output: false
Example 4:

Input: [1,2,4,5]
Output: true
Example 5:

Input: [1,1,1]
Output: true


Note:

1 <= A.length <= 50000
-100000 <= A[i] <= 100000

 */
public class array_896_monotonic_array {
    public static boolean isMonotonic(int[] A) {
        int t = 0;
        int last = A[0];
        for (int i = 1; i < A.length; i++) {
            if (t == 0) {
                if (A[i] > last) {
                    t = 1;
                } else if (A[i] < last) {
                    t = -1;
                }
            } else if (t == -1) {
                //decrease
                if (A[i] > last) {
                    return false;
                }
            } else {
                //increase
                if (A[i] < last) {
                    return false;
                }
            }
            last = A[i];
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isMonotonic(new int[]{1, 2, 2, 3}));
        System.out.println(isMonotonic(new int[]{6, 5, 4, 4}));
        System.out.println(isMonotonic(new int[]{1, 3, 2}));
        System.out.println(isMonotonic(new int[]{1, 2, 4, 5}));
        System.out.println(isMonotonic(new int[]{1, 1, 1}));

    }

    /**
     * 思路：比较简单的题目
     */
}
