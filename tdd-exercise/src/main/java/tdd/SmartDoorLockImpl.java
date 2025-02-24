package tdd;

public class SmartDoorLockImpl implements SmartDoorLock{

    private final int maxAttempts;
    private int pin;
    private int failedAttempts;
    private boolean locked;
    private boolean blocked;
    private boolean isPinSet;

    public SmartDoorLockImpl(final int maxAttempts) {
        this.maxAttempts = maxAttempts;
        reset();
    }

    @Override
    public void setPin(int pin) {
        if (!locked) {
            this.pin = pin;
            this.isPinSet = true;
        }
    }

    @Override
    public void unlock(int pin) {
        if (!this.blocked) {
            if (this.pin == pin) {
                this.locked = false;
            } else {
                this.failedAttempts++;
                if (this.failedAttempts == this.maxAttempts) {
                    this.blocked = true;
                }
            }
        }
    }

    @Override
    public void lock() {
        if (isPinSet) {
            this.locked = true;
        } else {
            throw new IllegalStateException("Pin has not been set!");
        }
    }

    @Override
    public boolean isLocked() {
        return this.locked;
    }

    @Override
    public boolean isBlocked() {
        return this.blocked;
    }

    @Override
    public int getMaxAttempts() {
        return this.maxAttempts;
    }

    @Override
    public int getFailedAttempts() {
        return this.failedAttempts;
    }

    @Override
    public void reset() {
        this.failedAttempts = 0;
        this.locked = false;
        this.blocked = false;
        this.isPinSet = false;
    }
}
