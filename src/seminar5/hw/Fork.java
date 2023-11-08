package seminar5.hw;

public class Fork {
    private volatile boolean isTaken;

    public boolean isTaken() {
        return isTaken;
    }

    public synchronized void takeFork(){
        isTaken = true;
    }

    public synchronized void putFork(){
        isTaken = false;
    }
}
