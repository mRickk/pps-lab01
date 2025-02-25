package tdd;

/**
 *  Task 3 - TDD for Circular Queue
 *  A simple CircularQueue that stores integers with a **fixed** capacity.
 *  When full, new elements overwrite the oldest ones.
 *  
 *  When removing elements, the oldest ones are removed first.
 *  Therefore, giving [4, 5, 3], the first element to be removed is 4, then 5, and finally 3.
 *  
 *  For the exercise: 
 *   - Think about the test cases you need to write.
 *   - Introduce methods in the interface in order to make the tests pass.
 *   - Refactor
 */
public interface CircularQueue {

    /**
     *
     * @param value to insert at the beginning of the queue.
     *              If the queue is full, the first element is overwritten by this value.
     */
    void enqueue(int value);

    /**
     *
     * @return the oldest element of the queue.
     * @throws IllegalStateException if empty.
     */
    int dequeue();

    /**
     *
     * @return true if empty, false otherwise.
     */
    boolean isEmpty();

    /**
     *
     * @return true if full, false otherwise.
     */
    boolean isFull();

    /**
     *
     * @return the number of elements in the queue.
     */
    int getSize();

    /**
     *
     * @return the fixed capacity of the queue.
     */
    int getCapacity();

}