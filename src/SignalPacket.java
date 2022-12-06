import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class SignalPacket {
    private String fileString;
    private int numsRead;

    public SignalPacket(){
        this.numsRead = 0;
    }

    public void readFile() throws FileNotFoundException {
        File file = new File("src/Resources/Signal.txt");
        Scanner scnr = new Scanner(file);
        fileString = scnr.nextLine();
    }

    public int countToStartOfPacket(int charsToFind){
        for(int i = 0; i < fileString.length(); i++){
            ArrayList<Character> temp = new ArrayList<>();
            temp.add(fileString.charAt(i));

            if(temp.contains(fileString.charAt(i + 1))){
                continue;
            }
            temp.add(fileString.charAt(i + 1));
            if(temp.contains(fileString.charAt(i + 2))){
                continue;
            }
            temp.add(fileString.charAt(i + 2));

            if(temp.contains(fileString.charAt(i + 3))){
                continue;
            }
            temp.add(fileString.charAt(i + 3));
            if(temp.contains(fileString.charAt(i + 4))){
                continue;
            }
            temp.add(fileString.charAt(i + 4));
            if(temp.contains(fileString.charAt(i + 5))){
                continue;
            }
            temp.add(fileString.charAt(i + 5));

            if(temp.contains(fileString.charAt(i + 6))){
                continue;
            }
            temp.add(fileString.charAt(i + 6));
            if(temp.contains(fileString.charAt(i + 7))){
                continue;
            }
            temp.add(fileString.charAt(i + 7));
            if(temp.contains(fileString.charAt(i + 8))){
                continue;
            }
            temp.add(fileString.charAt(i + 8));

            if(temp.contains(fileString.charAt(i + 9))){
                continue;
            }
            temp.add(fileString.charAt(i + 9));
            if(temp.contains(fileString.charAt(i + 10))){
                continue;
            }
            temp.add(fileString.charAt(i + 10));
            if(temp.contains(fileString.charAt(i + 11))){
                continue;
            }
            temp.add(fileString.charAt(i + 11));

            if(temp.contains(fileString.charAt(i + 12))){
                continue;
            }
            temp.add(fileString.charAt(i + 12));
            if(temp.contains(fileString.charAt(i + 13))){
                continue;
            }
            temp.add(fileString.charAt(i + 13));
            return numsRead = i + 14;
        }
        return numsRead;
    }


}
