import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class CraneMovements {
    private Map<Integer, LinkedList<String>> positionnMap = new HashMap<>();
    private ArrayList<String> startingPositionsFileContents = new ArrayList<>();
    private Map<Integer, String> stringMap = new HashMap<>();
    private String topPositions;
    private String[] splitString;
    private String[] verySplitString;

    public CraneMovements() {
        this.topPositions = "";
    }

    public void readStatingPositions() throws FileNotFoundException {
        File file = new File("src/Resources/StartingPositions.txt");
        Scanner scnr = new Scanner(file);
        String tempString = "";
        while(scnr.hasNext()) {
            startingPositionsFileContents.add(scnr.nextLine());
        }
        splitString = new String[startingPositionsFileContents.size()];
        for (String startingPositionsFileContent : startingPositionsFileContents) {
            splitString = startingPositionsFileContent.split("\\[");
            for (String s : splitString) {
                if (s != null) {
                    s = s.replace(']', ' ');
                    verySplitString = s.split("\s");
                    int i = 0;
                    for(String v:verySplitString){
                        if(v.equals("1") || v.equals("2") || v.equals("3") ||
                                v.equals("4") || v.equals("5") || v.equals("6") ||
                                v.equals("7") || v.equals("8") || v.equals("9")){
                            stringMap.put(i++, tempString);
                            tempString = "";
                        }
                        tempString = v + tempString;
                        System.out.println(tempString);
                    }
                }
            }
            for(String value:stringMap.values()){
                System.out.println(value);
            }
        }
    }

    public void createLinkedLists() throws FileNotFoundException {
        String currentString = "";
        LinkedList<String> tempList = new LinkedList<>();
        readStatingPositions();
        int j = 0;
        for(int i = 0; i < verySplitString.length; i++){
            if(verySplitString[i].equals("1") || verySplitString[i].equals("2") || verySplitString[i].equals("3") ||
                    verySplitString[i].equals("4") || verySplitString[i].equals("5") || verySplitString[i].equals("6") ||
                    verySplitString[i].equals("7") || verySplitString[i].equals("8") || verySplitString[i].equals("9")){
                positionnMap.put(i + 1, tempList);
            }
            else{
                System.out.println(verySplitString[i]);
                tempList.add(verySplitString[i]);
                System.out.println(tempList);
            }
        }
        System.out.println(positionnMap.get(1));
    }



    public void readMoveList() throws FileNotFoundException {
        File file = new File("src/Resources/Movements.txt");
        Scanner scnr = new Scanner(file);

    }
}
