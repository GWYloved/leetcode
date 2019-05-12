package string;
/*
Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together. You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.



Example 1:

Input: "abab"
Output: True
Explanation: It's the substring "ab" twice.
Example 2:

Input: "aba"
Output: False
Example 3:

Input: "abcabcabcabc"
Output: True
Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
 */
public class string_459_repeated_substring_pattern {
    public static boolean repeatedSubstringPattern(String s) {
        if (s.length() <= 1){
            return false;
        }
        int flagA = 0;
        int div = 1;
        if (s.length() == 2){
            return s.charAt(0) == s.charAt(1);
        }
        while (flagA < s.length() && div < s.length() -1 && flagA + div < s.length()){
            if (s.charAt(flagA) == s.charAt(flagA + div)){
                flagA ++;
            }else {
                div ++;
                flagA = 0;
            }
        }
        return div != s.length() - 1 && s.length() % div == 0;
    }

    public static void main(String[] args) {
        System.out.println(repeatedSubstringPattern("abab"));
        System.out.println(repeatedSubstringPattern("aba"));
        System.out.println(repeatedSubstringPattern("abcabcabcabc"));
        System.out.println(repeatedSubstringPattern("a"));
        System.out.println(repeatedSubstringPattern("aa"));
    }
    /**
     * 解体思路：我的想法是算出一个间隔，确定重复的最大长度，这个解法复杂度其实很高
     */

    public static boolean repeatedSubstringPattern1(String s) {
        int mid = s.length() / 2;
        char lastchar = s.charAt(s.length() - 1);
        while (mid > 0) {
            if (s.length() % mid == 0) {
                String pattern = s.substring(0, mid);
                boolean equal = true;
                for (int i = mid; i < s.length(); i += mid) {
                    if (!pattern.equals(s.substring(i, i + mid))) {
                        equal = false;
                        break;
                    }
                }
                if (equal) return true;
            }
            mid = s.lastIndexOf(lastchar, mid - 2) + 1;
        }
        return false;
    }
    /**
     * 这个解法还是比较直接的，由1/2
     */
}
