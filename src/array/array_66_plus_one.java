package array;
/*
Given a non-empty array of digits representing a non-negative integer, plus one to the integer.

The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.

You may assume the integer does not contain any leading zero, except the number 0 itself.

Example 1:

Input: [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Example 2:

Input: [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.
 */
class array_66_plus_one {
    public static int[] plusOne(int[] digits) {
        int length = digits.length;
        boolean update = true;
        int index = length - 1;
        while (update){
            if (index >= 0){
                int t = digits[index] + 1;
                if (t == 10){
                    digits[index] = 0;
                }else {
                    update = false;
                    digits[index] = t;
                }
                index --;
            }else {
                int[] temp = new int[length+1];
                temp[0] = 1;
                for (int i = 1; i < temp.length; i ++){
                    temp[i] = 0;
                }
                return temp;
            }
        }
        return digits;
    }
    /**
     * 思路：该题主要涉及是处理一下边界问题，解题思路比较容易
     * beat 100%
     */
}
