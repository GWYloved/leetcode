package string;
/*
You are given a string representing an attendance record for a student. The record only contains the following three characters:
'A' : Absent.
'L' : Late.
'P' : Present.
A student could be rewarded if his attendance record doesn't contain more than one 'A' (absent) or more than two continuous 'L' (late).

You need to return whether the student could be rewarded according to his attendance record.

Example 1:
Input: "PPALLP"
Output: True
Example 2:
Input: "PPALLL"
Output: False
 */
public class string_551_student_attendance_record_l {
    public boolean checkRecord(String s) {
        int P = 0;
        int A = 0;
        int L = 0;
        boolean isLastL = false;
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == 'A'){
                isLastL = false;
                A++;
            }else if (s.charAt(i) == 'L'){
                if (isLastL){
                    L++;
                }else {
                    L = 1;
                    isLastL = true;
                }
            }else {
                isLastL = false;
            }
            if (A > 1 || L > 2){
                return false;
            }
        }
        return true;
    }
    /**
     * boring
     */
}
