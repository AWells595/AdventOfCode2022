import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class decryptedCheatSheet {

    private Map<String, String> opponentMoves = new HashMap<>();
    private Map<String, Integer> winScores = new HashMap<>();
    private Map<Integer, String> fileContents = new HashMap<>();
    private Map<String, String> winStateNeeded = new HashMap<>();
    private  Map<String, Integer> moveScore = new HashMap<>();
    private String opposingMove;
    private String myMove;
    private String myWinState;
    private int totalScore;

    public decryptedCheatSheet(){
        opponentMoves.put("A", "Rock");
        opponentMoves.put("B", "Paper");
        opponentMoves.put("C", "Scissors");

        winStateNeeded.put("X", "Lose");
        winStateNeeded.put("Y", "Draw");
        winStateNeeded.put("Z", "Win");

        moveScore.put("Scissors", 3);
        moveScore.put("Paper", 2);
        moveScore.put("Rock", 1);

        winScores.put("Win", 6);
        winScores.put("Draw", 3);
        winScores.put("Lose", 0);

        this.totalScore = 0;
       // this.myMove = "";
    }

    public void readFile() throws FileNotFoundException {
        File file = new File("src/Resources/RPS.txt");
        Scanner scnr = new Scanner(file);
        String currentLine;
        int i = 0;

        while(scnr.hasNext()){
            currentLine = scnr.nextLine();
            fileContents.put(i, currentLine);
            i++;
        }
    }

    public int scoreGame() throws FileNotFoundException {
        readFile();
        String[] currentRound;
        int roundScore;
        int i = 1;
        for(String value:fileContents.values()){
            roundScore = 0;
            currentRound = value.split("\s");
            opposingMove = opponentMoves.get(currentRound[0]);
            myWinState = winStateNeeded.get(currentRound[1]);
            moveNeeded(myWinState);
            roundScore = winScores.get(myWinState) + moveScore.get(myMove);
            totalScore = totalScore + roundScore;
            i++;
        }
        return totalScore;
    }

    public void moveNeeded(String myWinState){
        if(myWinState.equals("Draw")){
            myMove = opposingMove;
        } else if(opposingMove.equals("Rock")) {
            if (myWinState.equals("Win")) {
                myMove = "Paper";
            } else if (myWinState.equals("Lose")) {
                myMove = "Scissors";
            }
        } else if(opposingMove.equals("Paper")) {
            if (myWinState.equals("Win")) {
                myMove = "Scissors";
            } else if (myWinState.equals("Lose")) {
                myMove = "Rock";
            }
        } else if(opposingMove.equals("Scissors")) {
            if (myWinState.equals("Win")) {
                myMove = "Rock";
            } else if (myWinState.equals("Lose")) {
                myMove = "Paper";
            }
        }
    }

}


