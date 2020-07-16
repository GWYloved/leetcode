package math;
/*
Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB
    ...
Example 1:

Input: 1
Output: "A"
Example 2:

Input: 28
Output: "AB"
Example 3:

Input: 701
Output: "ZY"
 */
public class math_168_excel_sheet_column_title {
    public static String convertToTitle(int n) {
        if (n <= 0){
            return "";
        }
        n --;
        String result = "";
        while (n > 0){
            int t = n % 26;
            if (t > 0){
                result += (char)('A'+t);
            }
            
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(convertToTitle(G('A')));
        System.out.println(convertToTitle(G('A')+1));
        System.out.println(convertToTitle(G('A')+2));
        System.out.println(convertToTitle(G('A')*G('A')));
    }

    public static int G(int t){
        return t - 'A';
    }
}
