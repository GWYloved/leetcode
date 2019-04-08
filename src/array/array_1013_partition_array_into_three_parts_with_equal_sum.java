package array;

/*
Given an array A of integers, return true if and only if we can partition the array into three non-empty parts with equal sums.

Formally, we can partition the array if we can find indexes i+1 < j with (A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2] + ... + A[j-1] == A[j] + A[j-1] + ... + A[A.length - 1])



Example 1:

Input: [0,2,1,-6,6,-7,9,1,2,0,1]
Output: true
Explanation: 0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1
Example 2:

Input: [0,2,1,-6,6,7,9,-1,2,0,1]
Output: false
Example 3:

Input: [3,3,6,5,-2,2,5,1,-9,4]
Output: true
Explanation: 3 + 3 = 6 = 5 - 2 + 2 + 5 + 1 - 9 + 4


Note:

3 <= A.length <= 50000
-10000 <= A[i] <= 10000
 */
public class array_1013_partition_array_into_three_parts_with_equal_sum {
    public static boolean canThreePartsEqualSum_1(int[] A) {
        int sum1 = 0;
        int sum2 = A[0];
        int sumAll = 0;
        for (int i : A){
            sumAll += i;
        }
        int flag1 = 0;
        int flag2 = 0;
        while (flag1 < A.length - 1){
            sum1 += A[flag1];
            sum2 = 0;
            flag2 = flag1+1;
            while (flag2 < A.length){
                sum2 += A[flag2];
                if (sumAll - sum1 - sum2 == sum2 && sum2 == sum1){
                    return true;
                }
                flag2++;
            }
            flag1 ++;
        }
        return false;
    }
    public static boolean canThreePartsEqualSum(int[] A) {
        int length = A.length;
        int[] temp = new int[length];
        int sum = 0;
        for (int i = 0; i < A.length; i++){
            if (i == 0){
                temp[i] = A[i];
            }else {
                temp[i] = temp[i-1];
                temp[i] += A[i];
            }
            sum += A[i];
        }
        int flag1 = 0;
        for (int i = 0; i < temp.length - 1; i ++){
            if (temp[i] * 3 == sum ){
                flag1 = 1;
            }
            if (flag1 == 1 && temp[i] /2 * 3 == sum){
                return true;
            }
        }
        return false;

    }

    public static void main(String[] args) {
        System.out.println(canThreePartsEqualSum(new int[]{0,2,1,-6,6,-7,9,1,2,0,1}));
        System.out.println(canThreePartsEqualSum(new int[]{0,2,1,-6,6,7,9,-1,2,0,1}));
        System.out.println(canThreePartsEqualSum(new int[]{3,3,6,5,-2,2,5,1,-9,4}));
        System.out.println(canThreePartsEqualSum(new int[]{0,0,0}));
        System.out.println(canThreePartsEqualSum(new int[]{1,0,1}));
        System.out.println(canThreePartsEqualSum(new int[]{12,-4,16,-5,9,-3,3,8,0}));
        System.out.println(canThreePartsEqualSum(new int[]{6,1,1,13,-1,0,-10,20}));
        System.out.println(canThreePartsEqualSum(new int[]{14,6,-10,2,18,-7,-4,11}));
    }

    /**
     * 解题思路，这种题目用空间计算每个位置代表其之前所有数的和比较容易
     */
}
