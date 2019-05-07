package string;
/*
Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

Example:

Input: "Hello World"
Output: 5

 */
public class string_58_length_of_last_word {
    public static int lengthOfLastWord(String s) {
        int count = 0;
        int spaceCount = 0;
        for (int i = s.length() - 1; i >= 0 ; i--){
            if (s.charAt(i) != ' '){
                count ++;
                continue;
            }else if (count != 0){
                return count;
            }
            spaceCount ++;
        }
        return count + spaceCount == s.length()? count : 0;
    }

    public static void main(String[] args) {
//        System.out.println(lengthOfLastWord("you are a pig"));
//        System.out.println(lengthOfLastWord(""));
//        System.out.println(lengthOfLastWord(" "));
//        System.out.println(lengthOfLastWord(" a "));
        System.out.println(lengthOfLastWord("a"));
        System.out.println(lengthOfLastWord("gggg"));
        System.out.println(lengthOfLastWord("a "));
    }
    /**
     * 思路：这种题目虽然简单，但是处处是陷阱
     */
}
