package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class MinMaxStackImplTest {

    private MinMaxStack minMaxStack;
    private final int[] exampleArray = {3, 2, 1};
    private final int lastElement = exampleArray[exampleArray.length-1];
    private final int minElement = 1;
    private final int maxElement = 3;

    @BeforeEach
    public void setup() {
        minMaxStack = new MinMaxStackImpl();
    }

    @Test
    public void isInitiallyEmpty() {
        assertTrue(minMaxStack.isEmpty());
        assertEquals(0, minMaxStack.size());
    }

    private void pushArray(int[] array) {
        for (int value : array) {
            minMaxStack.push(value);
        }
    }

    @Test
    public void canPushMultipleValues() {
        pushArray(exampleArray);
        assertFalse(minMaxStack.isEmpty());
        assertEquals(exampleArray.length, minMaxStack.size());
    }


    @Test
    public void canPopLastElement() {
        pushArray(exampleArray);
        int value = minMaxStack.pop();
        assertEquals(exampleArray.length-1, minMaxStack.size());
        assertEquals(lastElement, value);
    }

    @Test
    public void cannotPopOrPeekIfEmpty() {
        assertThrows(IllegalStateException.class, () -> minMaxStack.pop());
        assertThrows(IllegalStateException.class, () -> minMaxStack.peek());
    }

    @Test
    public void canRetrieve() {
        pushArray(exampleArray);
        int value = minMaxStack.peek();
        assertEquals(exampleArray.length, minMaxStack.size());
        assertEquals(lastElement, value);
    }

    @Test
    public void canGetMinAndMax() {
        pushArray(exampleArray);
        assertEquals(minElement, minMaxStack.getMin());
        assertEquals(maxElement, minMaxStack.getMax());
        assertEquals(exampleArray.length, minMaxStack.size());
    }

    @Test
    public void cannotGetMinAndMaxIfEmpty() {
        assertThrows(IllegalStateException.class, () -> minMaxStack.getMin());
        assertThrows(IllegalStateException.class, () -> minMaxStack.getMax());
    }
}