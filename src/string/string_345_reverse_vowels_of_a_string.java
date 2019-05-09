package string;
/*
Write a function that takes a string as input and reverse only the vowels of a string.

Example 1:

Input: "hello"
Output: "holle"
Example 2:

Input: "leetcode"
Output: "leotcede"
Note:
The vowels does not include the letter "y".


 */
public class string_345_reverse_vowels_of_a_string {
    public static String reverseVowels(String s) {
        char[] t = s.toCharArray();
        int i = 0;
        int j = s.length() -1;
        while (i < s.length() - 1 && j > 0 && i <= j){
            if (i == j){
                break;
            }
            if (!isVowels(t[i])){
                i ++;
                continue;
            }
            if (!isVowels(t[j])){
                j--;
                continue;
            }
            char temp = t[i];
            t[i] = t[j];
            t[j] = temp;
            i++;
            j--;
        }
        return String.valueOf(t);
    }
    private static boolean isVowels(char a){
        return a == 'a' || a == 'e' || a == 'o' || a == 'i' || a =='u'||a == 'A' || a== 'E' || a == 'I' || a == 'O' || a == 'U';
    }

    public static void main(String[] args) {
        System.out.println(reverseVowels("hello"));
        System.out.println(reverseVowels("leetcode"));
    }

    /**
     * 莫名其妙以为都是小写，结果有些是大写，双指针替换实在是太方便了
     */

}
