package cp.week10;

public class Counter {
    private int i;

    public Counter(int i){
        this.i = i;
    }

    public void increment(){
        synchronized(this){
        i++;
        }
    }

    public void decrement(){
        synchronized(this){
        i--;
        }
    }

    public int getI(){
        synchronized(this){
        return i;
        }
    }
}
