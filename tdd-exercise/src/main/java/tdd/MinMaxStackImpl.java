package tdd;

import java.util.EmptyStackException;
import java.util.Stack;

public class MinMaxStackImpl implements MinMaxStack {

    private final Stack<Integer> stack = new Stack<Integer>();
    private int min = Integer.MAX_VALUE;
    private int max = Integer.MIN_VALUE;

    @Override
    public void push(int value) {
        this.stack.push(value);
        if (value < this.min) {
            min = value;
        }
        if (value > this.max) {
            max = value;
        }
    }

    @Override
    public int pop() {
        try {
            return this.stack.pop();
        } catch (EmptyStackException e) {
            throw new IllegalStateException("Cannot pop if stack is empty!");
        }
    }

    @Override
    public int peek() {
        try {
            return this.stack.peek();
        } catch (EmptyStackException e) {
            throw new IllegalStateException("Cannot peek if stack is empty!");
        }
    }

    @Override
    public int getMin() {
        if (this.stack.isEmpty()) {
            throw new IllegalStateException("Cannot retrieve min value if empty!");
        }
        return this.min;
    }

    @Override
    public int getMax() {
        if (this.stack.isEmpty()) {
            throw new IllegalStateException("Cannot retrieve max value if empty!");
        }
        return this.max;
    }

    @Override
    public boolean isEmpty() {
        return this.stack.isEmpty();
    }

    @Override
    public int size() {
        return this.stack.size();
    }
}
