package cp.week9;

public class counter {
    private int i;

    public counter(int i){
        this.i = i;
    }

    public synchronized void increment(){
        i++;
    }

    public synchronized void decrement(){
        i--;
    }

    public int getI(){
        return i;
    }
}
