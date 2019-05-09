package string;
/*
Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.

Each letter in the magazine string can only be used once in your ransom note.

Note:
You may assume that both strings contain only lowercase letters.

canConstruct("a", "b") -> false
canConstruct("aa", "ab") -> false
canConstruct("aa", "aab") -> true
 */
public class string_383_ransom_note {
    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] temp = new int['z'-'a'+1];
        for (int i = 0; i < magazine.length(); i ++){
            temp[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0;i <ransomNote.length(); i++){
            if (--temp[ransomNote.charAt(i) - 'a'] < 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canConstruct("a","b"));
        System.out.println(canConstruct("aa","ab"));
        System.out.println(canConstruct("aa","aab"));
    }

    /**
     * 思路：这题主要是要用magazine里面的char，拼出ransomNote的内容，而不是单纯的contain关系
     */
}
