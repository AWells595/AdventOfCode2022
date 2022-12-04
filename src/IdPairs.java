import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class IdPairs {
    private ArrayList<String> fileContents = new ArrayList<>();
    private String[] splitString;
    private String[] verySplitString;
    private ArrayList<Integer> pairsList = new ArrayList<>();
    private int numPairs;

    public IdPairs(){
        this.numPairs = 0;
    }

    public void readFile() throws FileNotFoundException {
        File file = new File("src/Resources/IDPairs.txt");
        Scanner scnr = new Scanner(file);
        int i = 0;
        while (scnr.hasNext()){
            fileContents.add(scnr.nextLine());
            splitString = fileContents.get(i++).split("-");
            for(String s:splitString){
                verySplitString = s.split(",");
                for(String v:verySplitString){
                    pairsList.add(Integer.parseInt(v));
                }
            }
        }
    }


    public int checkPairs() throws FileNotFoundException {
        readFile();
        numPairs = 0;
        for(int i = 0; i < pairsList.size(); i = i + 4){
            if((pairsList.get(i) >= pairsList.get(i + 2) && pairsList.get(i + 1) <= pairsList.get(i + 3)) ||
                    (pairsList.get(i + 2) >= pairsList.get(i) && pairsList.get(i + 3) <= pairsList.get(i + 1))){
                numPairs++;
            }
        }
        return numPairs;
    }

    public int checkOverlap() throws FileNotFoundException {
        readFile();
        numPairs = 0;
        // did it this way to logic it out a bit easier
        int leftMin, leftMax, rightMin, rightMax;
        for(int i = 0; i < pairsList.size(); i = i + 4){
            leftMin = pairsList.get(i);
            leftMax = pairsList.get(i + 1);
            rightMin = pairsList.get(i + 2);
            rightMax = pairsList.get(i  + 3);

            if(!((leftMin < rightMin && leftMax < rightMin) || (leftMin > rightMax && leftMax > rightMax))){
                numPairs++;
            }
        }
        return numPairs;
    }

}
