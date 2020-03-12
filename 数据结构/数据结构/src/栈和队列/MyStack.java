package 栈和队列;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yolo
 * @date 2020/3/12-23:14
 */
public class MyStack {
    Queue<Integer>queue;
    public MyStack() {
        queue=new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        queue.poll();
    }

    /** Get the top element. */
    public int top() {

    }

    /** Returns whether the stack is empty. */
    public boolean empty() {

    }
}
