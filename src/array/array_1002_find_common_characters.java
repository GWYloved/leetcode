package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/*
Given an array A of strings made only from lowercase letters, return a list of all characters that show up in all strings within the list (including duplicates).  For example, if a character occurs 3 times in all strings but not 4 times, you need to include that character three times in the final answer.

You may return the answer in any order.



Example 1:

Input: ["bella","label","roller"]
Output: ["e","l","l"]
Example 2:

Input: ["cool","lock","cook"]
Output: ["c","o"]


Note:

1 <= A.length <= 100
1 <= A[i].length <= 100
A[i][j] is a lowercase letter
 */
public class array_1002_find_common_characters {
    public List<String> commonChars(String[] A) {
        List<String> ans = new ArrayList<>();
        int[] count = new int[26];
        Arrays.fill(count, Integer.MAX_VALUE);
        for (String str : A){
            int[] cnt = new int[26];
            for (char c : str.toCharArray()){
                ++cnt[c - 'a'];
            }
            for (int i = 0 ; i < 26; i ++){
                count[i] = Math.min(cnt[i],count[i]);
            }
        }
        for (int i = 0; i < 26; i ++){
            while (count[i] -- > 0){
                ans.add(String.valueOf((char)(i+'a')));
            }
        }
        return ans;
    }

    /**
     * 思路：关于处理字符串的问题，需要仔细处理处理
     */
}
