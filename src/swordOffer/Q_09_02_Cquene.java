package swordOffer;

import normal_struct.ListNode;

import java.util.Stack;

public class Q_09_02_Cquene {
    int count = 0;
    ListNode head;
    ListNode tail;
    public Q_09_02_Cquene() {

    }

    public void appendTail(int value) {
        ListNode node = new ListNode(value);
        if (head == null){
            head = node;
            tail = head;
        }else {
            tail.next = node;
            tail = tail.next;
        }
        count ++;
    }

    public int deleteHead() {
        if (head == null || count == 0){
            return -1;
        }else {
            int val = head.val;
            head = head.next;
            count --;
            return val;
        }
    }

    /**
     * Your CQueue object will be instantiated and called as such:
     * CQueue obj = new CQueue();
     * obj.appendTail(value);
     * int param_2 = obj.deleteHead();
     */
}
