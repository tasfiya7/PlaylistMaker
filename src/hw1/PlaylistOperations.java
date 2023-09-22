/**
 * Tasfiya Mubasshira
 * 114870281
 * CSE 214 sec 7
 * @author Tasfiya Mubasshira
 * 
 * The PlaylistOperations class contains the main method to test out all the operations the user can execute.
 * 
 */
package hw1;
import java.util.Scanner;

public class PlaylistOperations extends Playlist {
	
	private static Playlist playlist =new Playlist();

	
	/**
	 * The main method runs a menu that asks the user for input to execute an opperation. 
	 * Additional information may be asked of the user to perform the operation chosen. If the user choose "Q" it will terminate the program.
	 * @param args
	 */
	public static void main (String[] args) {
		String input;
		
		String artist=null;
		int position=0;
		
		Scanner sc= new Scanner (System.in);
		
		do {
			
			mainMenu();
			System.out.println("Select a menu option: ");
			
		input=sc.nextLine().toUpperCase(); // disregard case in user's inut
			
		switch(input) { // operates based on user's choice
		
		case "A": // creates SongRecord Object and adds to Playlist after checking for errors/exceptions
			try {
			SongRecord songRecord=new SongRecord();
			System.out.println("Enter the song title: ");
			String title= sc.nextLine(); 
			System.out.println("Enter the song artist: ");
			artist= sc.nextLine(); 
			System.out.println("Enter the song length (minutes): "); 
			int min = Integer.parseInt(sc.nextLine());
			System.out.println("Enter the song length (seconds): ");
			int sec= Integer.parseInt(sc.nextLine());
			System.out.println("Enter the song position: ");
			position= Integer.parseInt(sc.nextLine());
			songRecord.setTitle(title);
			songRecord.setArtist(artist);
			songRecord.setMin(min);
			songRecord.setSec(sec);
			playlist.addSong(songRecord, position);
			
			System.out.println("Song added: " + title + " By " + artist);
            }
            catch(IllegalArgumentException ie) {
            	System.out.println("This is not a valid position");
            }
            catch(FullPlaylistException ie) {
        		System.out.println("The Playlist is full. There is no more room to add a song");
        	}	
			catch(IncorrectSecondsException ie ) {
				System.out.println("The seconds of the SongRecord is Invalid. It must be between 0 and 59.");
			}
			catch(IncorrectMinutesException ie ) {
				System.out.println("The minutes of the SongRecord is Invalid. It cannot be negative.");
			}
            break;
        case "B": // creates a new Playlist with SongRecords of the same artist and displays the new Playlist
        	System.out.println("Enter the artist: ");
        	artist= sc.next();
        	Playlist sameArtist= getSongsByArtist(playlist, artist);
        	sameArtist.toString();
            break;
        case "G": // displays the SongRecord and its title, artist, and length at a speciic position in the Playlist after checking for error/exceptions
        	System.out.println("Enter the position of the song: ");
        	position=sc.nextInt();
        	try {
        	
            SongRecord sr=playlist.getSong(position);

            System.out.println("...............................................................");
            System.out.printf("%11s%20s%11s%11s\n", "Song#", "Title", "Artist", "Length");
            System.out.printf("%11s%20s%11s%11s", position, sr.getTitle(), sr.getArtist(), sr.getMin());
            System.out.print(":" + sr.getSec());
            System.out.println();
        	}
        	catch(IllegalArgumentException ie)	{

        		System.out.println("Invalid position.");

        	}
            break;
        case "R": // removes the SongRecord at a position after checking fro errors/exceptions
        	try {
        	System.out.println("Enter the position of the song being removed: ");
        	position=sc.nextInt();
            playlist.removeSong(position);
            System.out.println("Song removed at position "+ position);
        	}
        	catch (IllegalArgumentException ie){
        		System.out.println("Invalid position to remove song from");
        	}

            break;
        case "P": // displays playlist formatted
            playlist.toString();
            break;
        case "S": // shows how many SOngRecords are in the Playlist
            int s= playlist.size();
            System.out.println("There are " + s + " song(s) in the current playlist.");
            break;
        case "Q": // stops program
            System.out.println("Program terminated.");
            System.exit(0);
            break;
        default: // incorrect input
            System.out.println("Not an Option. Try Again");
		
		} 
	
			
			
			
	} while(input !="Q"); // While "Q" is not inputed the menu will repeat
		
		
	}
	
	
	/**
	 * This method displays all the options in the menu
	 */
	public static void mainMenu() {

        System.out.println("A) Add Song");
        System.out.println("B) Print Songs by Artist");
        System.out.println("G) Get Song");
        System.out.println("R) Remove Song");
        System.out.println("F) Select Floor");
        System.out.println("P) Print All Songs");
        System.out.println("S) Size");
        System.out.println("Q) Quit");
        System.out.println();
    }
	
	
	public static void music() {
		
	}
	
}
