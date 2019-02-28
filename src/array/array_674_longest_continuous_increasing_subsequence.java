package array;

/*
Given an unsorted array of integers, find the length of longest continuous increasing subsequence (subarray).

Example 1:
Input: [1,3,5,4,7]
Output: 3
Explanation: The longest continuous increasing subsequence is [1,3,5], its length is 3.
Even though [1,3,5,7] is also an increasing subsequence, it's not a continuous one where 5 and 7 are separated by 4.
Example 2:
Input: [2,2,2,2,2]
Output: 1
Explanation: The longest continuous increasing subsequence is [2], its length is 1.
Note: Length of the array will not exceed 10,000.
 */
class array_674_longest_continuous_increasing_subsequence {
    public int findLengthOfLCIS(int[] nums) {
        int max = 1;
        int temp = 1;
        if (nums.length < 1) {
            return 0;
        }
        int last = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > last) {
                temp++;
            } else {
                max = Math.max(max, temp);
                temp = 1;
            }
            last = nums[i];
        }
        max = Math.max(max, temp);
        return max;
    }
    /**
     * 思路：这题很简单，但是一次RE,一次WA，RE是因为没写判断length < 1，WA是因为没有在最后的时候执行一次max操作
     * 以后要注意一下这个
     */
}
