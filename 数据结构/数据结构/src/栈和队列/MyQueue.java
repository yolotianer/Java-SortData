package 栈和队列;

import java.util.Stack;

/**
 * @author yolo
 * @date 2020/3/22-22:14
 */
public class MyQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2=new Stack();
    /** Initialize your data structure here. */
    public MyQueue() {
        stack1=new Stack();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        int size=stack1.size();
        for (int i = 0; i <size-1 ; i++) {
            int temp = stack1.pop();
            stack2.push(temp);
        }
        int pop = stack1.pop();

        while (!stack2.isEmpty()){
            int temp = stack2.pop();
            stack1.push(temp);
        }
        return pop;

    }

    /** Get the front element. */
    public int peek() {
        int size=stack1.size();
        for (int i = 0; i <size-1 ; i++) {
            Integer temp = stack1.pop();
            stack2.push(temp);
        }
        int peek=stack1.peek();
        while (!stack2.isEmpty()){
            int temp = stack2.pop();
            stack1.push(temp);
        }
        return peek;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.isEmpty();
    }
}
