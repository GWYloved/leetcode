package array;

/*
Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.

Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.

Example 1:
Input: [1, 2, 2, 3, 1]
Output: 2
Explanation:
The input array has a degree of 2 because both elements 1 and 2 appear twice.
Of the subarrays that have the same degree:
[1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
The shortest length is 2. So return 2.
Example 2:
Input: [1,2,2,3,1,4,2]
Output: 6
Note:

nums.length will be between 1 and 50,000.
nums[i] will be an integer between 0 and 49,999.
 */
class array_697_degree_of_an_array {
    public static int findShortestSubArray(int[] nums) {
        int[] tempCount = new int[50000];
        int[] tempStartPosition = new int[50000];
        int max = 0;
        int distance = 0;
        for (int i = 0; i < nums.length; i++) {
            int count = tempCount[nums[i]];
            if (count == 0) {
                tempStartPosition[nums[i]] = i;
            }
            tempCount[nums[i]]++;
            if (max < tempCount[nums[i]]) {
                max = tempCount[nums[i]];
                distance = i - tempStartPosition[nums[i]] + 1;
            } else if (max == tempCount[nums[i]]) {
                distance = Math.min(distance, i - tempStartPosition[nums[i]] + 1);
            }
        }
        return distance;
    }

    public static void main(String[] args) {
        System.out.println(findShortestSubArray(new int[]{1, 3, 3, 3, 1, 3, 7, 7, 7, 7, 7, 7, 7, 7}));
    }

    /**
     * 解题思路：这题用countsort思路很简单，有个注意点，申请int[50000][2]事实上是执行了50000次malloc操作，
     * 其功能和申请2个50000空间的数组一样，而后者只有2次malloc操作，这个是一个细节。
     */
}
