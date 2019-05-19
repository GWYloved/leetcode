package string;
/*
Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

Example 1:
Input: "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"
Note: In the string, each word is separated by single space and there will not be any extra space in the string.


 */
public class string_557_reverse_string_lll {
    public static String reverseWords(String s) {
        char[] t = s.toCharArray();
        int start = 0;
        boolean isUsed = false;
        for (int i = 0 ; i < t.length; i ++){
            if (!isUsed){
                if (t[i] != ' '){
                    start = i;
                    isUsed = true;
                }
                continue;
            }
            if (t[i] == ' ' && i > 0 && t[i - 1] != ' ' || i == s.length() - 1){
                int end = t[i]== ' ' ? i -1 :i == s.length() - 1 ? i : i - 1;
                while (start < (t[i]== ' ' ? i -1 :i == s.length() - 1 ? i : i - 1) && start < end){
                    char tt = t[start];
                    t[start] = t[end];
                    t[end] = tt;
                    start ++;
                    end --;
                }
                isUsed = false;
            }
        }
        return String.valueOf(t);
    }

    public static void main(String[] args) {
//        System.out.println(reverseWords("we have a test"));
//        System.out.println(reverseWords(" we have a test "));
//        System.out.println(reverseWords(" "));
//        System.out.println(reverseWords("we have a test "));
//        System.out.println(reverseWords("  "));
//        System.out.println(reverseWords("we have a test  "));
//        System.out.println(reverseWords("  we have a test  "));
        System.out.println(reverseWords("you like me"));
    }
    /**
     * 思路：这题在微软面试的时候遇到过，当时太年轻没做出来。主要问题是边际判断的问题，需要注意空格和末位
     */
}
