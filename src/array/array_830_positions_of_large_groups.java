package array;

import java.util.ArrayList;
import java.util.List;

/*
In a string S of lowercase letters, these letters form consecutive groups of the same character.

For example, a string like S = "abbxxxxzyy" has the groups "a", "bb", "xxxx", "z" and "yy".

Call a group large if it has 3 or more characters.  We would like the starting and ending positions of every large group.

The final answer should be in lexicographic order.



Example 1:

Input: "abbxxxxzzy"
Output: [[3,6]]
Explanation: "xxxx" is the single large group with starting  3 and ending positions 6.
Example 2:

Input: "abc"
Output: []
Explanation: We have "a","b" and "c" but no large group.
Example 3:

Input: "abcdddeeeeaabbbcd"
Output: [[3,5],[6,9],[12,14]]


Note:  1 <= S.length <= 1000
 */
class array_830_positions_of_large_groups {
    public static List<List<Integer>> largeGroupPositions(String S) {
        char[] container = S.toCharArray();
        char last = container[0];
        int count = 1, flag_startIndex = 0;
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 1; i < container.length; i++) {
            if (container[i] == last) {
                count++;
                if (count == 2) {
                    flag_startIndex = i - 1;
                }
            } else {
                if (count >= 3) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(flag_startIndex);
                    temp.add(i - 1);
                    result.add(temp);
                }
                count = 1;
            }
            last = container[i];
        }
        if (count >= 3) {
            List<Integer> temp = new ArrayList<>();
            temp.add(flag_startIndex);
            temp.add(container.length - 1);
            result.add(temp);
        }
        return result;
    }

    public static void main(String[] args) {
        largeGroupPositions("aaa");
        largeGroupPositions("abbxxxxzzy");
        largeGroupPositions("abc");
        largeGroupPositions("abcdddeeeeaabbbcd");
    }
    /**
     * 解题思路：这题不多谈了，easy中的easy
     */

}
