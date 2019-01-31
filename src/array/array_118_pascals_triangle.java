package array;

import java.util.ArrayList;
import java.util.List;

/*
Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.


In Pascal's triangle, each number is the sum of the two numbers directly above it.

Example:

Input: 5
Output:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
 */
public class array_118_pascals_triangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        temp.add(1);
        for (int i = 1; i <= numRows; i++) {
            List<Integer> tempList = new ArrayList<>();
            if (temp.size() < 2) {
                for (int j = 1; j <= i; j++) {
                    tempList.add(1);
                }
                result.add(tempList);
                temp = new ArrayList<>(tempList);
            } else {
                tempList.add(1);
                for (int j = 0; j < temp.size() - 1; j++) {
                    tempList.add(temp.get(j) + temp.get(j + 1));
                }
                tempList.add(1);
                result.add(tempList);
                temp = new ArrayList<>(tempList);
            }
        }
        return result;
    }

    /**
     * 思路：这题的思路还是比较简便的，如果使用一个temp数组做存储的话，其实O（N）复杂度即可解决问题
     */
}
