package array;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/*
For a non-negative integer X, the array-form of X is an array of its digits in left to right order.  For example, if X = 1231, then the array form is [1,2,3,1].

Given the array-form A of a non-negative integer X, return the array-form of the integer X+K.



Example 1:

Input: A = [1,2,0,0], K = 34
Output: [1,2,3,4]
Explanation: 1200 + 34 = 1234
Example 2:

Input: A = [2,7,4], K = 181
Output: [4,5,5]
Explanation: 274 + 181 = 455
Example 3:

Input: A = [2,1,5], K = 806
Output: [1,0,2,1]
Explanation: 215 + 806 = 1021
Example 4:

Input: A = [9,9,9,9,9,9,9,9,9,9], K = 1
Output: [1,0,0,0,0,0,0,0,0,0,0]
Explanation: 9999999999 + 1 = 10000000000


Note：

1 <= A.length <= 10000
0 <= A[i] <= 9
0 <= K <= 10000
If A.length > 1, then A[0] != 0
 */
public class array_989_add_to_array_form_of_integer {
    public static List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> Klist = new LinkedList<>();
        if (K > 0){
            while (K > 0){
                int t = K % 10;
                K /= 10;
                Klist.add(t);
            }
        }else {
            Klist.add(0);
        }
        LinkedList<Integer> temp = new LinkedList<>();
        int length = Math.max(Klist.size(), A.length);
        int flag = 0;
        for (int i = 0; i < length; i ++){
            int tt = 0;
            if (i >= A.length){
                tt = Klist.get(i) + flag;
            }else if (i >= Klist.size()){
                tt = A[A.length - 1 - i]+ flag;
            }else {
                tt = Klist.get(i) + A[A.length - 1 - i] + flag;
            }
            flag = 0;
            if (tt >= 10){
                flag = 1;
            }
            temp.addFirst(tt % 10);
        }
        if (flag == 1){
            temp.addFirst(1);
        }
        return temp;
    }

    public static void main(String[] args) {
        System.out.println(addToArrayForm(new int[]{1,2,0,0},34));
        System.out.println(addToArrayForm(new int[]{2,7,4},181));
        System.out.println(addToArrayForm(new int[]{2,1,5},806));
        System.out.println(addToArrayForm(new int[]{9,9,9},1));
        System.out.println(addToArrayForm(new int[]{9,9,9,9,9,9,9,9,9,9},1));
    }

    /**
     * 思路：刚开始认为用大数可以解决问题，后来发现太年轻，之后使用拆解数组的方式进行计算，感觉还是有点问题
     * 之后我决定使用arraylist作为存储接口，拆解了数组放入进行处理。
     * 但是有个问题就是arraylist的插入的复杂度较高（插入头部需要每次都进行挪动，为O（n^2）），因此只beat了34%
     * 这题有个track，就是不需要对生成的结果进行查找，因此用linkedlist比较好，linkedlist可以beat100%
     */
}
