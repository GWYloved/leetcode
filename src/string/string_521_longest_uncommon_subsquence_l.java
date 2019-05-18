package string;
/*
Given a group of two strings, you need to find the longest uncommon subsequence of this group of two strings. The longest uncommon subsequence is defined as the longest subsequence of one of these strings and this subsequence should not be any subsequence of the other strings.

A subsequence is a sequence that can be derived from one sequence by deleting some characters without changing the order of the remaining elements. Trivially, any string is a subsequence of itself and an empty string is a subsequence of any string.

The input will be two strings, and the output needs to be the length of the longest uncommon subsequence. If the longest uncommon subsequence doesn't exist, return -1.

Example 1:
Input: "aba", "cdc"
Output: 3
Explanation: The longest uncommon subsequence is "aba" (or "cdc"),
because "aba" is a subsequence of "aba",
but not a subsequence of any other strings in the group of two strings.
Note:

Both strings' lengths will not exceed 100.
Only letters from a ~ z will appear in input strings.

 */
public class string_521_longest_uncommon_subsquence_l {
    public int findLUSlength(String a, String b) {
        if (a.length() == b.length()){
            if (a.equals(b)){
                return -1;
            }else {
                return a.length();
            }
        }else {
            return Math.max(a.length(), b.length());
        }
        /**
         * 思路：题目很长，但是实际上是一题吓人但解法超级简单的题目。亏我思考那么久
         */
    }
}
