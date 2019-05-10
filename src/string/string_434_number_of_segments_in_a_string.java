package string;
/*
Count the number of segments in a string, where a segment is defined to be a contiguous sequence of non-space characters.

Please note that the string does not contain any non-printable characters.

Example:

Input: "Hello, my name is John"
Output: 5
 */
public class string_434_number_of_segments_in_a_string {
    public static int countSegments(String s) {
        int index = 0;
        boolean isIn = false;
        for (int i = 0; i < s.length(); i ++){
            if (isIn){
                if (s.charAt(i) == ' '){
                    isIn = false;
                }
            }else {
                if (s.charAt(i) == ' '){

                }else {
                    isIn = true;
                    index ++;
                }
            }
        }
        return index;
    }

    public static void main(String[] args) {
        System.out.println(countSegments("Hello, my name is John"));
    }

    /**
     * 思路：没什么好讲的
     */
}
