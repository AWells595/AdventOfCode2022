import java.io.FileNotFoundException;

public class Driver {
    public static void main(String[] args) throws FileNotFoundException {
        final long startTime = System.nanoTime();
        CraneMovements crane = new CraneMovements();
        crane.createLinkedLists();
        final long duration = System.nanoTime() - startTime;
        System.out.println(duration);
    }
}
