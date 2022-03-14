package cp.week10;

public class Point {
    public Counter point1;
    public Counter point2;

    public Point(){
        this.point1 = new Counter(0);
        this.point2 = new Counter(0);
    }

    public boolean areEqual(Counter point1, Counter point2){
        synchronized(point1){
            synchronized(point2){
                return point1.getI() == point2.getI();
            }
        }
    }
}
