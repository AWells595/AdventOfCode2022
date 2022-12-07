import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Driver {
    public static void main(String[] args) throws FileNotFoundException {
        final long startTime = System.nanoTime();
        Directory directory = new Directory();
        ArrayList<String> fileContents = new ArrayList<>(directory.readFile());
        directory.listOfDirectories(fileContents);
        directory.directoryContents(fileContents);
        final long duration = System.nanoTime() - startTime;
        System.out.println(duration/1000000.0);
    }
}
