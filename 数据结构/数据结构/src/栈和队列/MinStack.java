package 栈和队列;

import java.util.Stack;

/**
 * @author yolo
 * @date 2020/3/22-22:37
 */
public class MinStack {
    Stack<Integer> stack;
    Stack<Integer> helpStack;
    /** initialize your data structure here. */
    public MinStack() {
        stack=new Stack<>();
        helpStack=new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if(helpStack.isEmpty()||x<=helpStack.peek()){
            helpStack.push(x);
        }else {
            helpStack.push(helpStack.peek());
        }
    }

    public void pop() {
        if(!stack.isEmpty()){
            stack.pop();
            helpStack.pop();
        }
    }

    public int top() {
        if(!stack.isEmpty()){
            return stack.peek();
        }
        throw new RuntimeException("栈为空");

    }

    public int getMin() {
        if(!helpStack.isEmpty()){
            return helpStack.pop();
        }
        throw new RuntimeException("栈为空");
    }
}
