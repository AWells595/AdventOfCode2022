import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class SpaceSaving {

    public ArrayList<String> readFile() throws FileNotFoundException {
        File file = new File("src/Resources/FileSystem.txt");
        Scanner scnr = new Scanner(file);
        ArrayList<String> fileContents = new ArrayList<>();



        return fileContents;
    }
}
