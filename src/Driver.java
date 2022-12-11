import java.io.FileNotFoundException;

public class Driver {
    public static void main(String[] args) throws FileNotFoundException {
        final long startTime = System.nanoTime();
        VisibleTrees visible = new VisibleTrees();
        System.out.println(visible.getNumTreesVisible(visible.parseInput()));
        final long duration = System.nanoTime() - startTime;
        System.out.println(duration/1000000.0);
    }
}
