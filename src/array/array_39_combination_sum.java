package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/*
Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

The same repeated number may be chosen from candidates unlimited number of times.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [2,3,6,7], target = 7,
A solution set is:
[
  [7],
  [2,2,3]
]
Example 2:

Input: candidates = [2,3,5], target = 8,
A solution set is:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]
 */
class array_39_combination_sum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        List<Integer> tempList = new ArrayList<>();
        fun(result,tempList, candidates,target,0);
        return result;
    }
    private static void fun(List<List<Integer>> result,List<Integer> temp, int[] candidates, int remain, int start){
        for (int i = start; i < candidates.length; i ++){
            int tempRemain = remain - candidates[i];
            List<Integer> list = new ArrayList<>(temp);
            if (tempRemain > 0){
                list.add(candidates[i]);
                fun(result, list, candidates, tempRemain, i);
            }else if (tempRemain == 0){
                list.add(candidates[i]);
                result.add(list);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2,3,5},8));
    }

    /**
     * 解题思路：每次都可以以自身为单位往后回溯
     * 比较坑的是需要注意每次回溯的时候需要新建一个容器进行数据拷贝
     */
}
