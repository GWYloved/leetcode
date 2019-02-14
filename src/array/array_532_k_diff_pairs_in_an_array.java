package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
Given an array of integers and an integer k, you need to find the number of unique k-diff pairs in the array. Here a k-diff pair is defined as an integer pair (i, j), where i and j are both numbers in the array and their absolute difference is k.

Example 1:
Input: [3, 1, 4, 1, 5], k = 2
Output: 2
Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
Although we have two 1s in the input, we should only return the number of unique pairs.
Example 2:
Input:[1, 2, 3, 4, 5], k = 1
Output: 4
Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) and (4, 5).
Example 3:
Input: [1, 3, 1, 5, 4], k = 0
Output: 1
Explanation: There is one 0-diff pair in the array, (1, 1).
Note:
The pairs (i, j) and (j, i) count as the same pair.
The length of the array won't exceed 10,000.
All the integers in the given input belong to the range: [-1e7, 1e7].
 */
public class array_532_k_diff_pairs_in_an_array {
    private static int findPairs(int[] nums, int k) {
        if (nums.length < 1 || k < 0){
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        int count = 0;
        for (Map.Entry<Integer, Integer> entry:map.entrySet()){
            if (k == 0){
                if (entry.getValue() >= 2){
                    count ++;
                }
            }else {
                if (map.containsKey(entry.getKey()+k)){
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 思路：这题通过使用hashmap来记录比较方便，主要问题在于索引对象的问题，hashmap保障索引速度不会低于nlogn，这点上不需要我们在精细了。
     * 时间复杂度是n*O(nlogn)+n*O(nlogn) = O(n^2logn)
     * 不过这题仍有最佳实践
     */
    private static int findPairs2(int[] nums, int k) {
        if (k < 0 || nums.length <= 1) {
            return 0;
        }

        Arrays.sort(nums);
        int count = 0;
        int left = 0;
        int right = 1;

        while (right < nums.length) {
            int firNum = nums[left];
            int secNum = nums[right];
            // If less than k, increase the right index
            if (secNum - firNum < k) {
                right++;
            }
            // If larger than k, increase the left index
            else if (secNum - firNum > k) {
                left++;
            }
            // If equal, move left and right to next different number
            else {
                count++;
                while (left < nums.length && nums[left] == firNum) {
                    left++;
                }
                while (right < nums.length && nums[right] == secNum) {
                    right++;
                }

            }
            //left and right should not be the same number
            if (right == left) {
                right++;
            }
        }
        return count;
    }

    /**
     * 最佳实践的思路：
     * 首先，排序
     * 如果出现B>A, B-A < K的情况，这样在[A,B]中的所有数都不满足条件，需要将B右移扩大区间
     * 如果出现B>A, B-A > K的情况，这样在[A,B]中可能存在满足当A右移的情况下，B-A == K的情况
     * 如果出现B>A, B-A == K的情况，这样就代表找到这个数，而需要考虑一下是否出现重复的，这时候需要将AB指针同时后移到不同的数停止
     * 由于以上涉及到A指针后移，所以需要判断AB指针重合的问题
     */
}
