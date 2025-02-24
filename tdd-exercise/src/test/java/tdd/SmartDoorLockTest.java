package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SmartDoorLockTest {

    private final int PIN = 1234;
    private SmartDoorLock smartDoorLock;

    @BeforeEach
    public void setup() {
        smartDoorLock = new SmartDoorLockImpl(3);
    }

    @Test
    public void isInitiallyOpen() {
        assertFalse(smartDoorLock.isLocked());
    }

    private void setPinAndLockDoor() {
        smartDoorLock.setPin(PIN);
        smartDoorLock.lock();
    }

    @Test
    public void canSetPinAndLock() {
        setPinAndLockDoor();
        assertTrue(smartDoorLock.isLocked());
    }

    @Test
    public void canUnlock() {
        setPinAndLockDoor();
        smartDoorLock.unlock(PIN);
        assertFalse(smartDoorLock.isLocked());
    }

    @Test
    public void cannotSetPinWhenLocked() {
        setPinAndLockDoor();
        smartDoorLock.setPin(5678);
        smartDoorLock.unlock(5678);
        assertTrue(smartDoorLock.isLocked());
    }

    @Test
    public void cannotLockIfPinIsNotSet() {
        assertThrows(IllegalStateException.class, () -> smartDoorLock.lock());
    }

    private void blockDoor() {
        for (int i=0; i < smartDoorLock.getMaxAttempts(); i++) {
            smartDoorLock.unlock(5678);
        }
    }

    @Test
    public void doesItLockAfterMaxAttempts() {
        setPinAndLockDoor();
        blockDoor();
        assertEquals(smartDoorLock.getFailedAttempts(), smartDoorLock.getMaxAttempts());
        assertTrue(smartDoorLock.isBlocked());
    }

    @Test
    public void cannotUnlockWhenBlocked() {
        setPinAndLockDoor();
        blockDoor();
        smartDoorLock.unlock(PIN);
        assertTrue(smartDoorLock.isLocked());
    }

    @Test
    public void canReset() {
        setPinAndLockDoor();
        blockDoor();
        smartDoorLock.reset();
        assertFalse(smartDoorLock.isLocked());
        assertFalse(smartDoorLock.isBlocked());
    }

}
