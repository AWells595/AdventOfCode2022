import javax.swing.plaf.synth.SynthUI;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VisibleTrees {
    private int numTreesVisible;
    private ArrayList<String> fileContents = new ArrayList<>();

    public VisibleTrees(){
        this.numTreesVisible = 0;
    }

    public void readFile(String fileName) throws FileNotFoundException {
        ArrayList<String> fileContents = new ArrayList<>();
        File file = new File(fileName);
        Scanner scnr = new Scanner(file);

        while(scnr.hasNext()){
            this.fileContents.add(scnr.nextLine());
        }

    }

    public ArrayList<ArrayList<Integer>> parseInput() throws FileNotFoundException {
        readFile("src/Resources/TreeHeights.txt");
        ArrayList<ArrayList<Integer>> parsedInput = new ArrayList<>();
        ArrayList<Integer> innerList = new ArrayList<>();
        for(String s:fileContents){
            for(int i = 0; i < s.length(); i++){
                String temp = String.valueOf(s.charAt(i)); // using char leads to ASCII conversion error
                //System.out.println(temp);
                innerList.add(Integer.valueOf(temp));
            }
            parsedInput.add(innerList);
        }
        return parsedInput;
    }

    /**
     * Needs to check if there is a sight-line to the tree
     * If on the edge there is always a sight-line so if j = 0, i = 0, i = sizeOuter - or j = sizeInner - 1
     * Then program needs to check all other trees vertically, so if all the trees are shorter it is visilbe
     * need to compare to end of the row and the end of the colum
     * so treeCompared > tree[i][j - end of row] or treeCompared > tree[i][j - start of row] or
     * tree compared > tree[i - top of column][j] || tree compared > tree[i - bottom of column][j]
     */
    public int getNumTreesVisible(ArrayList<ArrayList<Integer>> forrest){
        for(int i = 0; i < forrest.size(); i++){
            System.out.println(forrest.size());
            for(int j = 0; j < forrest.get(i).size(); j++){
                System.out.println(forrest.get(i).get(j));
            }
        }
        return numTreesVisible;
    }


}
