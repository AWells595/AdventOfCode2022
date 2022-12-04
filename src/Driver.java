import java.io.FileNotFoundException;

public class Driver {
    public static void main(String[] args) throws FileNotFoundException {
        final long startTime = System.nanoTime();
        decryptedCheatSheet cheatSheet = new decryptedCheatSheet();
        //Rucksack sack = new Rucksack();
        System.out.println(cheatSheet.scoreGame());
        //System.out.println(sack.calculateGroupPriority());
        final long duration = System.nanoTime() - startTime;
        System.out.println(duration);
    }
}
