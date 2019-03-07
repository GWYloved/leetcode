package array;
/*
Given an array A of integers, return true if and only if it is a valid mountain array.

Recall that A is a mountain array if and only if:

A.length >= 3
There exists some i with 0 < i < A.length - 1 such that:
A[0] < A[1] < ... A[i-1] < A[i]
A[i] > A[i+1] > ... > A[B.length - 1]


Example 1:

Input: [2,1]
Output: false
Example 2:

Input: [3,5,5]
Output: false
Example 3:

Input: [0,3,2,1]
Output: true
Note:

0 <= A.length <= 10000
0 <= A[i] <= 10000
 */
public class array_941_Valid_Mountain_Array {
    public static boolean validMountainArray(int[] A) {
        if (A.length < 3){
            return false;
        }
        int flag = 0;
        int last = A[0];
        for (int i = 1; i < A.length; i ++){
            if (flag == 0){
                if (last >= A[i]){
                    return false;
                }else {
                    flag = 1;
                }
            }else if (flag == 1){
                if (last > A[i]){
                    flag = -1;
                }else if (last == A[i]){
                    return false;
                }
            }else{
                if (last <= A[i]){
                    return false;
                }
            }
            last = A[i];
        }
        return flag != 1;
    }

    public static void main(String[] args) {
        System.out.println(validMountainArray(new int[]{2,1}));
        System.out.println(validMountainArray(new int[]{3,5,5}));
        System.out.println(validMountainArray(new int[]{0,3,2,1}));
        System.out.println(validMountainArray(new int[]{0,3,2,2,1}));
        System.out.println(validMountainArray(new int[]{0,0,3,2,1}));
        System.out.println(validMountainArray(new int[]{1,2,3,4,5,4,3,2,1}));
        System.out.println(validMountainArray(new int[]{1,2,3,4,5}));
    }

    /**
     * 思路：最后要注意可能flag 一直是1这一个情况的判断，另外返回false的时候需要注意到全部条件
     */
}
