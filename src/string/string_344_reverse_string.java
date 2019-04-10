package string;

/*
Write a function that takes a string as input and returns the string reversed.

Example 1:

Input: "hello"
Output: "olleh"
Example 2:

Input: "A man, a plan, a canal: Panama"
Output: "amanaP :lanac a ,nalp a ,nam A"
 */
class string_344_reverse_string {
    public String reverseString(String s) {
        if (s == null || s.length() < 1) {
            return s;
        }
        char[] temp = new char[s.length()];
        int start = 0, end = s.length() - 1;
        while (start <= end) {
            temp[start] = s.charAt(end);
            temp[end] = s.charAt(start);
            start++;
            end--;
        }
        return String.valueOf(temp);
    }
    /**
     * 微软面试的时候第一题，我就是按上面这样写的，没啥大问题
     */
}
