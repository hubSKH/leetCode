package audition;

import java.util.Stack;

/**
 * 面试题30. 包含min函数的栈
 * @Description
 * 定义栈的数据结构，
 * 请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，
 * 调用 min、push 及 pop 的时间复杂度都是 O(1)。
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.min();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.min();   --> 返回 -2.
 * @auther SHENKAIHUAN
 * @create 2020-04-23 23:59
 */
public class MinStack {
    Stack<Integer> stackA;
    Stack<Integer> stackB;
    /** initialize your data structure here. */
    public MinStack() {
        stackA=new Stack<> ();
        stackB=new Stack<> ();
    }

    public void push(int x) {
        stackA.push (x);
        if(stackB.isEmpty ()||stackB.peek ()>=x){
            stackB.push (x);
        }

    }

    public void pop() {
        if (stackA.pop ().equals (stackB.peek ())){
            stackB.pop ();
        }
    }

    public int top() {
        return stackA.peek ();
    }

    public int min() {
        return stackB.peek ();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.min();
        minStack.pop();
        minStack.top();
        minStack.min();
    }
}
