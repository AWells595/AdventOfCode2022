import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Directory {

    private String name;
    private ArrayList<String> contents = new ArrayList<>();
    ArrayList<Directory> directoryList = new ArrayList<>();

    public Directory(String name, ArrayList<String> contents){
        this.name = name;
        this.contents = contents;
    }

    public Directory(String name){
        this.name = name;
    }

    public Directory(){

    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setContents(ArrayList<String> contents){
        this.contents = contents;
    }

    public ArrayList<String> getContents(){
        return this.contents;
    }

    public void print(){
        System.out.println("Directory name: " + name);
        for(String s:contents){
            System.out.println(s);
        }
    }

    public ArrayList<String> readFile() throws FileNotFoundException {
        File file = new File("src/Resources/FileSystem.txt");
        Scanner scnr = new Scanner(file);
        ArrayList<String> fileContents = new ArrayList<>();
        while(scnr.hasNext()){
            fileContents.add(scnr.nextLine());
        }
        return fileContents;
    }

    public void listOfDirectories(ArrayList<String> fileContents){
        directoryList.add(new Directory("dir /"));
        for(String s:fileContents){
            String[] split = s.split("\s");
            if(split[0].equals("dir")){
                Directory directory = new Directory(s);
                directoryList.add(directory);
            }
        }
    }

    public void directoryContents(ArrayList<String> fileContents){
        ArrayList<String> contentsList = new ArrayList<>();
        int directoryIndex = 0;
        for(String s:fileContents){
            if(s.equals("$ cd ..")){
                System.out.println(3);
                continue;
            }
            else if(s.contains("$ cd")){
                System.out.println(1);
                if(contentsList.size() != 0) {
                    directoryList.get(directoryIndex).setContents(contentsList);
                    contentsList = new ArrayList<>();
                }
                String[] split = s.split("\s");
                String toFind = "dir " + split[2]; // last index is directory name
                for(Directory d:directoryList){
                    if(d.getName().equals(toFind)){
                        directoryIndex = directoryList.indexOf(d);
                        System.out.println(directoryIndex);
                    }
                }
            }
            else if(s.contains("$ ls")){
                System.out.println(2);
                continue;
            }
            else{
                System.out.println(4);
                contentsList.add(s);
            }
        }
        for(Directory d:directoryList){
            d.print();
        }

    }
}
