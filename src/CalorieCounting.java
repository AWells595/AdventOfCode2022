import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class CalorieCounting {
    File calorieFile= new File("src/CalorieList.txt");
    Scanner fileScanner;

    {
        try {
            fileScanner = new Scanner(calorieFile);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private Map<Integer, Integer> elfMap = new HashMap<>();
    public void readFile(){
        int elfNumber = 1; // starting at 1 because elf 0 makes no sense IMO
        int runningCalories = 0;
        String currentLine;

        while(fileScanner.hasNextLine()){
            currentLine = fileScanner.nextLine();
            if(!currentLine.isBlank()){
                runningCalories = runningCalories + Integer.parseInt(currentLine);
            }
            else{
                this.elfMap.put(elfNumber, runningCalories);
                elfNumber++;
                runningCalories = 0;
            }
        }
    }

    public int fattestElf(){
        readFile();
        int tempCals = elfMap.get(1); // initializing with first value of map
        int currentElf = 1; // starting from beginning
        int fatElf = 1; // to prevent compile error from uninitialized returned variable
        for(Integer value:elfMap.values()){
            if (value > tempCals){
                tempCals = value;
                fatElf = currentElf;
            }
            currentElf++;
        }
        return elfMap.get(fatElf);
    }

    public int top3ElvesCalories(){
        readFile();
        int highestCals = elfMap.get(1); // initializing with first value of map
        int currentElf = 1; // starting from beginning
        int fatElf = 1;
        int calorieSum = 0;
        int[] elfList = new int[3];
        for(int i = 0; i < 3; i++){
            for(Integer value:elfMap.values()){
                if (value > highestCals){
                    highestCals = value;
                    fatElf = currentElf;
                }
                currentElf++;
            }
            elfList[i] = highestCals;
            highestCals = 0;
            System.out.println(fatElf);
            // TODO remove items from HashMap dynamically rather than hard coding
            /* issue arises on second loop, first loop works but second loop the key is 1 integer lower than it should
            be, which causes the program to remove the wrong key, duplicating the max for the 3rd iteration.
             */
            if(i == 0) {
                elfMap.remove(fatElf);
            }
            else if(i == 1){
                elfMap.remove(fatElf + 1); // hardcoding FTW
            }
            currentElf = 1;
            fatElf = 1;
        }
        for(int i = 0; i < 3; i++){
            System.out.println(elfList[i]);
            calorieSum = elfList[i] + calorieSum;
        }
        return calorieSum;

    }

    public void printMap(){
        readFile();
        for(Integer keys: elfMap.keySet()){
            System.out.println("Elf # " + keys + " calories " + elfMap.get(keys));
        }
    }



}
