package tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    private CircularQueue circularQueue;
    private final int[] exampleArray = {0,1,2};
    private final int CAPACITY = exampleArray.length;

    @BeforeEach
    public void setup() {
        circularQueue = new CircularQueueImpl(CAPACITY);
    }

    @Test
    public void isInitiallyEmpty() {
        assertTrue(circularQueue.isEmpty());
        assertEquals(0, circularQueue.getSize());
        assertEquals(CAPACITY, circularQueue.getCapacity());
    }

    private void enqueueArray(int[] array) {
        for (int value: array) {
            circularQueue.enqueue(value);
        }
    }

    @Test
    public void canEnqueueMultipleTimes() {
        enqueueArray(exampleArray);
        assertEquals(exampleArray.length, circularQueue.getSize());
        assertTrue(circularQueue.isFull());
    }

    @Test
    public void canDequeueOldestElement() {
        enqueueArray(exampleArray);
        assertEquals(exampleArray[0], circularQueue.dequeue());
        assertEquals(exampleArray[1], circularQueue.dequeue());
        assertEquals(exampleArray[2], circularQueue.dequeue());
        assertTrue(circularQueue.isEmpty());
    }

    @Test
    public void cannotDequeueIfEmpty() {
        assertThrows(IllegalStateException.class, () -> circularQueue.dequeue());
    }

    @Test
    public void canOverwriteAndDequeueCorrectly() {
        enqueueArray(exampleArray);
        for (int i = CAPACITY; i < 100; i++) {
            circularQueue.enqueue(i);
            assertEquals(i-CAPACITY+1, circularQueue.dequeue());
        }
    }

}
