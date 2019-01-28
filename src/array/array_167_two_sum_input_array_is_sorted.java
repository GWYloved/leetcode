package array;

/*
Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.

Note:

Your returned answers (both index1 and index2) are not zero-based.
You may assume that each input would have exactly one solution and you may not use the same element twice.
Example:

Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
 */
class array_167_two_sum_input_array_is_sorted {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers.length <= 1){
            return null;
        }
        int start = 0;
        int end = numbers.length -1;
        int sum = numbers[start] + numbers[end];
        while (sum != target){
            if (sum < target){
                start ++;
            }else {
                end --;
            }
            sum = numbers[start] + numbers[end];
        }
        return new int[]{start+1, end+1};
    }

    /**
     * 思路：不重复了
     */
}
