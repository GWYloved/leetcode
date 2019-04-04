package array;

import java.util.ArrayList;
import java.util.List;

/*
Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements of [1, n] inclusive that do not appear in this array.

Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

Example:

Input:
[4,3,2,7,8,2,3,1]

Output:
[5,6]
 */
public class array_448_find_all_numbers_disappeared_in_an_array {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        boolean[] flag = new boolean[nums.length];
        List<Integer> contaienr = new ArrayList<>();
        for (int i = 0; i < flag.length; i++) {
            flag[i] = true;
        }
        for (int i : nums) {
            flag[i] = false;
        }
        for (int i = 0; i < flag.length; i++) {
            if (flag[i]) {
                contaienr.add(i + 1);
            }
        }
        return contaienr;
    }
    /**
     * 思路：这题需要O(N)复杂度。可以考虑使用flag位标记法，把所有的位都标记好为true，当走到这一位的时候，在将其确切的改为false
     * 之后遍历，便可以知道缺少的哪几位
     */
}

