import java.io.FileNotFoundException;

public class Driver {
    public static void main(String[] args) throws FileNotFoundException {
        final long startTime = System.nanoTime();
        IdPairs pairs = new IdPairs();
        //System.out.println(pairs.checkPairs());
        System.out.println(pairs.checkOverlap());
        final long duration = System.nanoTime() - startTime;
        System.out.println(duration);
    }
}
