import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class CraneMovements {
    // This is some of the most cursed code I will ever write
    private Map<Integer, LinkedList<String>> positionnMap = new HashMap<>();
    private ArrayList<String> startingPositionsFromFile = new ArrayList<>();
    private ArrayList<String> movemntsFromFile = new ArrayList<>();
    private Map<Integer, ArrayList<Integer>> moveCommands = new HashMap<>();
    private String topPositions;


    public CraneMovements() {
        this.topPositions = "";
    }

    public void readStatingPositions() throws FileNotFoundException {
        File file = new File("src/Resources/StartingPositions.txt");
        Scanner scnr = new Scanner(file);
        Map<Integer, String[]> tempMap = new HashMap<>();
        LinkedList<String> tempLL = null;

        while(scnr.hasNextLine()){
            startingPositionsFromFile.add(scnr.nextLine());
        }
        int i = 0;

        for(String s:startingPositionsFromFile){
            tempMap.put(i++, s.split("\s"));
        }

        i = 1;
        for(String[] value:tempMap.values()){
            tempLL = new LinkedList<>(Arrays.asList(value)); // sexy
            positionnMap.put(i++, tempLL);
        }
    }

    public void readMovements() throws FileNotFoundException {
        File file = new File("src/resources/Movements.txt");
        Scanner scnr = new Scanner(file);
        while(scnr.hasNext()) {
            movemntsFromFile.add(scnr.nextLine());
        }

        for(int i = 0; i < movemntsFromFile.size(); i++){
            ArrayList<Integer> intList = new ArrayList<>();
            String[] temp;
            temp = movemntsFromFile.get(i).split("\s");

            intList.add(Integer.valueOf(temp[1]));
            intList.add(Integer.valueOf(temp[3]));
            intList.add(Integer.valueOf(temp[5]));

            moveCommands.put(i + 1, intList);
        }

    }

    public void moveItems() throws FileNotFoundException {
        readStatingPositions();
        int numItems, moveFrom, moveTo;
        String itemMoved;
        for(ArrayList<Integer> list:moveCommands.values()){
            numItems = list.get(0);
            moveFrom = list.get(1);
            moveTo = list.get(2);

            for(int i = 0; i < numItems; i++){
                itemMoved = positionnMap.get(moveFrom).getFirst();
                positionnMap.get(moveFrom).removeFirst();
                positionnMap.get(moveTo).addFirst(itemMoved);
            }
        }
    }

    public void moveMultipleItems() {
        //
        int numItems, moveFrom, moveTo;
        for(ArrayList<Integer> list:moveCommands.values()) {
            numItems = list.get(0);
            moveFrom = list.get(1);
            moveTo = list.get(2);
            ArrayList<String> itemsMoved = new ArrayList<>();

            if(numItems > positionnMap.get(moveFrom).size()){
                numItems = positionnMap.get(moveFrom).size();
            }

            for(int k = numItems - 1; k >= 0; k--) {
                itemsMoved.add(positionnMap.get(moveFrom).get(k));
            }
            for(int k = 0; k < numItems; k++){
                positionnMap.get(moveFrom).removeFirst();
            }
            for(int k = 0; k < numItems; k++){
                positionnMap.get(moveTo).addFirst(itemsMoved.get(k));
            }
        }
    }

    public String  getFirstItems() throws FileNotFoundException {
        moveItems();
        for(Integer line:positionnMap.keySet()){
            topPositions = positionnMap.get(line).getFirst() + topPositions;
        }
        return topPositions;
    }

    public String getItemsMultiple() throws FileNotFoundException {
        moveMultipleItems();
        for(Integer line:positionnMap.keySet()){
            System.out.println(positionnMap.get(line));
            try {
                topPositions = positionnMap.get(line).getFirst() + topPositions;
            } catch (Exception e){
                continue;
            }

        }
        return topPositions;
    }
}


