package 栈和队列;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yolo
 * @date 2020/3/12-23:14
 * 队列实现栈（用一个队列实现）
 * 队列：先进先出--队尾入队，队首出队
 * 栈：先进后出--栈顶入栈，栈顶出栈
 *      压栈push:直接入队，即可实现入栈操作
 *      出栈pop:先出队列，再入队列，循环进行size-1次-->循环结束进行第size次出队列操作，此时出队元素边是栈顶元素
 *      查看栈顶top:先出队列，再入队列，循环进行size-1次-->循环结束进行第size次出队列操作，用temp临时遍历进行保存,入队temp-->返回temp，此时的temp即为栈顶元素
 *      判空isEmpty:队列为空，栈就为空-->判断队列是否为空即可，并返回结果
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
        int size=queue.size();
        for (int i = 0; i <size-1 ; i++) {
            int temp=queue.poll();
            queue.add(temp);
        }
        return queue.poll();
    }

    /** Get the top element. */
    public int top() {
        int size=queue.size();
        for (int i = 0; i < size-1; i++) {
            int temp=queue.poll();
            queue.add(temp);
        }
        int top=queue.poll();
        queue.add(top);
        return top;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}
