package swordOffer;

import java.util.Stack;

public class Q_09_Cquene {
    Stack<Integer> stack1 = new Stack<>();//按队列顺序塞
    Stack<Integer> stack2 = new Stack<>();//按队列反过来塞
    public Q_09_Cquene() {

    }

    public void appendTail(int value) {
        //对尾部处理，只能改stack2
        while (stack1.size() != 0){
            stack2.push(stack1.pop());
        }
        stack2.push(value);
    }

    public int deleteHead() {
        while (stack2.size() != 0){
            stack1.push(stack2.pop());
        }
        if (stack1.size() == 0){
            return -1;
        }
        return stack1.pop();
    }

    /**
     * Your CQueue object will be instantiated and called as such:
     * CQueue obj = new CQueue();
     * obj.appendTail(value);
     * int param_2 = obj.deleteHead();
     */
}
