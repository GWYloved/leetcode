package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

Example 1:

Input: [3,0,1]
Output: 2
Example 2:

Input: [9,6,4,2,3,5,7,0,1]
Output: 8
 */
public class array_268_missing_number {
    public int missingNumber(int[] nums) {
//        List<Integer> list = new ArrayList<>();
//        for (int i = 0; i <= nums.length; i++){
//            list.add(i);
//        }
//        for (int i : nums){
//            list.remove(Integer.valueOf(i));
//        }
//        return list.get(0);
        if (nums.length < 1) {
            return 0;
        }
        Arrays.sort(nums);
        int temp = nums[0];
        if (1 >= nums.length) {
            return temp == 0 ? 1 : 0;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i != nums[i]) {
                return i;
            }
        }
        return nums[nums.length - 1] + 1;
    }

    /**
     * 思路：这题的问题在于需要线性时间，因此我决定使用两个O(N)来写，不过不是很好,如果排序一下那就很好了，只需要找间隔大的返回就行，不过排序是O(nlogn)不是满足线性时间的要求
     * 有两个更好的方式处理这个问题，第一个是通过和来计算，我们可以计算出如果传入n位，那么原本应该的和是n+1位的和，是0+1+...+N,逐个减去原来的数即可
     */
    public int missingNumber1(int[] nums) {
        int length = nums.length;
        int remain = length * (length + 1) / 2;
        for (int i : nums) {
            remain -= i;
        }
        return remain;
    }

    /**
     * 第二种更好的方式是位处理运算
     */
    public int missingNumber2(int[] nums) {
        int remain = nums.length;
        for (int i = 0; i < nums.length; i++) {
            remain ^= i ^ nums[i];
        }
        return remain;
    }
}
