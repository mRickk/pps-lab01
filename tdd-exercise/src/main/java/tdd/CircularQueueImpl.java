package tdd;

import java.util.ArrayList;
import java.util.List;

public class CircularQueueImpl implements CircularQueue {

    private final List<Integer> queue;
    private final int capacity;
    private int frontIndex;
    private int rearIndex;

    public CircularQueueImpl(int capacity) {
        queue = new ArrayList<>(capacity);
        this.capacity = capacity;
        this.frontIndex = 0;
        this.rearIndex = 0;
        for (int i = 0; i < capacity; i++) {
            queue.add(-1);
        }
    }


    @Override
    public void enqueue(int value) {
        if (isFull()) {
            frontIndex++;
        }
        queue.set(rearIndex % capacity, value);
        rearIndex++;
    }

    @Override
    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Cannot dequeue if empty!");
        }
        int value = queue.get(frontIndex % capacity);
        frontIndex++;
        return value;
    }

    @Override
    public boolean isEmpty() {
        return getSize() == 0;
    }

    @Override
    public boolean isFull() {
        return !isEmpty() && (rearIndex % capacity) == (frontIndex % capacity);
    }

    @Override
    public int getSize() {
        return rearIndex - frontIndex;
    }

    @Override
    public int getCapacity() {
        return capacity;
    }
}
