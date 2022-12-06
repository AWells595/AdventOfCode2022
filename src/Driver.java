import java.io.FileNotFoundException;

public class Driver {
    public static void main(String[] args) throws FileNotFoundException {
        final long startTime = System.nanoTime();
        CraneMovements crane = new CraneMovements();
        crane.readMovements();
        crane.readStatingPositions();
       // System.out.println(crane.getFirstItems());
        System.out.println(crane.getItemsMultiple());
        final long duration = System.nanoTime() - startTime;
        System.out.println(duration/1000000.0);
    }
}
