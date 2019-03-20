package array;

import java.util.Arrays;

/*
iven an array of integers A sorted in non-decreasing order, return an array of the squares of each number, also in sorted non-decreasing order.



Example 1:

Input: [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Example 2:

Input: [-7,-3,2,3,11]
Output: [4,9,9,49,121]


Note:

1 <= A.length <= 10000
-10000 <= A[i] <= 10000
A is sorted in non-decreasing order.
 */
public class array_977_squares_of_a_sorted_array {
    public int[] sortedSquares1(int[] A) {
        int[] temp = new int[A.length];
        for (int i = 0; i < A.length; i ++){
            temp[i] = A[i] * A[i];
        }
        Arrays.sort(temp);
        return temp;
    }

    public static int[] sortedSquares(int[] A) {
        int divider = -1;
        for (int i = 0; i < A.length; i ++){
            if (A[i] >= 0){
                divider = i;
                break;
            }
        }
        int[] temp = new int[A.length];
        if (divider < 0){
            for (int i = 0; i < A.length; i ++){
                temp[A.length - 1 - i] = A[i]*A[i];
            }
        }else if (divider == 0){
            for (int i = 0; i < A.length; i ++){
                temp[i] = A[i] * A[i];
            }
        }else {
            int left = divider - 1, right = divider;
            int flag = 0;
            while (left >= 0 && right <= A.length - 1){
                int tempLeft = A[left] * A[left];
                int tempRight = A[right] * A[right];
                if (tempLeft <= tempRight){
                    temp[flag ++ ] = tempLeft;
                    left --;
                }else {
                    temp[flag ++] = tempRight;
                    right ++;
                }
            }
            if (left >= 0){
                while (left > 0){
                    temp[flag ++] = A[left] * A[left];
                    left --;
                }
                temp[flag++] = A[left] * A[left];
            }

            if (right <= A.length - 1){
                while (right < A.length - 1){
                    temp[flag ++] = A[right] * A[right];
                    right ++;
                }
                temp[flag++] = A[right] * A[right];
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortedSquares(new int[]{-5,-4,-3,-2,-1})));
        System.out.println(Arrays.toString(sortedSquares(new int[]{-5,-4,-3,-2,-1,0})));
        System.out.println(Arrays.toString(sortedSquares(new int[]{-4,-1,0,3,10})));
        System.out.println(Arrays.toString(sortedSquares(new int[]{-7,-3,2,3,11})));
        System.out.println(Arrays.toString(sortedSquares(new int[]{-3,-2,-1,0,1,2})));
        System.out.println(Arrays.toString(sortedSquares(new int[]{-1,0,1,2,3,4})));
        System.out.println(Arrays.toString(sortedSquares(new int[]{1,2,3,4,5,6})));
        System.out.println(Arrays.toString(sortedSquares(new int[]{0,1,2,3,4,5})));
    }

    /**
     * 思路：一是排序，比较简单，O(nlogn),另一个是双指针，前提是这个是有序的数组，这样双指针能达到O(n)的效率
     */
}
