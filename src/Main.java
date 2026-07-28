public class Main {
    public static void main(String[] args) {
        System.out.println("--------------------------------");
        System.out.println("  Welcome to the Swift Tunes  ");
        System.out.println("--------------------------------");
        Songs songs=new Songs();//class song obj
        MusicPlayer musicPlayer=new MusicPlayer();//class MusicPlayer obj
        boolean again=true;

        while(again){
            songs.displaySongs();
            int choice=songs.userChoices();
            again=musicPlayer.musicSelect(choice,songs);
        }
        System.out.println("Thank you for using the Music Player!");
    }
}
