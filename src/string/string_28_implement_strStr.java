package string;
/*
Implement strStr().

Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Example 1:

Input: haystack = "hello", needle = "ll"
Output: 2
Example 2:

Input: haystack = "aaaaa", needle = "bba"
Output: -1
Clarification:

What should we return when needle is an empty string? This is a great question to ask during an interview.

For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
 */
public class string_28_implement_strStr {
    public static int strStr(String haystack, String needle) {
        if (haystack.length() < 1 && needle.length() > 0 ||needle.length() > haystack.length()){
            return -1;
        }
        if (haystack.length() > 0 && needle.length() < 1 || haystack.length() == 0 && needle.length() == 0){
            return 0;
        }
        for (int i = 0; i < haystack.length(); i ++){
            if (haystack.charAt(i) == needle.charAt(0) && haystack.length() - i >= needle.length()){
                if (haystack.substring(i, i+needle.length()).equals(needle)){
                    return i;
                }
            }
            if (haystack.length() - i < needle.length()){
                return -1;
            }
        }
        return -1;
    }
    private static boolean isEqual(char[] a, char[]b){
        for (int i = 0; i < a.length; i ++){
            if (a[i] != b[i]){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String t = "hello";
        String needle = "lll";
        System.out.println(t.indexOf(needle));
        System.out.println(strStr("hello","ll"));
        System.out.println(strStr("aaaaa","bba"));
        System.out.println(strStr("hello",""));
        System.out.println(strStr("hello","o"));
        System.out.println(strStr("hello","l"));
        System.out.println(strStr("hello","el"));
        System.out.println(strStr("hello","hellow"));
        System.out.println(strStr("hello","hello"));
        System.out.println(strStr("",""));
        System.out.println(strStr("mississippi",
                "issip"));
        String s = "abcd";
        System.out.println(s.substring(1,2));
    }

    /**
     * 思路：这题单纯比较字符串即可
     */
}
