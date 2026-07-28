import javax.sound.sampled.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MusicPlayer {

    boolean musicSelect(int choice, Songs songs) {
        File file = new File(songs.filePath.get(choice - 1));
        System.out.println("Song playing: " + songs.songNames.get(choice - 1) +" By Tylor Swift");

        Scanner scan=new Scanner(System.in);
        try(AudioInputStream audio= AudioSystem.getAudioInputStream(file)){
            Clip clip=AudioSystem.getClip();
            clip.open(audio);

            String response="";
            System.out.println("P = Play");
            System.out.println("S = Stop");
            System.out.println("R = Reset");
            System.out.println("F = Forward");
            System.out.println("B = Backward");
            System.out.println("Q = Quit");
            while(!response.equals("Q")){

                System.out.print("\nEnter your response: ");
                response=scan.nextLine().toUpperCase();

                switch(response){
                    case "P"->{
                        clip.start();
                        System.out.println("▶ Playing....");
                    }
                    case "S"->{
                        clip.stop();
                        System.out.println("⏸ Stopped....");
                    }
                    case "R"-> {
                        clip.setMicrosecondPosition(0);
                        System.out.println("↺ Reset....");
                    }
                    case "F" -> {
                        long newPosition = clip.getMicrosecondPosition() + 10_000_000; // 10 seconds forwards
                        clip.setMicrosecondPosition(newPosition);
                        clip.start();
                        System.out.println("⏭ 10 seconds forward....");
                    }
                    case "B" -> {
                        long newPosition = clip.getMicrosecondPosition() - 10_000_000; // 10 seconds backwards
                        if (newPosition < 0) {
                            newPosition = 0;
                        }
                        clip.setMicrosecondPosition(newPosition);
                        clip.start();
                        System.out.println("⏮  10 seconds backward....");
                    }
                    case "Q"->{

                        while (true) {

                            System.out.print("Do you want to listen to another song? (Y/N): ");
                            String answer = scan.nextLine().toUpperCase();

                            if (answer.equals("Y")) {
                                clip.close();
                                return true;
                            }

                            else if (answer.equals("N")) {
                                clip.close();
                                return false;
                            }

                            else {
                                System.out.println("Invalid input! Please enter Y or N.");
                            }
                        }
                    }

                    default -> System.out.println("Invalid response!");

                }
            }
            clip.close();

        }
        catch(FileNotFoundException e){
            System.out.println("File not found");
        }
        catch(UnsupportedAudioFileException e){
            System.out.println("File format not supported");
        } catch (LineUnavailableException e) {
            System.out.println("Unavailable to access the file");
        }
        catch(IOException e){
            System.out.println("Something went wrong");
        }
        return false;
    }



}
