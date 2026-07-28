//libraries
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Songs {

    //song path
    String[] paths={
            "src\\music\\music1.wav",
            "src\\music\\music2.wav",
            "src\\music\\music2.wav",
            "src\\music\\music3.wav",
            "src\\music\\music1.wav",
            "src\\music\\music2.wav",
            "src\\music\\music3.wav",
            "src\\music\\music1.wav",
            "src\\music\\music2.wav",
            "src\\music\\music3.wav",

    };

    // declaring arraylist of file path and song name
    ArrayList<String> filePath=new ArrayList<>(Arrays.asList(paths));
    ArrayList<String> songNames=new ArrayList<>();

    //constructor storing song name
    public Songs(){
        setSongNames();
    }

    //setting song names
    void setSongNames(){
        System.out.println("-----Swift Tunes Playlist-----");
        songNames.add("August");
        songNames.add("Cruel Summer");
        songNames.add("Paper Rings");
        songNames.add("DayLight");
        songNames.add("Enchanted");
        songNames.add("Fate of Ophelia");
        songNames.add("Gorgeous");
        songNames.add("Labyrinth");
        songNames.add("Love Story");
        songNames.add("You're On Your Own Kid");

    }

    //displaying the list of songs
    void displaySongs(){
        int count=1;

        for(String songName:songNames){
            System.out.println(count+". "+songName);
            count++;
        }

    }
    int userChoices(){
        int choice;
        Scanner scan=new Scanner(System.in);
        System.out.println("--------------------------------");
        do{
            System.out.print("Enter your choice: ");
            choice=scan.nextInt();

            if(choice<1 || choice>10){
                System.out.println("Invalid choice!");
                System.out.println("Try again!");
            }

        }while(choice<1 || choice>10);


        return choice;
    }







}
