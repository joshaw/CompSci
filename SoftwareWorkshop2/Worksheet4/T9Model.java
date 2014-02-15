import java.util.Observable;
public final class T9Model extends Observable {

    private int currentNumber;

    public T9Model() {
        currentNumber = 0;
    }

    public int getCounter() {
        return currentNumber;
    }

    public void setCounter(int counter) {
        currentNumber = counter;
        setChanged();
        notifyObservers();
    }

    public void IncrementCounter() {
        currentNumber ++;
        setChanged();
        notifyObservers(currentNumber);
    }

    public void decrementCounter() {
        currentNumber --;
        setChanged();
        notifyObservers(currentNumber);
    }
}
