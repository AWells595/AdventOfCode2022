import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Rucksack {
    private ArrayList<String> fileStrings = new ArrayList<>();
    private ArrayList<String> commonList = new ArrayList<>();
    private ArrayList<String> badgeList = new ArrayList<>();
    private int totalPriority;
    private int totalGroupPriority;
    private Map<String, Integer> scoreMap = new HashMap<>();

    public Rucksack(){
        this.totalPriority = 0;
        this.totalGroupPriority = 0;
        // lower case
        scoreMap.put("a", 1);
        scoreMap.put("b", 2);
        scoreMap.put("c", 3);
        scoreMap.put("d", 4);
        scoreMap.put("e", 5);
        scoreMap.put("f", 6);
        scoreMap.put("g", 7);
        scoreMap.put("h", 8);
        scoreMap.put("i", 9);
        scoreMap.put("j", 10);
        scoreMap.put("k", 11);
        scoreMap.put("l", 12);
        scoreMap.put("m", 13);
        scoreMap.put("n", 14);
        scoreMap.put("o", 15);
        scoreMap.put("p", 16);
        scoreMap.put("q", 17);
        scoreMap.put("r", 18);
        scoreMap.put("s", 19);
        scoreMap.put("t", 20);
        scoreMap.put("u", 21);
        scoreMap.put("v", 22);
        scoreMap.put("w", 23);
        scoreMap.put("x", 24);
        scoreMap.put("y", 25);
        scoreMap.put("z", 26);
        // upper case
        scoreMap.put("A", 27);
        scoreMap.put("B", 28);
        scoreMap.put("C", 29);
        scoreMap.put("D", 30);
        scoreMap.put("E", 31);
        scoreMap.put("F", 32);
        scoreMap.put("G", 33);
        scoreMap.put("H", 34);
        scoreMap.put("I", 35);
        scoreMap.put("J", 36);
        scoreMap.put("K", 37);
        scoreMap.put("L", 38);
        scoreMap.put("M", 39);
        scoreMap.put("N", 40);
        scoreMap.put("O", 41);
        scoreMap.put("P", 42);
        scoreMap.put("Q", 43);
        scoreMap.put("R", 44);
        scoreMap.put("S", 45);
        scoreMap.put("T", 46);
        scoreMap.put("U", 47);
        scoreMap.put("V", 48);
        scoreMap.put("W", 49);
        scoreMap.put("X", 50);
        scoreMap.put("Y", 51);
        scoreMap.put("Z", 52);
    }

    public void readFile() throws FileNotFoundException {
        File file = new File("src/Resources/Rucksack.txt");
        int i = 0;
        Scanner fileReader = new Scanner(file);
        while(fileReader.hasNext()){
            fileStrings.add(fileReader.nextLine());
            i++;
        }
    }

    public void getCommonItems() throws FileNotFoundException {
        int midString;
        String s;
        readFile();

        for (String fileString : fileStrings) {
            midString = fileString.length() / 2;
            String[] parts = {fileString.substring(0, midString),
                    fileString.substring(midString)};

            for (int j = 0; j < parts[0].length(); j++) {
                s = String.valueOf(parts[0].charAt(j));
                if (parts[1].contains(s)) {
                    addToList(s);
                    break;
                }
            }
        }
    }

    public void addToList(String s){
        this.commonList.add(s);
    }

    public void addToBadgeList(String s){
        this.badgeList.add(s);
    }

    public int calculatePriority() throws FileNotFoundException {
        getCommonItems();
        for(String s:commonList){
            this.totalPriority = totalPriority + scoreMap.get(s);
        }
        return this.totalPriority;
    }

    public void getCommonBadges() throws FileNotFoundException {
        String s;
        readFile();

        for(int i = 0; i < fileStrings.size(); i = i + 3){
            for(int j = 0; j < fileStrings.get(i).length(); j++){
                s = String.valueOf(fileStrings.get(i).charAt(j));
                if(fileStrings.get(i + 1).contains(s) && fileStrings.get(i + 2).contains(s)){
                    addToBadgeList(s);
                    break;
                }
            }
        }
    }

    public int calculateGroupPriority() throws FileNotFoundException {
        getCommonBadges();
        for(String s:badgeList){
            totalGroupPriority = totalGroupPriority + scoreMap.get(s);
        }
        return totalGroupPriority;
    }

}
