package array;

/*
In a given integer array nums, there is always exactly one largest element.

Find whether the largest element in the array is at least twice as much as every other number in the array.

If it is, return the index of the largest element, otherwise return -1.

Example 1:

Input: nums = [3, 6, 1, 0]
Output: 1
Explanation: 6 is the largest integer, and for every other number in the array x,
6 is more than twice as big as x.  The index of value 6 is 1, so we return 1.


Example 2:

Input: nums = [1, 2, 3, 4]
Output: -1
Explanation: 4 isn't at least as big as twice the value of 3, so we return -1.


Note:

nums will have a length in the range [1, 50].
Every nums[i] will be an integer in the range [0, 99].
 */
class array_747_largest_number_at_least_twice_of_others {
    public static int dominantIndex(int[] nums) {
        int flagMax = nums[0];
        int flagIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > flagMax) {
                if (nums[i] < 2 * flagMax) {
                    flagIndex = -1;
                } else {
                    flagIndex = i;
                }
                flagMax = nums[i];
            } else if (nums[i] * 2 > flagMax) {
                flagIndex = -1;
            }
        }
        return flagIndex;
    }

    public static void main(String[] args) {
        System.out.println(dominantIndex(new int[]{3, 6, 1, 0}));
        System.out.println(dominantIndex(new int[]{1, 2, 3, 4}));
        System.out.println(dominantIndex(new int[]{0, 0, 3, 2}));
        System.out.println(dominantIndex(new int[]{0, 0, 3, 2, 6}));
        System.out.println(dominantIndex(new int[]{0, 0, 3, 2, 6, 9, 2}));
    }

    /**
     *  这一题使用onepass思想，根据目前值来逐渐确定答案比较容易，刚开始的时候漏了一个条件，
     *  acrL 50% beat 100%
     */
}
