package swordOffer;

import normal_struct.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q_06_reversePrint {
    public int[] reversePrint(ListNode head) {
        List<Integer> result_temp = new ArrayList<>();
        while (head!= null){
            result_temp.add(head.val);
            head = head.next;
        }
        int size = result_temp.size();
        int[] result = new int[size];
        for (int i = 0; i < result.length; i++){
            result[i] = result_temp.get(size - 1 - i);
        }
        return result;
    }

    public int[] reversePrint2(ListNode head){
        Stack<Integer> result_temp = new Stack<>();
        while (head != null){
            result_temp.push(head.val);
            head = head.next;
        }
        int size = result_temp.size();
        int[] result = new int[size];
        int count = 0;
        while (result_temp.size() != 0){
            result[count] = result_temp.pop();
            count ++;
        }
        return result;
    }
}
